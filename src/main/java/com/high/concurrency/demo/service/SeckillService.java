package com.high.concurrency.demo.service;

import com.high.concurrency.demo.domain.Seckill;
import com.high.concurrency.demo.dto.Export;
import com.high.concurrency.demo.dto.SeckillExecution;
import java.util.List;

public interface SeckillService {

    /**
     * 查询单条秒杀数据
     **/
    Seckill queryById(Long seckillId);

    /**
     * 查询所有秒杀数据
     * int offset, int limit
     **/
    List<Seckill> queryAll();

    /**
     * 秒杀开启时输出秒杀接口地址
     * 否则输出系统时间和秒杀时间
     **/
    Export exportSeckillUrl(Long seckillId);

    /**
     * 执行秒杀
     **/
    SeckillExecution executeSeckill(Long seckillId, Long userPhone, String md5);

}
