package com.high.concurrency.demo.domain;

public class SuccessSeckillKey {

    /**
     * 商品库存id
     * 对应字段 : seckill_id
     */
    private Long seckillId;

    /**
     * 用户信息
     * 对应字段 : user_phone
     */
    private Long userPhone;

    public Long getSeckillId() {
        return seckillId;
    }

    public void setSeckillId(Long seckillId) {
        this.seckillId = seckillId;
    }

    public Long getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(Long userPhone) {
        this.userPhone = userPhone;
    }
}