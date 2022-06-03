package com.techvify.loginBasic.service;

import com.techvify.loginBasic.dto.CreateUserDTO;
import com.techvify.loginBasic.entity.User;
import com.techvify.loginBasic.repository.IUserRepository;
import com.techvify.loginBasic.service.iService.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Base64;
import java.util.List;

@Service
public class UserService implements IUserService {

    @Autowired
    private IUserRepository iUserRepository;

    @Override
    public List<User> findAll() {
        return iUserRepository.findAll();
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

    @Override
    public void createUser(User user) {
        if(user.getUsername() != null && user.getPassword()!= null){
            if (user.getUsername().length() >= 6 && user.getPassword().length() >=8){
               String pass = user.getPassword();
              String base64 = Base64.getEncoder().encodeToString(pass.getBytes());
              user.setPassword(base64);
                iUserRepository.save(user);
            }
        }
    }

    @Override
    public User loginUser(@RequestBody CreateUserDTO createUserDTO) {
        String pass = createUserDTO.getPassword();
        String base64 = Base64.getEncoder().encodeToString(pass.getBytes());
        User user = iUserRepository.findByUsernameAndPassword(createUserDTO.getUsername(),base64);

        String passs = createUserDTO.getPassword();
        if (passs != null){
            return user;
        }
        return null;
    }

}
