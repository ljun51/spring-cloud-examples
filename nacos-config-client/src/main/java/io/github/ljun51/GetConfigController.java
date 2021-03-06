package io.github.ljun51;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetConfigController {

    @Value("${config}")
    private String config;

    @GetMapping("/config")
    public String getConfig() {
        return config;
    }
}
