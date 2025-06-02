package com.praktikummodule6.gui;

import com.praktikummodule6.data.DataStore;
import com.praktikummodule6.item.item;
import com.praktikummodule6.users.mahasiswa;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class mahasiswaform {

    private final mahasiswa mahasiswaUser;
    private final ObservableList<item> laporanMahasiswa = FXCollections.observableArrayList();

    public mahasiswaform(mahasiswa mahasiswaUser) {
        this.mahasiswaUser = mahasiswaUser;

        // Dummy data awal
        laporanMahasiswa.add(new item("HP", "Xiaomi Note 10", "Meja A-01"));
    }

    public void show(Stage stage) {
        // Header sambutan
        Label greeting = new Label("Selamat datang, " + mahasiswaUser.getUsername());
        Label instruction = new Label("Laporkan Barang Hilang/Temuan");

        // Input fields
        TextField namaField = new TextField();
        namaField.setPromptText("Nama Barang");

        TextField deskripsiField = new TextField();
        deskripsiField.setPromptText("Deskripsi");

        TextField lokasiField = new TextField();
        lokasiField.setPromptText("Lokasi");

        Button laporBtn = new Button("Laporkan");

        // TableView setup
        TableView<item> table = new TableView<>();
        table.setItems(laporanMahasiswa);
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY); // Auto lebar

        TableColumn<item, String> colNama = new TableColumn<>("Nama");
        colNama.setCellValueFactory(new PropertyValueFactory<>("nama"));

        TableColumn<item, String> colLokasi = new TableColumn<>("Lokasi");
        colLokasi.setCellValueFactory(new PropertyValueFactory<>("lokasi"));

        table.getColumns().addAll(colNama, colLokasi);

        // Tombol Logout
        Button logoutBtn = new Button("Logout");
        logoutBtn.setOnAction(e -> {
            new loginform().show(stage);
        });

        // Aksi Laporkan
        laporBtn.setOnAction(e -> {
            String nama = namaField.getText();
            String deskripsi = deskripsiField.getText();
            String lokasi = lokasiField.getText();

            if (!nama.isEmpty() && !lokasi.isEmpty()) {
                item i = new item(nama, deskripsi, lokasi);
                DataStore.items.add(i); // Tambah ke global
                laporanMahasiswa.add(i); // Tampilkan di tabel mahasiswa ini saja
                namaField.clear(); deskripsiField.clear(); lokasiField.clear();
            }
        });

        // Layout baris input
        HBox inputRow = new HBox(10, namaField, deskripsiField, lokasiField, laporBtn);
        inputRow.setAlignment(Pos.CENTER);

        // Root layout
        VBox root = new VBox(10,
                greeting,
                instruction,
                inputRow,
                new Label("Daftar Laporan Anda"),
                table,
                logoutBtn
        );
        root.setPadding(new Insets(15));
        root.setStyle("-fx-background-color: #fdfdfd;");

        stage.setTitle("Lost & Found Kampus");
        stage.setScene(new Scene(root, 650, 400));
        stage.show();
    }
}
