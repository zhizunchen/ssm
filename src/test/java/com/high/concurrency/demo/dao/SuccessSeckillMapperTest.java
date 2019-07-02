package com.high.concurrency.demo.dao;

import com.high.concurrency.demo.domain.SuccessSeckill;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:spring-dao.xml")
@ActiveProfiles("test")
public class SuccessSeckillMapperTest {
    /**
     * insert 可过滤重复数据
     * */
    void insertSuccessKill(Long seckillId,  Long userPhone){}

    /**
     * 查询 关联查询秒杀商品信息
     * */
    void queryByIdWithSeckill(Long seckillId){}


}