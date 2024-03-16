package com.example.project.service;

import com.example.project.model.User;

public interface UserService {
    User findByUserName(String userName);
}
