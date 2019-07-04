package com.high.concurrency.demo.dao;

import com.alibaba.fastjson.JSON;
import com.high.concurrency.demo.dao.cache.RedisDao;
import com.high.concurrency.demo.domain.Seckill;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * @Author chenhe
 * @Date 2019/7/3 17:19
 * @Description
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:spring-dao.xml")//spring配置文件
public class RedisDaoTest {

    @Autowired
    private RedisDao redisDao;

    @Resource
    private SeckillMapper seckillMapper;

    @Test
    public void test(){
        Seckill seckill = redisDao.getObj(1000L);
        if(null == seckill){
            seckill = seckillMapper.queryById(1000L);
            redisDao.setObj(seckill);
        }
        System.out.println(JSON.toJSON(redisDao.getObj(1000L)));

    }
}
