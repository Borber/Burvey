package cn.borber.burvey.service.impl;

import cn.borber.burvey.common.exception.BaseException;
import cn.borber.burvey.common.model.LoginUser;
import cn.borber.burvey.common.util.CurrUserUtil;
import cn.borber.burvey.common.util.JsonUtil;
import cn.borber.burvey.mapper.UserMapper;
import cn.borber.burvey.model.DO.UserDO;
import cn.borber.burvey.model.VO.UserLoginVO;
import cn.borber.burvey.model.VO.UserRegisterVO;
import cn.borber.burvey.service.IRedisService;
import cn.borber.burvey.service.IUserService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
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
    public String checkByUser(UserLoginVO user) {
        LambdaQueryWrapper<UserDO> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(UserDO::getName, user.getName())
                .eq(UserDO::getPassword, user.getPassword());
        UserDO one = userMapper.selectOne(wrapper);
        if (one == null) {
            throw new BaseException("登陆失败");
        }
        return one.getId().toString();
    }

    @Override
    public String login(UserLoginVO user) {
        String id = checkByUser(user);
        String token = UUID.randomUUID().toString().replaceAll("-", "");
        LoginUser loginUser = new LoginUser();
        loginUser.setUserId(id);
        loginUser.setToken(token);
        redisService.set(token, JsonUtil.toJson(loginUser));
        return token;
    }

    @Override
    public boolean register(UserRegisterVO user) {
        List<UserDO> list = new LambdaQueryChainWrapper<>(userMapper)
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
        return redisService.delete(CurrUserUtil.get().getToken());
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
