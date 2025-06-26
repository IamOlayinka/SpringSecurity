package com.olayinka.Repository;

import com.olayinka.Model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UserRepo extends JpaRepository <Users, Integer> {
     Users findByUsername(String username);


}
