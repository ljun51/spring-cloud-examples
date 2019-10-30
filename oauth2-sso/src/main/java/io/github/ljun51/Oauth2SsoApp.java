package io.github.ljun51;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Oauth2SsoApp {

    public static void main(String[] args) {
        SpringApplication.run(Oauth2SsoApp.class, args);
    }

    @RequestMapping("/")
    public String home() {
        return "hello world";
    }
}