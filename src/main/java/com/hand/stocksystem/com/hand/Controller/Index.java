package com.hand.stocksystem.com.hand.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Index {
    @RequestMapping(value = "/hello")
    public String Hello(){
        return "This is Hello.html";
    }
}
