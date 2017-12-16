package com.volianskyi.taras.a121017_ecommerceforandroid.pojo;

/**
 * Created by tarasvolianskyi on 16.12.17.
 */

public class UsersPojo {

    private String userId;
    private String userName;
    private String userLastName;
    private String userEmail;
    private String userPass;

    public UsersPojo() {
    }

    public UsersPojo(String userId, String userName, String userLastName, String userEmail, String userPass) {
        this.userId = userId;
        this.userName = userName;
        this.userLastName = userLastName;
        this.userEmail = userEmail;
        this.userPass = userPass;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPass() {
        return userPass;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }
}
