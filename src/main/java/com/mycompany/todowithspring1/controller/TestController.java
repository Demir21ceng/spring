package com.mycompany.todowithspring1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {
    
     @GetMapping("/test")
    public String test() {
         System.out.println(">>> TEST CONTROLLER ÇALIŞTI");
        return "test";
    }
}
