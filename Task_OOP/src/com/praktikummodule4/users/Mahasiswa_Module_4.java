package com.praktikummodule4.users;
import java.util.Scanner;
import com.praktikummodule4.actions.MahasiswaActions;

public class Mahasiswa_Module_4 extends User_Module_4 implements MahasiswaActions {
    public Mahasiswa_Module_4(String username, String password) {
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
