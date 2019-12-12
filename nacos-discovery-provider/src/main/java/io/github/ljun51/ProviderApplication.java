package io.github.ljun51;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * nacos 服务发现提供者
 */
@EnableDiscoveryClient
@SpringBootApplication
public class ProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProviderApplication.class, args);
    }

    @RestController
    class EchoController {

        @RequestMapping(value = "/", method = RequestMethod.GET)
        public ResponseEntity index() {
            return new ResponseEntity("index error", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        @RequestMapping(value = "/test", method = RequestMethod.GET)
        public ResponseEntity test() {
            return new ResponseEntity("error", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        @RequestMapping(value = "/sleep", method = RequestMethod.GET)
        public String sleep() {
            try {
                Thread.sleep(1000L);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "ok";
        }

        @RequestMapping(value = "/echo/{string}", method = RequestMethod.GET)
        public String echo(@PathVariable String string) {
            return "hello Nacos Discovery " + string;
        }

        @RequestMapping(value = "/divide", method = RequestMethod.GET)
        public String divide(@RequestParam Integer a, @RequestParam Integer b) {
            return String.valueOf(a / b);
        }
    }
}
