package com.praktikummodule5.users;

import com.praktikummodule5.action.mahasiswaActions;
import com.praktikummodule5.data.datalist;
import com.praktikummodule5.data.item_module_5;
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
        public void displayAppMenu() {
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
            Scanner scanner = new Scanner(System.in);

            try {
                System.out.print("Nama Barang: ");
                String itemName = scanner.nextLine();

                System.out.print("Deskripsi: ");
                String description = scanner.nextLine();

                System.out.print("Lokasi Kehilangan: ");
                String location = scanner.nextLine();

                // Buat objek Item dan set status ke "Reported"
                item_module_5 item = new item_module_5(itemName, description, location, "Reported");

                // Tambahkan ke itemlist pusat
                datalist.itemlist.add(item);

                System.out.println("Barang berhasil dilaporkan!");
            } catch (Exception e) {
                System.out.println("Terjadi kesalahan saat input. Silakan coba lagi.");
            }
        }


        @Override
        public void viewReportedItem() {
            if (datalist.itemlist.isEmpty()) {
                System.out.println("Belum ada laporan barang.");
            } else {
                System.out.println("Daftar Barang yang Dilaporkan:");
                for (item_module_5 item : datalist.itemlist) {
                    if (item.getStatus().equalsIgnoreCase("Reported")) {
                        System.out.println("Nama: " + item.getItemName());
                        System.out.println("Deskripsi: " + item.getDescription());
                        System.out.println("Lokasi: " + item.getLocation());
                        System.out.println("-----------------------------");
                    }
                }
            }
        }

        public String getNim() {
            return username; // Karena NIM disimpan di username
        }



    }

