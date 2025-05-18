package com.praktikummodule5.users;

import com.praktikummodule5.action.mahasiswaActions;
import com.praktikummodule5.users.user_module_5;

import java.util.Scanner;

    public class mahasiswa_module_5 extends user_module_5 implements mahasiswaActions {
        public mahasiswa_module_5(String username, String password) {
            super(username, password);
        }
        Scanner sc = new Scanner(System.in);

        public boolean login(){
            System.out.println("Enter username: ");
            String inputUsername = sc.nextLine();
            System.out.println("Enter password: ");
            String inputPassword = sc.nextLine();
            if (inputUsername.equals(username) && inputPassword.equals(password)){
                System.out.println("Logged in");
                displayAppMenu();
                return true;
            }else
                System.out.println("Login Failed, Wrong username or password");
            return false;
        }

        @Override
        void displayAppMenu() {
            for(;;) {
                System.out.println("User Menu\n1. Report Item\n2. View Reported item\n3. Exit\nEnter your choice: ");
                String option = sc.nextLine();
                switch (option) {
                    case "1":
                        reportItem();
                        break;
                    case "2":
                        viewReportedItem();
                        break;
                    case "3":
                        System.exit(0);
                    default:
                        System.out.println("Invalid choice");
                }
            }
        }

        @Override
        public void reportItem() {
            System.out.println("Item Name: ");
            String itemName = sc.nextLine();
            System.out.println("Item Description: ");
            String itemDescription = sc.nextLine();
            System.out.println("Last Found: ");
            String lastFound = sc.nextLine();
        }

        @Override
        public void viewReportedItem() {
            System.out.println("View Reported Item Not Available");

        }


    }

