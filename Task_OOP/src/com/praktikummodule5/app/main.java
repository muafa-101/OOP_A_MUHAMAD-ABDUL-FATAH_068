package com.praktikummodule5.app;

import com.praktikummodule5.data.datalist;
import com.praktikummodule5.users.user_module_5;
import com.praktikummodule5.users.admin_module_5;
import com.praktikummodule5.users.mahasiswa_module_5;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("Login System\n1. Admin\n2. Mahasiswa\n3. Exit\nEnter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // Clear newline

            switch (choice) {
                case 1:
                case 2:
                    System.out.print("Enter Username: ");
                    String inputUsername = sc.nextLine();
                    System.out.print("Enter Password: ");
                    String inputPassword = sc.nextLine();

                    boolean found = false;
                    for (user_module_5 user : datalist.userlist) {
                        boolean isAdmin = (choice == 1 && user instanceof admin_module_5);
                        boolean isMahasiswa = (choice == 2 && user instanceof mahasiswa_module_5);

                        if ((isAdmin || isMahasiswa) &&
                                user.username.equals(inputUsername) &&
                                user.password.equals(inputPassword)) {

                            System.out.println("Login successful.");
                            user.displayAppMenu(); // Polymorphism in action
                            found = true;
                            break;
                        }
                    }

                    if (!found) {
                        System.out.println("Login failed. Invalid credentials or user type.");
                    }
                    break;

                case 3:
                    System.out.println("Exiting the system. Goodbye!");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
}
