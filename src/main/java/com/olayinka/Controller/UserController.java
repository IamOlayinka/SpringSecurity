package com.olayinka.Controller;


import com.olayinka.DTOs.UserLoginDTO;
import com.olayinka.Model.Users;
import com.olayinka.Service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UsersService usersService;

    @PostMapping("/register")
    public Users postUser (@RequestBody Users user){
      usersService.registerUser(user);
      return user;
    }



    @PostMapping("/login")
    public String login (@RequestBody UserLoginDTO user) {

        System.out.println(user);
        return usersService.verify(user);

    };

}
