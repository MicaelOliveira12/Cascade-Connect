package com.cascade.CascadeConnect.users;

import com.cascade.CascadeConnect.Service.EmployeeType;

public record UsersRecord(
        Long id,
        String userName,
        String userEmail,
        String userPassword,
        EmployeeType employeeType
) {

}
