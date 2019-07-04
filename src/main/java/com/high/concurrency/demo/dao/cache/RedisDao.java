package com.high.concurrency.demo.dao.cache;

import com.high.concurrency.demo.domain.Seckill;
import io.protostuff.LinkedBuffer;
import io.protostuff.ProtostuffIOUtil;
import io.protostuff.runtime.RuntimeSchema;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * @Author chenhe
 * @Date 2019/7/3 16:07
 * @Description
 */
public class RedisDao {

    private JedisPool jedisPool;

    private String SECKILL_KEY = "seckill";


    private final LinkedBuffer buf =  LinkedBuffer.allocate(LinkedBuffer.MIN_BUFFER_SIZE);

    public RedisDao(String ip, int port) {
        this.jedisPool = new JedisPool(ip, port);
    }
    private RuntimeSchema<Seckill> schema = RuntimeSchema.createFrom(Seckill.class);

    public Seckill getObj(Long seckillId){
        //redis操作逻辑
        Jedis jedis = jedisPool.getResource();
        try {
            String key =SECKILL_KEY + seckillId;
            //对象需要序列化 get -> byte[] -->反序列化 -->Object(seckill)
            //自定义序列化
            byte[] bytes = jedis.get(key.getBytes());
            //缓存反序列化
            if(null != bytes){
                Seckill seckill = schema.newMessage();
                ProtostuffIOUtil.mergeFrom(bytes, seckill, schema);
                return seckill;
            }

        } finally {
            jedis.close();
        }
        return null;
    }

    public String setObj(Seckill seckill){
        Jedis jedis = jedisPool.getResource();
        try {
            String key =SECKILL_KEY + seckill.getSeckillId();
            byte [] bytes = ProtostuffIOUtil.toByteArray(seckill, schema, buf);
            String result = jedis.setex(key.getBytes(),60*60 ,bytes);//ok or error msg
            return result;
        } finally {
            jedis.close();
        }

    }
}
