package com.example.ProjectY.service;

import com.example.ProjectY.models.User;
import com.example.ProjectY.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public User registerNewUserServiceMethod(User user){
        return userRepository.save(user);
    }
    public List<String> checkUserEmail(String email){
        return userRepository.checkUserEmail(email);
    }
    // End Of Check User Email Services Method.

    public String checkUserPasswordByEmail(String email){
        return userRepository.checkUserPasswordByEmail(email);
    }
    // End Of Check User Password Services Method.

    public User getUserDetailsByEmail(String email){
        return userRepository.GetUserDetailsByEmail(email);
    }
}
