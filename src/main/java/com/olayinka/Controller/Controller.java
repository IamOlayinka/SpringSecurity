package com.olayinka.Controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {


    @GetMapping("/")
    public String hello(){
        return "Hello my people";
    }

    @GetMapping("/error")

    public String error(){
        return "There was an error";
    }

}
