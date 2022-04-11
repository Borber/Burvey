package cn.borber.burvey.common.handler;

import cn.borber.burvey.common.exception.LoginException;
import cn.borber.burvey.model.BaseResponseBody;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author BORBER
 */
@Slf4j
@RestControllerAdvice
public class BaseExceptionHandler {
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public BaseResponseBody exceptionHandler(Exception e){
        log.error(e.getMessage());
        return BaseResponseBody.fail(-1, "服务端错误, 请稍后重试");
    }

    @ExceptionHandler(value = LoginException.class)
    @ResponseBody
    public BaseResponseBody loginExceptionHandler(Exception e){
        return BaseResponseBody.fail(-2, e.getMessage());
    }
}
