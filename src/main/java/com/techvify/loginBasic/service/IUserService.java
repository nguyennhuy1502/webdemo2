package com.techvify.loginBasic.service;

import com.techvify.loginBasic.entity.User;

import java.util.List;


public interface IUserService {
    List<User> findAll();

    void User(User user);

    User findByEmailAndPass(String username, String password);
    User getUserById(short id);

    User deleteById(short id);
}
