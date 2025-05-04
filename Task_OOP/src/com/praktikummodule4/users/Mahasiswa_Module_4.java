package com.praktikummodule4.users;
import java.util.Scanner;
import com.praktikummodule4.actions.MahasiswaActions;

public class Mahasiswa_Module_4 implements MahasiswaActions {
    Scanner sc = new Scanner(System.in);
    String itemName, itemDescription, lastFound;

    @Override
    public void reportItem() {
        System.out.println("Item Name");
        itemName = sc.nextLine();
        System.out.println("Item Description");
        itemDescription = sc.nextLine();
        System.out.println("Last Found");
        lastFound = sc.nextLine();

    }

    @Override
    public void viewReportedItem() {
        System.out.println("View Reported Item Not Available");
    }
}
