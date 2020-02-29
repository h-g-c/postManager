package postoffice.demo.entity;


import lombok.Data;

@Data
public class Customer {
    String userName;
    String reallyName;
    int age;
    String sex;
    String password;
    String userAddress;
    String phoneNumber;
    boolean admin;
    Customer() {
        age = 0;
        reallyName = "";
        age = 0;
        sex = "";
        password = "";
        userAddress = "";
    }
}
