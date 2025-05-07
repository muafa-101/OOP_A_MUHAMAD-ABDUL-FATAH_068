package com.praktikummodule4.users;
import com.praktikummodule4.actions.AdminActions;
import java.util.Scanner;

public class Admin_Module_4 extends User_Module_4 implements AdminActions {
    public Admin_Module_4(String username, String password) {
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

