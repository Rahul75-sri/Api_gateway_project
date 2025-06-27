package com.Rahul.user.service.UserService1.controllers;

import com.Rahul.user.service.UserService1.dto.UserDto;
import com.Rahul.user.service.UserService1.entities.User;
import com.Rahul.user.service.UserService1.payload.ApiResponse;
import com.Rahul.user.service.UserService1.services.UserServices;
import com.Rahul.user.service.UserService1.utils.UUIDValidator;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;


@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserServices userServices;
    //create
    @PostMapping
    public ResponseEntity<User> createUser(@Valid @RequestBody UserDto userDto){
        // Convert DTO to Entity (this ensures a clean entity state)
        User user = convertToUser(userDto);
        User savedUser = userServices.saveUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
    }


    // Single User

    @GetMapping("/{userId}")
    public ResponseEntity<?> getSingleUser(@PathVariable String userId) throws Throwable {
            User user = userServices.getUser(userId);
            return ResponseEntity.ok(user);
    }

    private User getUser(String userId) {
        return null;
    }
    private User convertToUser(UserDto userDto) {
        return User.builder()
                .name(userDto.getName())
                .email(userDto.getEmail())
                .about(userDto.getAbout())
                .build(); // Do NOT set id
    }



    //All Users
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> allUsers =  userServices.getAllUser();
        return ResponseEntity.ok(allUsers);
    }

}
