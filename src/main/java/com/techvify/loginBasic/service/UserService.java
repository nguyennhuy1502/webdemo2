package com.techvify.loginBasic.service;

import com.techvify.loginBasic.entity.User;
import com.techvify.loginBasic.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService{

    @Autowired
    private IUserRepository iUserRepository;
    @Override
    public List<User> findAll() {
        return iUserRepository.findAll();
    }

    @Override
    public void User(User user) {
        iUserRepository.save(user);
    }

    @Override
    public User findByEmailAndPass(String username, String password) {
            return iUserRepository.findByUsernameAndPassword(username,password);
    }

    @Override
    public User getUserById(short id) {
        return iUserRepository.findById(id).get();
    }

    @Override
    public User deleteById(short id) {
        iUserRepository.deleteById(id);
        return null;
    }

}
