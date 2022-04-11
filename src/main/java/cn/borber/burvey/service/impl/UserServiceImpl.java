package cn.borber.burvey.service.impl;

import cn.borber.burvey.common.util.JsonUtil;
import cn.borber.burvey.mapper.UserMapper;
import cn.borber.burvey.model.DAO.UserDAO;
import cn.borber.burvey.model.DTO.BaseUserDTO;
import cn.borber.burvey.model.UserContext;
import cn.borber.burvey.model.VO.UserLoginVO;
import cn.borber.burvey.model.VO.UserRegisterVO;
import cn.borber.burvey.service.IRedisService;
import cn.borber.burvey.service.IUserService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @author BORBER
 */
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private IRedisService redisService;

    @Autowired
    private UserMapper userMapper;

    @Override
    public Long checkByUser(UserLoginVO user) {
        LambdaQueryWrapper<UserDAO> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(UserDAO::getName, user.getName())
                .eq(UserDAO::getPassword, user.getPassword());
        UserDAO one = userMapper.selectOne(wrapper);
        return one == null ? -1 : one.getId();
    }

    @Override
    public String login(UserLoginVO user) {
        Long id = checkByUser(user);
        if (id != -1) {
            String token = UUID.randomUUID().toString().replaceAll("-", "");
            BaseUserDTO userDTO = new BaseUserDTO();
            userDTO.setToken(token);
            userDTO.setId(id);
            redisService.set(token, JsonUtil.toJson(userDTO));
            return token;
        } else {
            return null;
        }
    }

    @Override
    public boolean register(UserRegisterVO user) {
        UserDAO newUser = new UserDAO();
        BeanUtils.copyProperties(user, newUser);
        userMapper.insert(newUser);
        return true;
    }

    @Override
    public boolean logout() {
        return redisService.delete(UserContext.getUser().getToken());
    }

    @Override
    public boolean logout(String token) {
        return redisService.delete(token);
    }

    @Override
    public boolean delete(Long id) {
        LambdaQueryWrapper<UserDAO> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(UserDAO::getId, id);
        userMapper.delete(wrapper);
        return true;
    }
}
