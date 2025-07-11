package com.xyd.teststudy.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class RedisIncrementExample {

    public static void main(String[] args) {
        // 配置Redis连接信息
        String redisHost = "localhost"; // Redis服务器地址
        int redisPort = 6379; // Redis服务器端口

        // 创建Jedis连接池
        JedisPoolConfig poolConfig = new JedisPoolConfig();
        JedisPool jedisPool = new JedisPool(poolConfig, redisHost, redisPort);

        try (Jedis jedis = jedisPool.getResource()) {
            // 使用INCR命令自增键的值
            String key = "counter";
            Long incrementedValue = jedis.incr(key);
            System.out.println("INCR Result: " + incrementedValue);

            // 使用INCRBY命令增加指定的增量
            String anotherKey = "another_counter";
            Long incrementedByValue = jedis.incrBy(anotherKey, 5); // 增加5
            System.out.println("INCRBY Result: " + incrementedByValue);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 关闭Jedis连接池
            jedisPool.close();
        }
    }
}

