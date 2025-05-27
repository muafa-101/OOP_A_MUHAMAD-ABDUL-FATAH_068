package com.praktikummodule5.users;


import com.praktikummodule5.action.adminAction;
import com.praktikummodule5.data.datalist;
import com.praktikummodule5.data.item_module_5;
import java.util.InputMismatchException;
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
        } else
            System.out.println("Login Failed");
        return false;
    }

    @Override
    public void displayAppMenu() {
        for (; ; ) {
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
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== Kelola Barang ===");
            System.out.println("1. Lihat Semua Laporan");
            System.out.println("2. Tandai Barang Telah Diambil");
            System.out.println("0. Kembali");

            try {
                System.out.print("Pilih menu: ");
                int pilihan = scanner.nextInt();
                scanner.nextLine(); // clear buffer

                switch (pilihan) {
                    case 1:
                        if (datalist.itemlist.isEmpty()) {
                            System.out.println("Belum ada laporan barang.");
                        } else {
                            int index = 0;
                            for (item_module_5 item : datalist.itemlist) {
                                System.out.println("[" + index + "] " + item.getItemName() + " | Status: " + item.getStatus());
                                index++;
                            }
                        }
                        break;
                    case 2:
                        System.out.println("Pilih barang yang ingin ditandai:");
                        int i = 0;
                        for (item_module_5 item : datalist.itemlist) {
                            if (item.getStatus().equalsIgnoreCase("Reported")) {
                                System.out.println("[" + i + "] " + item.getItemName());
                            }
                            i++;
                        }

                        System.out.print("Masukkan indeks barang: ");
                        int indexToClaim = scanner.nextInt();
                        scanner.nextLine();

                        try {
                            item_module_5 item = datalist.itemlist.get(indexToClaim);
                            item.setStatus("Claimed");
                            System.out.println("Status barang berhasil diubah menjadi 'Claimed'.");
                        } catch (IndexOutOfBoundsException e) {
                            System.out.println("Indeks tidak valid!");
                        }
                        break;
                    case 0:
                        return;
                    default:
                        System.out.println("Menu tidak valid.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Input harus berupa angka!");
                scanner.nextLine(); // clear invalid input
            }
        }
    }

    @Override
    public void manageUsers() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== Kelola Mahasiswa ===");
            System.out.println("1. Tambah Mahasiswa");
            System.out.println("2. Hapus Mahasiswa");
            System.out.println("0. Kembali");

            try {
                System.out.print("Pilih menu: ");
                int pilihan = scanner.nextInt();
                scanner.nextLine(); // clear buffer

                switch (pilihan) {
                    case 1:
                        System.out.print("Masukkan Nama Mahasiswa: ");
                        String nama = scanner.nextLine();
                        System.out.print("Masukkan NIM Mahasiswa: ");
                        String nim = scanner.nextLine();
                        datalist.userlist.add(new mahasiswa_module_5(nim, nama));
                        System.out.println("Mahasiswa berhasil ditambahkan!");
                        break;
                    case 2:
                        System.out.print("Masukkan NIM Mahasiswa yang akan dihapus: ");
                        String targetNIM = scanner.nextLine();
                        boolean found = false;
                        for (int i = 0; i < datalist.userlist.size(); i++) {
                            if (datalist.userlist.get(i) instanceof mahasiswa_module_5) {
                                mahasiswa_module_5 mhs = (mahasiswa_module_5) datalist.userlist.get(i);
                                if (mhs.getNim().equals(targetNIM)) {
                                    datalist.userlist.remove(i);
                                    System.out.println("Mahasiswa berhasil dihapus.");
                                    found = true;
                                    break;
                                }
                            }
                        }
                        if (!found) {
                            System.out.println("Mahasiswa dengan NIM tersebut tidak ditemukan.");
                        }
                        break;
                    case 0:
                        return;
                    default:
                        System.out.println("Menu tidak valid.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Input harus berupa angka!");
                scanner.nextLine();
            }
        }
    }


}