package com.patb.LearnSpringBoot;

import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Profile("prod")
public class MySimpleController {

    private final Calculator calculator;

    public MySimpleController(Calculator calculator) {
        this.calculator = calculator;
    }

    @RequestMapping(value={"/home"}, method = {RequestMethod.GET, RequestMethod.POST})
    public String home() {
        return "Hello, World!";
    }

    @GetMapping("/test")
    public String secondHome() {
        return "Hello, World 2!";
    }
    
    @GetMapping("/sum")
    public int sum(@RequestParam("a") int a, @RequestParam("b") int b) {
        return calculator.calculateSum(a, b);
    }
    
}
