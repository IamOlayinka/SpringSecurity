package com.olayinka.Controller;


import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {


    @GetMapping("/")
    public String hello(HttpServletRequest request){
        return "Hello my people" + request.getSession().getId();
    }

    @GetMapping("/csrf-token")
    public CsrfToken getToken(HttpServletRequest request){
        return (CsrfToken) request.getAttribute("_csrf");
    }
    @GetMapping("/error")

    public String error(){
        return "There was an error";
    }

}
