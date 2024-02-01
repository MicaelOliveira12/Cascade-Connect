package com.cascade.CascadeConnect.Login;

import com.cascade.CascadeConnect.Service.Cryptography;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "login")
@Entity(name = "login")
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class LoginModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userEmail;
    private String userPassword;

    public LoginModel(LoginRecord login){
        this.userEmail = login.userEmail();
        this.userPassword = new Cryptography().encrypt(login.userPassword());
    }

}
