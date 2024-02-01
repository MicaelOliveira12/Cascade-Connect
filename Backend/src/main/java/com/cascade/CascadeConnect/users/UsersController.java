package com.cascade.CascadeConnect.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping("/user")
public class UsersController {

    @Autowired
    private UsersRepository repository;

    @PostMapping
    public UsersModel createUser(@RequestBody UsersRecord user){
        System.out.println(user);
        return repository.save(new UsersModel(user));
    }


}
