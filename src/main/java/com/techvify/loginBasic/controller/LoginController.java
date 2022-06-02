package com.techvify.loginBasic.controller;

import com.techvify.loginBasic.entity.User;
import com.techvify.loginBasic.dto.CreateUserDTO;
import com.techvify.loginBasic.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@RequestMapping(value = "/api/v1/login")
public class LoginController {

    @Autowired
    private IUserService userService;

    @GetMapping("/home")
    public List<User> findAll() {
       return userService.findAll();
    }

    @GetMapping("/home/{id}")
    public User getUserById(@PathVariable(name = "id") short id) {
        return userService.getUserById(id);
    }

    @PostMapping("/create")
    public void createUser(@RequestBody CreateUserDTO createUser) {
        userService.User(createUser.toEntity());
    }

    @GetMapping("/{username}/{password}")
    public User findByEmailAndPass(@PathVariable("username") String username, @PathVariable("password") String password){
        return userService.findByEmailAndPass(username,password);
    }

    @DeleteMapping("/delete/{id}")
    public User deleteById(@PathVariable(name = "id") short id) {
        return userService.deleteById(id);
    }
}