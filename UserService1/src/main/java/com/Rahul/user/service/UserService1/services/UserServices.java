package com.Rahul.user.service.UserService1.services;

import com.Rahul.user.service.UserService1.entities.User;

import java.util.*;

public interface UserServices {
    User saveUser(User user);

    List<User> getAllUser();


     User getUser(String userId) ;


}
