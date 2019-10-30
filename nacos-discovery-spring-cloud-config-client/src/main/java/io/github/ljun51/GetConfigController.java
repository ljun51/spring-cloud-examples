package io.github.ljun51;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetConfigController {

    @Value("${config}")
    private String config;

    public String getConfig() {
        return config;
    }
}
