package com.high.concurrency.demo.dao;

import com.high.concurrency.demo.domain.Seckill;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface SeckillMapper {

    /**
     * 减库存
     * @return 影响的行数
     * */
    int reduceNumber(@Param("seckillId") Long seckillId, @Param("killTime") Date killTime);

    /**
     *  查询单条
     * */
    Seckill queryById(Long seckillId);

    /* 根据偏移量查询list
     *
     * @Param mybatis 提供的注解
     * java没有保存形参的记录
     * queryAll(int offset, int limit)--> queryAll(arg0, arg1)
     **/
    List<Seckill> queryAll(@Param("offset") int offset, @Param("limit") int limit);

}