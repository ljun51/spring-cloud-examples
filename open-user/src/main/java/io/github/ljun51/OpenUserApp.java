package io.github.ljun51;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
//import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

//@EnableDiscoveryClient
@SpringBootApplication
public class OpenUserApp {

    public static void main(String[] args) {
        new SpringApplicationBuilder(OpenUserApp.class).web(WebApplicationType.SERVLET).run(args);
    }
}
