package com.olayinka.Configuration;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.authentication.configurers.userdetails.DaoAuthenticationConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity  // this bypass the initiial security

public class SecurityConfig {

    @Autowired
    private UserDetailsService userDetailsService;

    @Bean  //this bypass the initial security
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{

       http.csrf(AbstractHttpConfigurer::disable) //disabling the websecurity crsf token
               .authorizeHttpRequests(request -> request   //creating authentication using username and password
               .requestMatchers("register","login") //Setting permission for this two api
               .permitAll()//permitting the two api to proceed without username and password verification
               .anyRequest() //Asking for permission for all other request
               .authenticated()); //Authenticating all other request

        //http.formLogin(Customizer.withDefaults()); //Enabling default form login
       http.httpBasic(Customizer.withDefaults()); //Enabling login from other user i.e postman
       http.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)); //This disable the csrf setting from requesting for csrf
        return http.build();
    }

    //hardCoding username and password

//    @Bean  //to create a defualt validation steps
//    public UserDetailsService userDetailsService () {
//
//        UserDetails user1 = User.withDefaultPasswordEncoder().username("ola").password("ola1").roles("ADMIN").build();
//        return new InMemoryUserDetailsManager(user1); // this class implement userDetailService u
//    }

    @Bean  //Changing the authentication provider to a default configuration
    public AuthenticationProvider authenticationprovider(){
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(new BCryptPasswordEncoder(12)); //Asking the password to be hashed and compared to the saved password
        provider.setUserDetailsService(userDetailsService);
        return provider;
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }
}
