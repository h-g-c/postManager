package postoffice.demo.model;

import java.util.UUID;

public class TokenModel {
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    // 用户ID
    private String  userName;
    // 随机生成的uuid
    private String token;

    public TokenModel () {

    }
    public TokenModel(String userName) {
        this.userName = userName;
        this.token = UUID.randomUUID().toString() + ":" + System.currentTimeMillis();
    }

    public TokenModel(String userName, String token) {
        this.userName=userName;
        this.token = token;
    }


    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "TokenModel{" +
                "userName=" + userName +
                ", token='" + token + '\'' +
                '}';
    }
}
