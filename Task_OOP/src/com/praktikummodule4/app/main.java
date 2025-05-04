package com.praktikummodule4.app;
import com.praktikummodule4.users.*;
import com.praktikummodule4.actions.*;
import java.util.Scanner;


public class main{
    public static void main(String[] args) {
        Admin_Module_4 admin1 = new Admin_Module_4("admintampan", "admintampan");
        Mahasiswa_Module_4 siswa1 = new Mahasiswa_Module_4("202410370110393", "fatah");

        Scanner sc = new Scanner(System.in);
        System.out.println("Login System\n1.Admin\n2.Mahasiswa\n3.Exit\nEnter your choice: ");
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                admin1.login();
                break;
            case 2:
                siswa1.login();
                break;
            case 3:
                System.exit(0);
            default:
                System.out.println("Invalid choice");
                break;
        }sc.close();
    }
}
