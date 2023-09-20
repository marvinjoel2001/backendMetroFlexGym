package com.api.metroflex_backend.controllers;


import com.api.metroflex_backend.models.UserModel;
import com.api.metroflex_backend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ArrayList<UserModel> getUsers(){
        return this.userService.getUsers();
    }

    @PostMapping
    public UserModel setUser(@RequestBody UserModel user){
        return this.userService.saveUser(user);
    }

    @GetMapping(path = "/{id}")
    public Optional<UserModel> getUserById(@PathVariable("id") Long id){
        return this.userService.getById(id);
    }

    @PutMapping(path = "/{id}")
    public UserModel updateUserById(@RequestBody UserModel request, @PathVariable("id") Long id) {
        return this.userService.updateById(request, id);
    }


    @DeleteMapping(path = "/{id}")
    public String deleteUser(@PathVariable Long id){
        boolean ok =this.userService.deleteUser(id);
        if (ok){
            return "User with id "+ id + " deleted";
        }else {
            return "Ups we have a problem ";
        }
    }

}
