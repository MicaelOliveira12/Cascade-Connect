package com.cascade.CascadeConnect.Login;

import com.cascade.CascadeConnect.Service.Cryptography;
import com.cascade.CascadeConnect.users.UsersModel;
import com.cascade.CascadeConnect.users.UsersRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping("/login")
@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class LoginController {

    @Autowired
    private UsersRepository userRepository;

    @PostMapping("/user")
    @Transactional
    public ResponseEntity <UsersModel> saveUser(@RequestBody LoginRecord login){

        String password = new Cryptography().encrypt(login.userPassword());

        Optional<UsersModel> userModel = userRepository.findByUserEmail(login.userEmail());

        UsersModel response = userModel.get();

        if(checkPassword(userModel.get().getUserPassword(),password)){
            return ResponseEntity.ok(response);
        }
        return ResponseEntity.notFound().build();
    }

    private boolean checkPassword (String password1, String password2){
        return password1.equals(password2);
    }
}
