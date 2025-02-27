package com.olayinka;

import com.olayinka.Model.Users;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

@SpringBootApplication
public class SpringBootJdbcTemplateSqlServerApplication implements CommandLineRunner {

     @Autowired
     private JdbcTemplate jdbcTemplate;

     @Override
    public void run(String... args) throws Exception {
      String query = "Select * from users";

        List<Users> users = jdbcTemplate.query(query, BeanPropertyRowMapper.newInstance(Users.class ));
        users.forEach(System.out::println);


    }


}


