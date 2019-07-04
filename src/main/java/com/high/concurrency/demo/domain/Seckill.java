package com.high.concurrency.demo.domain;

import java.io.Serializable;
import java.util.Date;

public class Seckill {

    /**
     * 商品库存id
     * 对应字段 : seckill_id
     */
    private Long seckillId;

    /**
     * 商品名称
     * 对应字段 : name
     */
    private String name;

    /**
     * 库存数量
     * 对应字段 : number
     */
    private Integer number;

    /**
     * 秒杀开启时间
     * 对应字段 : start_time
     */
    private Date startTime;

    /**
     * 秒杀结束时间
     * 对应字段 : end_time
     */
    private Date endTime;

    /**
     * 创建时间
     * 对应字段 : create_time
     */
    private Date createTime;

    public Long getSeckillId() {
        return seckillId;
    }

    public void setSeckillId(Long seckillId) {
        this.seckillId = seckillId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}