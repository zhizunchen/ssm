package com.high.concurrency.demo.dto;

/**
 * @Author chenhe
 * @Date 2019/7/3 11:27
 * @Description
 */
public class SeckillMessage<T> {

    private Boolean state;

    private int code;

    private String errorMsg;

    private T d;

    public SeckillMessage(Boolean state, T d) {
        this.state = state;
        this.d = d;
    }

    public SeckillMessage(Boolean state, int code, String errorMsg) {
        this.state = state;
        this.code = code;
        this.errorMsg = errorMsg;
    }

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public T getD() {
        return d;
    }

    public void setD(T d) {
        this.d = d;
    }
}
