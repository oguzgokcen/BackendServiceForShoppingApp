package com.example.ProjectY.rest_controllers;

import com.example.ProjectY.models.User;
import com.example.ProjectY.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class RegisterApiController {

    @Autowired
    UserService userService;

    @PostMapping("/user/register")
    public ResponseEntity registerNewUser(@RequestBody User user) {
        if (user.getFirst_name().isEmpty() || user.getLast_name().isEmpty() || user.getEmail().isEmpty() || user.getPassword().isEmpty()) {
            return new ResponseEntity<>("Please Complete all Fields", HttpStatus.BAD_REQUEST);
        }
        String hashed_password = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
        user.setPassword(hashed_password);
        // Register New User:
        User result = userService.registerNewUserServiceMethod(user);
        if (result == null) {
            System.out.println("RESPONSE FAİL");
            return new ResponseEntity<>("failed", HttpStatus.BAD_REQUEST);
        }
        System.out.println("RESPONSE SUCCESS");
        return new ResponseEntity<>("client success", HttpStatus.OK);
    }
}

