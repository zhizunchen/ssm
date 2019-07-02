package com.high.concurrency.demo.exception;

/**
 * @Author chenhe
 * @Date 2019/7/2 14:49
 * @Description 秒杀异常 （运行时异常 1 不需手动捕获 2 spring 事务捕获异常为运行时异常）
 */
public class SeckillException extends RuntimeException {

    //错误码
    private int code;

    public SeckillException(int code, String message) {
        super(message);
        this.code=code;
    }

    public SeckillException(int code, String message, Throwable cause) {
        super(message, cause);
        this.code=code;
    }
}
