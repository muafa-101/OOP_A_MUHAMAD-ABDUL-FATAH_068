package com.praktikummodule6.gui;

import com.praktikummodule6.data.DataStore;
import com.praktikummodule6.users.admin;
import com.praktikummodule6.users.mahasiswa;
import com.praktikummodule6.users.user;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class loginform {

    public void show(Stage primaryStage) {
        // Judul aplikasi
        Label titleLabel = new Label("Login Sistem Lost & Found");
        titleLabel.setStyle("-fx-font-size: 16px; -fx-font-weight: bold;");

        // ComboBox Role
        ComboBox<String> roleBox = new ComboBox<>();
        roleBox.getItems().addAll("Mahasiswa", "Admin");
        roleBox.setValue("Mahasiswa");

        // Input field
        TextField userField = new TextField();
        userField.setPromptText("Username");

        PasswordField passField = new PasswordField();
        passField.setPromptText("Password");

        Button loginBtn = new Button("Login");

        Label messageLabel = new Label();
        messageLabel.setStyle("-fx-text-fill: red;");

        // Aksi Login
        loginBtn.setOnAction(e -> {
            String username = userField.getText();
            String password = passField.getText();
            String selectedRole = roleBox.getValue();

            user loggedUser = null;
            for (user u : DataStore.users) {
                if (u.getUsername().equals(username)
                        && u.getPassword().equals(password)
                        && ((selectedRole.equals("Admin") && u instanceof admin)
                        || (selectedRole.equals("Mahasiswa") && u instanceof mahasiswa))) {
                    loggedUser = u;
                    break;
                }
            }

            if (loggedUser != null) {
                messageLabel.setText("");
                if (loggedUser instanceof admin) {
                    new adminform((admin) loggedUser).show(primaryStage);
                } else if (loggedUser instanceof mahasiswa) {
                    new mahasiswaform((mahasiswa) loggedUser).show(primaryStage);
                }
            } else {
                messageLabel.setText("Login gagal, periksa username atau password.");
            }
        });

        // Layout VBox
        VBox root = new VBox(10);
        root.setPadding(new Insets(20));
        root.setAlignment(Pos.CENTER);
        root.getChildren().addAll(titleLabel, roleBox, userField, passField, loginBtn, messageLabel);


        primaryStage.setTitle("Lost & Found Kampus");
        primaryStage.setScene(new Scene(root, 320, 300));
        primaryStage.show();
    }
}
