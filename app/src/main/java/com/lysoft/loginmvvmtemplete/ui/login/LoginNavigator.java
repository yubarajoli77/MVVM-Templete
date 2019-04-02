package com.lysoft.loginmvvmtemplete.ui.login;

import com.lysoft.loginmvvmtemplete.ui.base.ErrorNavigator;

public interface LoginNavigator extends ErrorNavigator {
    void startForgotPasswordActivity();

    void startRegisterActivity();

    void onSkipedClicked();

    void login();

    void startMainActivity();

    void onLoginSuccessful(String email);

    /*
    Errors that may be send from server
    Note:- ErrorResponse is the pojo class that parse the error send back by server, which seems like this:

    public final class ErrorResponse {

    @Expose
    @SerializedName("error_code")
    private Integer errorCode;

    @Expose
    @SerializedName("success")
    private Integer success;

    @Expose
    @SerializedName("msg")
    private String message;

    private Integer httpErrorCode;

    public ErrorResponse() {
    }

    public ErrorResponse(String message) {
        this.message = message;
    }

    public Integer getErrorCode() {
        if(errorCode == null)
           return 0;
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

    public Integer getSuccess() {
        return success;
    }

    public void setSuccess(Integer success) {
        this.success = success;
    }

    public String getMessage() {
        if(message != null  && !TextUtils.isEmpty(message))
        return message.trim();

        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getHttpErrorCode() {
        return httpErrorCode;
    }

    public void setHttpErrorCode(Integer httpErrorCode) {
        this.httpErrorCode = httpErrorCode;
    }
}

If we need this class please make a separate class

    */



//    void onUserNotRegistered(ErrorResponse errorResponse);
//
//    void onAccountBanned(ErrorResponse errorResponse);
//
//    void onInvalidMobileOrEmail(ErrorResponse errorResponse);
//
//    void onWrongPassword(ErrorResponse errorResponse);
//
//    void onPasswordLengthError(ErrorResponse errorResponse);

}
