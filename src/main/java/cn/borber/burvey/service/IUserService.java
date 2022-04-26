package cn.borber.burvey.service;

import cn.borber.burvey.model.VO.UserLoginVO;
import cn.borber.burvey.model.VO.UserRegisterVO;

/**
 * @author BORBER
 */
public interface IUserService {
    /**
     * 查询是否有此用户
     * @param user 登录入参
     * @return 此用户ID
     */
    String checkByUser(UserLoginVO user);


    /**
     * 用户登录
     * @param user 登录入参
     * @return token
     */
    String login(UserLoginVO user);

    /**
     * 用户注册
     * @param user 用户详细资料
     * @return 注册成功
     */
    boolean register(UserRegisterVO user);

    /**
     * 用户登出
     * @return 登出成功
     */
    boolean logout();

    /**
     * 登出用户
     * @param token 用户token
     * @return 登出成功
     */
    boolean logout(String token);


    /**删除用户
     * @param id 用户ID
     * @return 删除成功
     */
    boolean delete(Long id);


}
