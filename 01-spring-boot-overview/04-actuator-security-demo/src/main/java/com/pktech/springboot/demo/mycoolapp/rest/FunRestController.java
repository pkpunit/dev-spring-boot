package com.pktech.springboot.demo.mycoolapp.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

    // expose "/" end point that return hello world.
    @GetMapping("/")
    public String syyHello(){

        return "Hello World!";
    }

    //expose a new end point for workout

    @GetMapping("/workout")
    public String getDailyWorkOut(){

        return  "Run a hard 5 KM daily!";
    }
}
