package com.cascade.CascadeConnect.users;

import com.cascade.CascadeConnect.Service.ActiveInactive;
import com.cascade.CascadeConnect.Service.ChangeUserType;
import com.cascade.CascadeConnect.Service.Cryptography;
import jakarta.persistence.*;
import lombok.*;

@ToString
@Table(name = "users")
@Entity(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class UsersModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userName;
    private String userEmail;
    private String userPassword;
    private int userType;
    private String activeInactive;

    public UsersModel (UsersRecord user){
        if(user.id() != null) {
            this.id = user.id();
        }
        this.userName = user.userName();
        this.userEmail = user.userEmail();
        this.userPassword = new Cryptography().encrypt(user.userPassword());
        this.userType = new ChangeUserType().fromEnumtoInt(user.employeeType());
        this.activeInactive = ActiveInactive.ACTIVE.toString();
    }

}
