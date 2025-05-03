package App;

import Library.*;

public class Main {
    public static void main(String[] args) {
        // Membuat objek book
        Book bukuNonFiksi = new Non_Fiction("Madilog", "Tan Malaka Genre: Sejarah & Ilmu Pengetahuan");
        Book bukuFiksi = new Fiction("Hainuwele: Sang Putri Kelapa", "Lilis Hu Genre: Dongeng");

        // Membuat objek anggota
        Anggota anggota1 = new Anggota("Muhamad Abdul Fatah", "393");
        Anggota anggota2 = new Anggota("Malik", "111");

        // Menampilkan info buku
        bukuNonFiksi.displayInfo();
        bukuFiksi.displayInfo();

        // Menampilkan info anggota
        System.out.println("\nAnggota: " + anggota1.getName() + " (ID: " + anggota1.getIdAnggota() + ")");
        System.out.println("Anggota: " + anggota2.getName() + " (ID: " + anggota2.getIdAnggota() + ")");

        // Peminjaman buku
        anggota1.pinjamBuku(bukuNonFiksi.getTitle());
        anggota2.pinjamBuku(bukuFiksi.getTitle(), 7);


        // Pengembalian buku
        anggota1.kembalikanBuku(bukuNonFiksi.getTitle());
        anggota2.kembalikanBuku(bukuFiksi.getTitle());
    }
}
