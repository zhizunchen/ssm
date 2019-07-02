package com.high.concurrency.demo.dao;

import com.high.concurrency.demo.domain.Seckill;

import java.util.Date;
import java.util.List;

public interface SeckillMapper {

    /**
     * 减库存
     *
     * @return 影响的行数
     * */
    int reduceNumber(Long seckillId, Date killTime);

    /**
     * 查询单条
     * */
    Seckill queryById(Long seckillId);

    /*
     * 根据偏移量查询list
     * */
    List<Seckill> queryAll(int offset, int limit);

}