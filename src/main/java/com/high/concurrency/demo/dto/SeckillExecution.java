package com.high.concurrency.demo.dto;

import com.high.concurrency.demo.domain.SuccessSeckill;

/**
 * @Author chenhe
 * @Date 2019/7/2 14:39
 * @Description 秒杀执行结果
 */
public class SeckillExecution {

    private long seckillId;

    //秒杀执行结果
    private int state;

    //状态描述
    private String stateInfo;

    //秒杀成功对象
    private SuccessSeckill successSeckill;

    //failed
    public SeckillExecution(long seckillId, int state, String stateInfo) {
        this.seckillId = seckillId;
        this.state = state;
        this.stateInfo = stateInfo;
    }
    //success
    public SeckillExecution(long seckillId, int state, SuccessSeckill successSeckill) {
        this.seckillId = seckillId;
        this.state = state;
        this.successSeckill = successSeckill;
    }

    public long getSeckillId() {
        return seckillId;
    }

    public void setSeckillId(long seckillId) {
        this.seckillId = seckillId;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public void setStateInfo(String stateInfo) {
        this.stateInfo = stateInfo;
    }

    public SuccessSeckill getSuccessSeckill() {
        return successSeckill;
    }

    public void setSuccessSeckill(SuccessSeckill successSeckill) {
        this.successSeckill = successSeckill;
    }
}
