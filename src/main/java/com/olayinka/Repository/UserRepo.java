package com.olayinka.Repository;

import com.olayinka.Model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UserRepo extends JpaRepository<Users, Integer> {
     Users findByEmail(String email); // Use email instead of username
     Optional<Users> findByUsername(String username);

}
