package com.praktikummodule5.users;

public abstract class user_module_5 {
    protected String username, password;

    public user_module_5(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public abstract boolean login();
    abstract void displayAppMenu();
}