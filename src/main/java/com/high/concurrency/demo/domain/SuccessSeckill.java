package com.high.concurrency.demo.domain;

import java.util.Date;

public class SuccessSeckill extends SuccessSeckillKey {
    /**
     * 状态标示（-1:无效， 0:成功 1:已付款 2 已发货）
     * 对应字段 : state
     */
    private Byte state;

    /**
     * 创建时间
     * 对应字段 : create_time
     */
    private Date createTime;

    /**
     * 多对一 复合属性
     * */
    private Seckill seckill;

    public Byte getState() {
        return state;
    }

    public void setState(Byte state) {
        this.state = state;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Seckill getSeckill() {
        return seckill;
    }

    public void setSeckill(Seckill seckill) {
        this.seckill = seckill;
    }
}