package Library;

public class Anggota implements Peminjaman {
    private String Name;
    private String idAnggota;

    public Anggota(String Name, String idAnggota) {
        this.Name = Name;
        this.idAnggota = idAnggota;
    }

    public String getName() {
        return Name;
    }

    public String getIdAnggota() {
        return idAnggota;
    }

    @Override
    public void pinjamBuku(String title) {
        System.out.println(Name + " Pinjam buku " + title);
    }

    @Override
    public void kembalikanBuku(String title) {

    }

    public void pinjamBuku(String title, int durasi) {
        System.out.println(Name + " Pinjam buku " + title +  " selama " + durasi + " hari.");
    }


}
