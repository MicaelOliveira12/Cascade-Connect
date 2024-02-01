package com.cascade.CascadeConnect.Service;

import java.util.Base64;

public class Cryptography {

    public String encrypt (String password){
        password = password + "CASCADE2024";
        return Base64.getEncoder().encodeToString(password.getBytes());
    }

    public String decrypt (String password){
        String passwordDecrypted = new String(Base64.getDecoder().decode(password));
        int size = (passwordDecrypted.length()- 11);
        String result = passwordDecrypted.substring(0,size);
        return result;
    }
}
