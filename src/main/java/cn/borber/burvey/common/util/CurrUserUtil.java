package cn.borber.burvey.common.util;

import cn.borber.burvey.common.model.LoginUser;

/**
 * 认证用户
 * @author BORBER
 */
public class CurrUserUtil {
    private static final ThreadLocal<LoginUser> CURR_USER = new ThreadLocal<>();
    public static void set(LoginUser user){
        CURR_USER.set(user);
    }

    public static LoginUser get(){
        return CURR_USER.get();
    }

    public static void remove(){
        CURR_USER.remove();
    }
}
