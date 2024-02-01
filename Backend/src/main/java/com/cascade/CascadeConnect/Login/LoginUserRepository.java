package com.cascade.CascadeConnect.Login;

import com.cascade.CascadeConnect.users.UsersModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface LoginUserRepository extends JpaRepository<LoginModel, Long> {

    Optional<LoginModel> findByUserEmail(String email);

    @Query("SELECT l.id, l.userName as id FROM users l WHERE l.userEmail = :user AND l.userPassword = :password")
    LoginUserResponse findIdAndTypeByEmailAndPassword(String user, String password);
}
