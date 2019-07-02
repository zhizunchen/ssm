package com.high.concurrency.demo.dao;

import com.alibaba.fastjson.JSON;
import com.high.concurrency.demo.domain.Seckill;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;
/**
 * 配置spring和junit整合，junit启动时加载spring IOC容器
 * */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:spring-dao.xml")//spring配置文件
@ActiveProfiles("dev")
public class SeckillMapperTest {

    @Resource
    private SeckillMapper seckillMapper;

    /*  减库存*/
    void reduceNumber(Long seckillId, Date killTime){

    }

    /* 查询单条 */
    @Test
    public void queryById(){
        Long seckillId = 1000L;

        System.out.println(JSON.toJSON(seckillMapper.queryById(seckillId)));
    }

    /* 根据偏移量查询list*/
    void queryAll(int offset, int limit){

    }
}