package cn.borber.burvey.model;

import lombok.Data;

import java.io.Serializable;

/**
 * 包装统一返回体
 * @author BORBER
 * @param <T> 返回类型
 */
@Data
public class BaseResponseBody<T> implements Serializable {
    private Integer code;
    private String msg;
    private T data;
    private long timestamp ;

    public BaseResponseBody(){
        this.timestamp = System.currentTimeMillis();
    }

    public static <T> BaseResponseBody<T> success(T data) {
        BaseResponseBody<T> response = new BaseResponseBody<>();
        response.setCode(BaseResponseCode.RC0.getCode());
        response.setMsg(BaseResponseCode.RC0.getMessage());
        response.setData(data);
        return response;
    }

    public static BaseResponseBody fail(BaseResponseCode code) {
        BaseResponseBody response = new BaseResponseBody<>();
        response.setCode(code.getCode());
        response.setMsg(code.getMessage());
        return response;
    }

    public static BaseResponseBody fail(Integer code, String msg) {
        BaseResponseBody response = new BaseResponseBody<>();
        response.setCode(code);
        response.setMsg(msg);
        return response;
    }
}
