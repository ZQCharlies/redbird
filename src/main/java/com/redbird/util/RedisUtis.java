package com.redbird.util;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * @Author wzq
 * @Date 2020/1/5 16:13
 * @Version 1.0
 */
public class RedisUtis {
    private static  final Logger logger= Logger.getLogger(RedisUtis.class);

    @Autowired
    private static JedisPool jedisPool;

    public RedisUtis(){}

    public static Jedis getJedis(){

        return jedisPool.getResource();
    }
}
