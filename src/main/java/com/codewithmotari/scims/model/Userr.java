package com.codewithmotari.scims.model;

public class Userr {
    private int id;
    private String username;
    private String password;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    private String fullName;
    private String role;

    public Userr(int id, String password, String username) {
        this.id = id;
        this.password = password;
        this.username = username;
    }

    public Userr() {
    }

    public Userr(int id, String userName) {
        this.id=id;
        this.username=userName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
