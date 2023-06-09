package com.example.EntranceIntern.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServices {
    
    @Autowired UserRepository repo;
    @Autowired PasswordEncoder passwordEncoder;

    public ResponseEntity<User> create(User user){

        String hashPassword =  passwordEncoder.encode(user.getPassword());
        user.setPassword(hashPassword);

        User newUser = repo.save(user);

        return ResponseEntity.ok().body(newUser);

    }

    public ResponseEntity<User> findById(Integer id){
        
        return ResponseEntity.ok().body(repo.findById(id).get());
    }
}
