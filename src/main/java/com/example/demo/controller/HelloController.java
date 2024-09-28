package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {
  @GetMapping ("/Hello")
    public String HelloPage(@RequestParam(required = false) String username){
//      String username;
        return "<h1>Hello," + username + "!</h1>";
    }
}
