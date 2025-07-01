package com.olayinka.Service;


import com.olayinka.DTOs.UserLoginDTO;
import com.olayinka.Model.Users;
import com.olayinka.Repository.UserRepo;
import com.olayinka.Validation.UserValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsersService  {

    @Autowired
    private UserRepo userRepo;
    private final JwtService jwtService;

    public UsersService (JwtService jwtService) {
        this.jwtService = jwtService;
    }
    @Autowired
    AuthenticationManager authManager;

    //Creating object of bcrypts for password hashing
    //Passing a strength 0f 12
    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);


    public Users registerUser(Users user){
        Users newUser = UserValidation.validateUser(user);
        newUser.setPassword(encoder.encode(user.getPassword()));
        userRepo.save(newUser);
        return newUser;
    }

    public String verify(UserLoginDTO user) {
        System.out.println("This is user entered password" + user.getPassword());
        Authentication authentication =
                authManager.authenticate(new UsernamePasswordAuthenticationToken(user.getEmail(),user.getPassword()));
        if(authentication.isAuthenticated()){
            return jwtService.generateToken(user.getEmail());
        }
        else
            return "fail";
    }
}