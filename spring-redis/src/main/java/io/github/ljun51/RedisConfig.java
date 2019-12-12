package io.github.ljun51;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.keyvalue.core.KeyValueTemplate;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisNode;
import org.springframework.data.redis.connection.RedisSentinelConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisKeyValueAdapter;
import org.springframework.data.redis.core.RedisKeyValueTemplate;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.mapping.RedisMappingContext;
import redis.clients.jedis.JedisPoolConfig;

/**
 * Redis配置
 *
 * @author lijun <ljun51@outlook.com>
 * @create 2017-03-14 4:05 PM
 * @since 1.0.0
 */
@Configuration
public class RedisConfig {

    @Autowired
    private RedisClusterConfig config;

    @Bean
    public RedisConnectionFactory redisConnectionFactory() {
        RedisSentinelConfiguration configuration = new RedisSentinelConfiguration();
        configuration.setMaster(config.getMaster());
        configuration.setPassword(config.getPassword());
        for (String hostAndPort: config.getNodes()) {
            String[] s = hostAndPort.split(":");
            configuration.addSentinel(new RedisNode(s[0], Integer.parseInt(s[1])));
        }
        return new JedisConnectionFactory(configuration, new JedisPoolConfig());
    }

	@Bean
    public RedisTemplate redisTemplate() {
        return new StringRedisTemplate(redisConnectionFactory());
    }

    @Bean
    public KeyValueTemplate keyValueTemplate() {
        RedisKeyValueAdapter redisKeyValueAdapter = new RedisKeyValueAdapter(redisTemplate());
        RedisMappingContext redisMappingContext = new RedisMappingContext();
        return new RedisKeyValueTemplate(redisKeyValueAdapter, redisMappingContext);
    }
}
