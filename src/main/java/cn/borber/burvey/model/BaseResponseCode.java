package cn.borber.burvey.model;

/**
 * @author BORBER
 */

public enum BaseResponseCode {
    /**请求成功**/
    RC0(0,"请求成功"),

    /**请求失败**/
    RC1(1,"请求失败, 请稍后重试"),

    /**未登录**/
    RC2(2,"请登录后尝试"),

    /**账号或密码错误**/
    RC3(-1, "账号或密码错误, 请重试");

    /**自定义状态码**/
    private final int code;
    /**自定义描述**/
    private final String message;

    BaseResponseCode(int code, String message){
        this.code = code;
        this.message = message;
    }


    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

}
