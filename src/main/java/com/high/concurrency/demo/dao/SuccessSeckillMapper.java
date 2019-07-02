package com.high.concurrency.demo.dao;

import com.high.concurrency.demo.domain.SuccessSeckill;
import org.apache.ibatis.annotations.Param;

public interface SuccessSeckillMapper {
    /**
     * insert 可过滤重复数据
     *
     * @return 影响的行数
     * */
    int insertSuccessKill(@Param("seckillId") Long seckillId, @Param("userPhone") Long userPhone);

    /**
     * 查询 关联查询秒杀商品信息
     * */
    SuccessSeckill queryByIdWithSeckill(@Param("seckillId") Long seckillId, @Param("userPhone") Long userPhone);

}