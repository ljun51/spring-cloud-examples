package io.github.ljun51;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@SpringBootApplication
@RestController
public class SpringRedisApp {

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * opsForXXX & boundXxxOps的区别：
     * 前者获取一个的operator，但是没有指定操作的对象（key），可以在一个连接（事务）内操作多个key以及对应的value；
     * 后者获取一个指定操作对象（key）的operator，在一个连接（事务）内只能操作这个key对应的value。
     */
    @Resource(name = "redisTemplate")
    private ValueOperations<String, String> valueOperations;

    public static void main(String[] args) {
        SpringApplication.run(SpringRedisApp.class, args);
    }

    @RequestMapping("/")
    public String index() {
        valueOperations.set("foo", "bared");
        return valueOperations.get("foo");
    }
}
