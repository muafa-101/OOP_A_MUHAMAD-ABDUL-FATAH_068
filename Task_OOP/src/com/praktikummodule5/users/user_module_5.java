package com.praktikummodule5.users;

public abstract class user_module_5 {
    public String username;
    public String password;

    public user_module_5(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public abstract boolean login();
    public abstract void displayAppMenu();
}