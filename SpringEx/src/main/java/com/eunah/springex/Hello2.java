package com.eunah.springex;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hello2 {

    @GetMapping("/test")
    public String test() {
        return "Hello World";
    }

}
