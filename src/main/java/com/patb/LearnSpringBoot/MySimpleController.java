package com.patb.LearnSpringBoot;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MySimpleController {

    @RequestMapping("/")
    public String home() {
        return "Hello, World!";
    }
}
