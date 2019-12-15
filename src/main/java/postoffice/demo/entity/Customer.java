package postoffice.demo.entity;


public class Customer {
    String userName;
    String reallyName;
    int age;
    String sex;
    String password;
    String userAddress;
    String phoneNumber;

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    Customer() {
        age = 0;
        reallyName = "";
        age = 0;
        sex = "";
        password = "";
        userAddress = "";
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getReallyName() {
        return reallyName;
    }

    public void setReallyName(String reallyName) {
        this.reallyName = reallyName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }


}
