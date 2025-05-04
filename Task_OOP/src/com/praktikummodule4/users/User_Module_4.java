package com.praktikummodule4.users;

public abstract class User_Module_4 {
    protected String username, password;

    public User_Module_4(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public abstract boolean login();
    abstract void displayAppMenu();
}
