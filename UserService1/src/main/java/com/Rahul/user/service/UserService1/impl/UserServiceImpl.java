package com.Rahul.user.service.UserService1.impl;

import com.Rahul.user.service.UserService1.entities.User;
import com.Rahul.user.service.UserService1.exception.ResourcesNotFoundException;
import com.Rahul.user.service.UserService1.repositories.UserRepository;
import com.Rahul.user.service.UserService1.services.UserServices;
import com.Rahul.user.service.UserService1.utils.UUIDValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserServices {

    @Autowired

    private UserRepository userRepository;

    @Override
    public User saveUser(User user) {
        // Let Hibernate handle the ID generation
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public User getUser(String userId)  {
        // Validate userId before querying
        if (!UUIDValidator.isValidUUID(userId)) {
            throw new IllegalArgumentException("Invalid UUID format: " + userId);
        }

        return  userRepository.findById(userId).orElseThrow(()-> new ResourcesNotFoundException("User with given Id is not found in the server : "+userId));
    }
}
