package cn.borber.burvey.service.impl;

import cn.borber.burvey.common.exception.BaseException;
import cn.borber.burvey.common.util.JsonUtil;
import cn.borber.burvey.mapper.UserMapper;
import cn.borber.burvey.model.BaseResponseBody;
import cn.borber.burvey.model.DO.UserDO;
import cn.borber.burvey.model.DTO.BaseUserDTO;
import cn.borber.burvey.model.UserContext;
import cn.borber.burvey.model.VO.UserLoginVO;
import cn.borber.burvey.model.VO.UserRegisterVO;
import cn.borber.burvey.service.IRedisService;
import cn.borber.burvey.service.IUserService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

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
        LambdaQueryWrapper<UserDO> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(UserDO::getName, user.getName())
                .eq(UserDO::getPassword, user.getPassword());
        UserDO one = userMapper.selectOne(wrapper);
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
        List<UserDO> list = new LambdaQueryChainWrapper<UserDO>(userMapper)
                .eq(UserDO::getName, user.getName())
                .list();
        if (list.size() > 0) {
            throw new BaseException("注册失败, 用户名已被占用");
        }
        UserDO newUser = new UserDO();
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
        LambdaQueryWrapper<UserDO> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(UserDO::getId, id);
        userMapper.delete(wrapper);
        return true;
    }
}
