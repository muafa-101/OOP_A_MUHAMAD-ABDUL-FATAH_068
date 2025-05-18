package com.praktikummodule5.users;


import com.praktikummodule5.action.adminAction;
import com.praktikummodule5.users.user_module_5;

import java.util.Scanner;

public class admin_module_5 extends user_module_5 implements adminAction {
    public admin_module_5(String username, String password) {
        super(username, password);
    }

    Scanner sc = new Scanner(System.in);

    @Override
    public boolean login() {
        System.out.println("Enter Username");
        String inputUsername = sc.nextLine();
        System.out.println("Enter Password");
        String inputPassword = sc.nextLine();
        if (inputUsername.equals(username) && inputPassword.equals(password)) {
            System.out.println("Login Successful");
            displayAppMenu();
            return true;
        }else
            System.out.println("Login Failed");
        return false;
    }

    @Override
    void displayAppMenu() {
        for(;;) {
            System.out.println("Admin Menu\n1.Manage Item\n2.Manage Users\n3.Exit\nEnter Your Choice: ");
            int option = sc.nextInt();
            switch (option) {
                case 1:
                    manageItem();
                    break;
                case 2:
                    manageUsers();
                    break;
                case 3:
                    System.exit(0);
            }
        }
    }


    @Override
    public void manageItem() {
        System.out.println("Manage Item is Not Available");
    }

    @Override
    public void manageUsers() {
        System.out.println("Manage Users is Not Available");
    }


}