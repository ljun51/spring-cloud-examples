package io.github.ljun51;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
public class ProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProviderApplication.class, args);
    }

    @RestController
    class EchoController {

        @RequestMapping(value = "/echo/{string}")
        public String echo(@PathVariable String string) {
            return "hello nacos discovery " + string;
        }

        @RequestMapping(value = "/divide")
        public String divide(@RequestParam Integer a, @RequestParam Integer b) {
            return String.valueOf(a / b);
        }
    }
}
