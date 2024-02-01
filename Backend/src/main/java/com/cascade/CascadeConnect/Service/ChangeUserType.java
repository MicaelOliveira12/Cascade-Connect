package com.cascade.CascadeConnect.Service;
public class ChangeUserType {

    public int userTypeInt;
    public String userTypeString;
    public EmployeeType userTypeEnum;

    public String fromInttoString(int type){
        if(type == 1){
            this.userTypeString = "ADMINISTRATOR";
        }else if(type == 2){
            this.userTypeString = "SUPERVISOR";
        }else if(type == 3){
            this.userTypeString = "OPERATOR";
        }else{
            throw new RuntimeException("Error in unmapped int user type");
        }
        return this.userTypeString;
    }

    public EmployeeType fromInttoEnum(int type){
        if(type == 1){
            this.userTypeEnum = EmployeeType.ADMINISTRATOR;
        }else if (type == 2){
            this.userTypeEnum = EmployeeType.SUPERVISOR;
        }else if (type == 3){
            this.userTypeEnum = EmployeeType.OPERATOR;
        }else{
            throw new RuntimeException("Error in unmapped int user type");
        }
        return this.userTypeEnum;
    }

    public int fromEnumtoInt(EmployeeType employeeType) {
        if (employeeType.equals(EmployeeType.ADMINISTRATOR)) {
            this.userTypeInt = 1;
        } else if (employeeType.equals(EmployeeType.SUPERVISOR)) {
            this.userTypeInt = 2;
        } else if (employeeType.equals(EmployeeType.OPERATOR)) {
            this.userTypeInt = 3;
        } else {
            throw new RuntimeException("Error in unmapped enum user type");
        }
        return this.userTypeInt;
    }
}
