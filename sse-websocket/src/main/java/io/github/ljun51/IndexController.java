package io.github.ljun51;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lijun (ljun51@outlook.com)
 * @date 2020-09-30
 */
@RequestMapping()
@RestController
public class IndexController {

    @RequestMapping("/")
    public String index() {
        return "";
    }

    @RequestMapping("/test")
    public String test() {
        return "OK";
    }
}
