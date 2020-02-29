package postoffice.demo.model;

import java.util.UUID;

public class TokenModel {
    // 用户ID
    private long userId;
    // 随机生成的uuid
    private String token;

    public TokenModel () {

    }
    public TokenModel(long userId, String roleInt, String flag) {
        this.userId = userId;
        this.token = UUID.randomUUID().toString() + ":" + roleInt + ":" + flag;
    }

    public TokenModel(Long userId, String token) {
        this.userId = userId;
        this.token = token;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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
                "userId=" + userId +
                ", token='" + token + '\'' +
                '}';
    }
}
