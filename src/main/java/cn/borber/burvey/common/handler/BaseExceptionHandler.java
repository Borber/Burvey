package cn.borber.burvey.common.handler;

import cn.borber.burvey.common.exception.BaseException;
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
    @ExceptionHandler(value = BaseException.class)
    @ResponseBody
    public BaseResponseBody exceptionHandler(BaseException e){
        log.error(e.getMessage());
        return BaseResponseBody.fail(e.getErrorCode(), e.getMessage());
    }

    @ExceptionHandler(value = LoginException.class)
    @ResponseBody
    public BaseResponseBody loginExceptionHandler(LoginException e){
        return BaseResponseBody.fail(e.getErrorCode(), e.getMessage());
    }
}
