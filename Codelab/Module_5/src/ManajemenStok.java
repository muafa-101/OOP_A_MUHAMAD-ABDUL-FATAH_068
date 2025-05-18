import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;


public class ManajemenStok {

    public static void main(String[] args) {
        List<Barang> daftarBarang = new ArrayList<>();
        daftarBarang.add(new Barang("Pensil", 10));
        daftarBarang.add(new Barang("Buku", 5));
        daftarBarang.add(new Barang("Pulpen", 8));

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Manajemen Stok Barang ---");
            System.out.println("1. Tambah Barang Baru");
            System.out.println("2. Tampilkan Semua Barang");
            System.out.println("3. Kurangi Stok Barang");
            System.out.println("0. Keluar");
            System.out.print("Pilih opsi: ");

            int opsi;
            try {
                opsi = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Input tidak valid. Masukkan angka.");
                scanner.next(); // Consume the invalid input
                continue; // Restart the loop
            }
            scanner.nextLine(); // Consume the newline character after reading the integer

            switch (opsi) {
                case 1:
                    tambahBarang(daftarBarang, scanner);
                    break;
                case 2:
                    tampilkanSemuaBarang(daftarBarang);
                    break;
                case 3:
                    kurangiStokBarang(daftarBarang, scanner);
                    break;
                case 0:
                    System.out.println("Terima kasih!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opsi tidak valid. Silakan coba lagi.");
            }
        }
    }

    private static void tambahBarang(List<Barang> daftarBarang, Scanner scanner) {
        System.out.print("Masukkan nama barang: ");
        String nama = scanner.nextLine();
        int stok = 0;
        boolean inputValid = false;
        while (!inputValid) {
            System.out.print("Masukkan stok awal: ");
            try {
                stok = scanner.nextInt();
                inputValid = true;
            } catch (InputMismatchException e) {
                System.out.println("Input stok harus berupa angka!");
                scanner.next(); // Consume the invalid input
            }
            scanner.nextLine(); // Consume the newline character after reading the integer
        }
        daftarBarang.add(new Barang(nama, stok));
        System.out.println("Barang " + nama + " berhasil ditambahkan dengan stok " + stok + ".");
    }

    private static void tampilkanSemuaBarang(List<Barang> daftarBarang) {
        if (daftarBarang.isEmpty()) {
            System.out.println("Stok barang kosong.");
            return;
        }
        System.out.println("\nDaftar Semua Barang:");
        for (int i = 0; i < daftarBarang.size(); i++) {
            Barang barang = daftarBarang.get(i);
            System.out.println((i+1) + ". " + barang.getNama() + " - Stok: " + barang.getStok());
        }
    }

    // Implementasi Opsi 3 (Kurangi Stok):
    private static void kurangiStokBarang(List<Barang> daftarBarang, Scanner scanner) {
        if (daftarBarang.isEmpty()) {
            System.out.println("Stok barang kosong.");
            return;
        }

        tampilkanSemuaBarang(daftarBarang);
        System.out.print("Masukkan nomor barang yang stoknya akan dikurangi: ");
        int nomorBarang = -1;
        try {
            nomorBarang = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Input tidak valid. Masukkan angka.");
            scanner.next(); // Consume the invalid input
            return;
        }
        scanner.nextLine(); // Consume the newline

        if (nomorBarang < 1 || nomorBarang > daftarBarang.size()) {
            System.out.println("Nomor barang tidak valid.");
            return;
        }

        System.out.print("Masukkan jumlah stok yang akan diambil: ");
        int jumlahDiambil = -1;
        try {
            jumlahDiambil = scanner.nextInt();
        }  catch (InputMismatchException e) {
            System.out.println("Input tidak valid. Masukkan angka.");
            scanner.next();
            return;
        }
        scanner.nextLine();

        try {
            Barang barang = daftarBarang.get(nomorBarang - 1); // Get the barang
            if (jumlahDiambil > barang.getStok()) {
                throw new stokTidakCukupException("Stok untuk " + barang.getNama() + " hanya tersisa " + barang.getStok());
            }
            barang.setStok(barang.getStok() - jumlahDiambil);
            System.out.println("Stok barang " + barang.getNama() + " berhasil dikurangi sebanyak " + jumlahDiambil + ".");
            System.out.println("Sisa stok: " + barang.getStok());
        } catch (stokTidakCukupException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
