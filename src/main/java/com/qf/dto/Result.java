package com.qf.dto;

public class Result<T> {
    private boolean success;//是否成功的标示
    private T data;//成功返回的信息
    private String errorMsg;//错误信息
    private int errCode;

    public Result(){}

    //成功的构造器
    public Result(boolean success,T data){
        this.success = success;
        this.data = data;
    }
    //错误的构造器

    public Result(boolean success, int errCode ,String errorMsg) {
        this.success = success;
        this.errorMsg = errorMsg;
        this.errCode = errCode;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public int getErrCode() {
        return errCode;
    }

    public void setErrCode(int errCode) {
        this.errCode = errCode;
    }
}
