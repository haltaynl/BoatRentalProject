package org.capgemini.model;

public class User {
    private String userID;
    private String userName;
    private String userPassword;
    private String userRole;


    public User(String userID, String userName, String userPassword, String userRole) {
        this.userID = userID;
        this.userName = userName;
        this.userPassword = userPassword;
        this.userRole = userRole;
    }
    public User(String userName, String userPassword, String userRole) {
        long timestamp = System.currentTimeMillis() % 10000;
        this.userID ="U"+String.format("%04d", timestamp);
        this.userName = userName;
        this.userPassword = userPassword;
        this.userRole = userRole;
    }


    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }
}
