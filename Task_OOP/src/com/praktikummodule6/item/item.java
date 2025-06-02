package com.praktikummodule6.item;

public class item {
    private String nama;
    private String deskripsi;
    private String lokasi;
    private String status = "Hilang";

    // Constructor default (tanpa status)
    public item(String nama, String deskripsi, String lokasi) {
        this.nama = nama;
        this.deskripsi = deskripsi;
        this.lokasi = lokasi;
    }

    // Constructor untuk dummy data dengan status
    public item(String nama, String deskripsi, String lokasi, String status) {
        this.nama = nama;
        this.deskripsi = deskripsi;
        this.lokasi = lokasi;
        this.status = status;
    }

    public String getNama() { return nama; }
    public String getDeskripsi() { return deskripsi; }
    public String getLokasi() { return lokasi; }
    public String getStatus() { return status; }

    public void setStatus(String status) { this.status = status; }
}
