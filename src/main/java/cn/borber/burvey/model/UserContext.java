package cn.borber.burvey.model;

import cn.borber.burvey.model.DTO.BaseUserDTO;

/**
 * @author BORBER
 */
public class UserContext {
    private static final ThreadLocal<BaseUserDTO> USER = new ThreadLocal<>();

    public static Long getUserId() {
        BaseUserDTO baseUserDTO = getUser();
        return baseUserDTO.getId();
    }

    public static BaseUserDTO getUser() {
        BaseUserDTO baseUser = USER.get();
        if (null == baseUser) {
//            throw new Exception("登录失效，请重新登录！");
        }
        return baseUser;
    }

    public static void setBaseUser(BaseUserDTO baseUser) {
        USER.set(baseUser);
    }

    public static void remove() {
        USER.remove();
    }




}
