package com.Rahul.user.service.UserService1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.Rahul.user.service.UserService1.entities.User;

public interface UserRepository extends JpaRepository<User, String> {
}