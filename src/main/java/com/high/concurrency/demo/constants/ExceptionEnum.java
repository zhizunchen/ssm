package com.high.concurrency.demo.constants;

public enum ExceptionEnum {

    ACCOUNT_NOT_EXIT(1000, "参加秒杀的账户不存在" ),
    SECKILL_FAILED(2000, "秒杀失败"),
    SUCCESS(0000, "SUCCESS");

    private int code;

    private String desc;

    ExceptionEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
