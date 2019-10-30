package io.github.ljun51;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {

    @RequestMapping(value = "/available")
    public String availabel() {
        return "Spring in Action";
    }

    @RequestMapping(value = "/checked-out")
    public String checkedout() {
        return "Spring Boot in Action";
    }
}
