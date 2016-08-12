package com.kdemo.redis.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.DefaultLettucePool;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettucePool;
import org.springframework.data.redis.core.RedisTemplate;

import com.kdemo.redis.dto.ProductDto;

import redis.clients.jedis.JedisPoolConfig;


@Configuration
public class RedisDatasourceConfiguration {
	
	/*
	 * Lettuce
	 */
	@Bean
	public LettucePool lettucePool() {
		return new DefaultLettucePool("localhost", 6379);
	}
	@Bean
	public RedisConnectionFactory lettuceConnectionFactory() {
		return new LettuceConnectionFactory(lettucePool());
	}
	
	
	/*
	 * Jedis
	 */
	@Bean
	public RedisConnectionFactory jedisConnectionFactory() {
		JedisPoolConfig poolConfig = new JedisPoolConfig();
		//return new JedisConnectionFactory(sentinelConfig , poolConfig);
		
		JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory(poolConfig);
		jedisConnectionFactory.setHostName("localhost");
		jedisConnectionFactory.setPort(6379);
		//jedisConnectionFactory.setDatabase(0);
		
		return jedisConnectionFactory;
		
	}
	
	@Bean
	public RedisTemplate<String, ProductDto> productRedisTemplate() {
		RedisTemplate<String, ProductDto> redisTemplate = new RedisTemplate<>();
		redisTemplate.setConnectionFactory(jedisConnectionFactory());
		return redisTemplate;
	}
}
