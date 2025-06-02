package com.praktikummodule6.gui;

import com.praktikummodule6.data.DataStore;
import com.praktikummodule6.item.item;
import com.praktikummodule6.users.admin;
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

public class adminform {

    private final admin adminUser;
    private final ObservableList<item> itemData = FXCollections.observableArrayList();
    private final ObservableList<mahasiswa> mahasiswaData = FXCollections.observableArrayList();



    public adminform(admin adminUser) {
        this.adminUser = adminUser;

        // Dummy data mahasiswa (kalau belum ada)
        mahasiswaData.addAll(
                new mahasiswa("Muhamad Abdul Fatah", "202310370311006"),
                new mahasiswa("Viero", "202310370311010"),
                new mahasiswa("Budi Anantha", "202310370311321"),
                new mahasiswa("Malik", "202310370311129")
        );

        // Dummy data barang
        itemData.addAll(
                new item("HP", "Xiaomi", "Meja A15", "Claimed"),
                new item("Dompet", "Pria kulit hitam", "Meja B-19", "Claimed"),
                new item("buku tulis", "hitam", "perpus", "Claimed")
        );

        // Load item global
        itemData.addAll(DataStore.items);
    }

    public void show(Stage stage) {
        Label greeting = new Label("Halo, Administrator " + adminUser.getUsername());
        Label laporanLabel = new Label("Laporan Barang");

        // Tabel Barang
        TableView<item> itemTable = new TableView<>(itemData);
        itemTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        TableColumn<item, String> colNama = new TableColumn<>("Nama");
        colNama.setCellValueFactory(new PropertyValueFactory<>("nama"));

        TableColumn<item, String> colLokasi = new TableColumn<>("Lokasi");
        colLokasi.setCellValueFactory(new PropertyValueFactory<>("lokasi"));

        TableColumn<item, String> colStatus = new TableColumn<>("Status");
        colStatus.setCellValueFactory(new PropertyValueFactory<>("status"));

        TableColumn<item, String> colDeskripsi = new TableColumn<>("Deskripsi");
        colDeskripsi.setCellValueFactory(new PropertyValueFactory<>("deskripsi"));

        itemTable.getColumns().addAll(colNama, colLokasi, colDeskripsi, colStatus);

        Button claimBtn = new Button("Tandai Claimed");
        claimBtn.setOnAction(e -> {
            item selected = itemTable.getSelectionModel().getSelectedItem();
            if (selected != null && !selected.getStatus().equals("Claimed")) {
                selected.setStatus("Claimed");
                itemTable.refresh();
                showAlert("Status barang diperbarui menjadi 'Claimed'");
            }
        });

        VBox leftBox = new VBox(10, greeting, laporanLabel, itemTable, claimBtn);
        leftBox.setPadding(new Insets(10));
        leftBox.setPrefWidth(400);

        // Tabel Mahasiswa
        Label mahasiswaLabel = new Label("Data Mahasiswa");

        TableView<mahasiswa> mahasiswaTable = new TableView<>(mahasiswaData);
        mahasiswaTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        TableColumn<mahasiswa, String> colMhsNama = new TableColumn<>("Nama");
        colMhsNama.setCellValueFactory(new PropertyValueFactory<>("username"));

        TableColumn<mahasiswa, String> colMhsNim = new TableColumn<>("password"); // password = nim
        colMhsNim.setCellValueFactory(new PropertyValueFactory<>("password"));

        mahasiswaTable.getColumns().addAll(colMhsNama, colMhsNim);

        TextField namaField = new TextField();
        namaField.setPromptText("Nama Mahasiswa");

        TextField nimField = new TextField();
        nimField.setPromptText("NIM");

        Button tambahBtn = new Button("Tambah");
        tambahBtn.setMaxWidth(Double.MAX_VALUE);
        tambahBtn.setOnAction(e -> {
            String nama = namaField.getText();
            String nim = nimField.getText();
            if (!nama.isEmpty() && !nim.isEmpty()) {
                mahasiswa m = new mahasiswa(nama, nim);
                mahasiswaData.add(m);
                DataStore.users.add(m);
                showAlert("Mahasiswa berhasil ditambahkan!");
                namaField.clear(); nimField.clear();
            }
        });

        Button hapusBtn = new Button("Hapus");
        hapusBtn.setMaxWidth(Double.MAX_VALUE);
        hapusBtn.setOnAction(e -> {
            mahasiswa selected = mahasiswaTable.getSelectionModel().getSelectedItem();
            if (selected != null) {
                Alert confirm = new Alert(Alert.AlertType.CONFIRMATION);
                confirm.setTitle("Konfirmasi Penghapusan");
                confirm.setHeaderText("Apakah Anda yakin ingin menghapus mahasiswa ini?");
                confirm.setContentText(selected.getUsername() + " - " + selected.getPassword());

                ButtonType yes = new ButtonType("Ya", ButtonBar.ButtonData.YES);
                ButtonType no = new ButtonType("Tidak", ButtonBar.ButtonData.NO);
                confirm.getButtonTypes().setAll(yes, no);

                confirm.showAndWait().ifPresent(result -> {
                    if (result == yes) {
                        mahasiswaData.remove(selected);
                        DataStore.users.removeIf(u -> u instanceof mahasiswa && u.getUsername().equals(selected.getUsername()));
                        showAlert("Mahasiswa berhasil dihapus.");
                    }
                });
            }
        });


        VBox inputBox = new VBox(10, namaField, nimField, tambahBtn, hapusBtn);
        inputBox.setAlignment(Pos.CENTER_RIGHT);

        VBox rightBox = new VBox(10, mahasiswaLabel, mahasiswaTable, inputBox);
        rightBox.setPadding(new Insets(10));
        rightBox.setPrefWidth(400);

        HBox mainLayout = new HBox(15, leftBox, rightBox);

        Button logoutBtn = new Button("Logout");
        logoutBtn.setOnAction(e -> new loginform().show(stage));

        VBox root = new VBox(10, mainLayout, logoutBtn);
        root.setPadding(new Insets(10));

        stage.setTitle("Lost & Found Kampus");
        stage.setScene(new Scene(root, 880, 500));
        stage.show();
    }

    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Notifikasi");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
