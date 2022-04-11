package cn.borber.burvey.common.exception;

/**
 * @author BORBER
 */
public class LoginException extends BaseException{

    private Integer errorCode;

    private String errorMsg;

    public LoginException(String errorMsg) {
        super(errorMsg);
        this.errorCode = -2;
        this.errorMsg = errorMsg;
    }

    public LoginException(Integer errorCode, String errorMsg) {
        super(errorMsg);
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    @Override
    public Integer getErrorCode() {
        return errorCode;
    }

    @Override
    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

    @Override
    public String getErrorMsg() {
        return errorMsg;
    }

    @Override
    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    @Override
    public String getMessage() {
        return errorMsg;
    }

}
