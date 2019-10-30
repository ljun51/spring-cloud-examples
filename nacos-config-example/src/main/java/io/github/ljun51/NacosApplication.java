package io.github.ljun51;

import com.alibaba.cloud.nacos.NacosConfigProperties;
import com.alibaba.nacos.api.config.listener.Listener;
import com.alibaba.nacos.client.config.NacosConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.StringReader;
import java.util.Properties;
import java.util.concurrent.Executor;

@SpringBootApplication
public class NacosApplication {


    public static void main(String[] args) {
        SpringApplication.run(NacosApplication.class, args);
    }
}

@Component
class SampleRunner implements ApplicationRunner {

    @Value("${user.name}")
    String userName;

    @Value("${user.age:25}")
    int userAge;

    @Autowired
    private NacosConfigProperties nacosConfigProperties;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println(String.format("Initial username=%s, userage=%d", userName, userAge));
        nacosConfigProperties.configServiceInstance().addListener("nacos-config-example.properties", "DEFAULT_GROUP", new Listener() {
            @Override
            public Executor getExecutor() {
                return null;
            }

            @Override
            public void receiveConfigInfo(String s) {
                Properties properties = new Properties();
                try {
                    properties.load(new StringReader(s));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println("config changed: " + properties);
            }
        });
    }
}

@RestController
@RefreshScope
class SampleController {
    @Value("${user.name}")
    String userName;

    @Value("${user.age:25}")
    int userAge;

    @RequestMapping("/user")
    public String simple() {
        return "Hello Nacos Config!" + "Hello " + userName + " " + userAge + "!";
    }
}
