package com.zero.manpo.models.error;

public class ErrorRelay {
    private boolean isSuccessful = false;
    private String errMsg = "";


    public boolean isSuccessful(){
        return isSuccessful;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setIsSuccessful(boolean isSuccessful) {
        this.isSuccessful = isSuccessful;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }
}
