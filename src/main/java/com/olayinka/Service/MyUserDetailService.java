package com.olayinka.Service;

import com.olayinka.Model.UserPrincipal;
import com.olayinka.Model.Users;
import com.olayinka.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class MyUserDetailService implements UserDetailsService {
    @Autowired
    private UserRepo repo;

    @Override  //This fetch the data
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        System.out.println(email);
        Users user = repo.findByEmail(email);
        System.out.println("calling the login api");
        System.out.println("Email: " + email);
        System.out.println("Password (DB): " + user.getPassword()); // hashed


        if(user == null){
            System.out.println("User Not Found");
            throw new UsernameNotFoundException("user not found");
        }
        return new UserPrincipal(user);
    }
}