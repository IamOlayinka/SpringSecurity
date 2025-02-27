package com.olayinka.Service;


import com.olayinka.Model.Users;
import com.olayinka.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsersService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    AuthenticationManager authManager;

  //Creating object of bcrypts for password hashing
  //Passing a strength 0f 12
    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);


    public Users registerUser(Users user){
        user.setPassword(encoder.encode(user.getPassword()));
        userRepo.save(user);
        return user;
    }

    public String verify(Users user) {
        Authentication authentication =
                authManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(),user.getPassword()));
        if(authentication.isAuthenticated()){
            return "success";
        }
        else
            return "fail";
    }
}
