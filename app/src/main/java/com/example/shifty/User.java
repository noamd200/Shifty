package com.example.shifty;

public abstract class User {

    public enum UserRole {
        EMPLOYEE,
        MANAGER
    }

    private String userId; // String is best for Firebase Auth UIDs
    private String userName;
    private String email;
    private UserRole role;

    // Required empty constructor for Firebase
    public User() {
    }

    public User(String userId, String userName, String email, UserRole role) {
        this.userId = userId;
        this.userName = userName;
        this.email = email;
        this.role = role;
    }

    // --- Getters and Setters ---

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }
}