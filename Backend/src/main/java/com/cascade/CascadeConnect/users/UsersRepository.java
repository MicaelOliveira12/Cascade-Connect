package com.cascade.CascadeConnect.users;

import com.cascade.CascadeConnect.Login.LoginUserResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UsersRepository extends JpaRepository <UsersModel, Long> {

    Optional<UsersModel> findByUserEmail(String email);


}
