package com.praktikummodule6.app;
import com.praktikummodule6.gui.loginform;
import javafx.application.Application;
import javafx.stage.Stage;

public class main extends Application {
    @Override
    public void start(Stage stage) {
        new loginform().show(stage);
    }

    public static void main(String[] args) {
        launch();
    }
}
