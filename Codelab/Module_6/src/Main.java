import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import java.util.Random;

public class Main extends Application
{
    Random random = new Random();
    int angkaRahasia = random.nextInt(100) + 1; // membuat random angka dari 1 sampai 100
    int jumlahPercobaan = 5; //jumlah nyawa game

    @Override
    public void start(Stage primaryStage)
    {
        Label label = new Label("Tebak aku dari 1 sampai 100");
        Button button = new Button("Tebak");
        TextField text = new TextField();
        Label label2 = new Label("");// ditandai kosong karena nanti dipakai untuk menampilkan pesan
        Label labelPercobaan = new Label("Jumlah percobaan: " + jumlahPercobaan);

        button.setDefaultButton(true); // agar tombol bisa di enter menggunakan keyboard
        button.setOnAction(e ->
        {
            String inputtext = text.getText();
            try
            {
                if (button.getText().equals("Main Lagi"))
                {
                    // Reset game
                    jumlahPercobaan = 5;
                    angkaRahasia = random.nextInt(100) + 1;
                    label2.setText("");
                    labelPercobaan.setText("Jumlah percobaan: " + jumlahPercobaan);
                    text.clear();
                    text.setDisable(false);
                    button.setText("Tebak");
                    button.setDefaultButton(true);
                    button.setDisable(false);
                    return;
                }
                int angkaTebakan = Integer.parseInt(inputtext); // mengkonversi String inputtext ke int angkaTebakan
                if (jumlahPercobaan <= 0) {
                    label2.setText("Game Over! Angka rahasia adalah: " + angkaRahasia);
                    button.setDisable(true);
                    text.setDisable(true);
                    return;
                }
                if(angkaTebakan == angkaRahasia)
                {
                    label2.setText("Tebakan kamu benar!!!");
                    button.setDisable(true);
                    text.setDisable(true);
                }
                else
                {
                    jumlahPercobaan--; // mengurangi jumlah percobaan
                    labelPercobaan.setText("Jumlah percobaan: " + jumlahPercobaan);

                    if (angkaTebakan > angkaRahasia)
                        label2.setText("Terlalu besar!");
                    else
                        label2.setText("Terlalu kecil!");

                    if (jumlahPercobaan == 0) {
                        label2.setText("Game Over! Angka rahasia adalah: " + angkaRahasia);
                        text.setDisable(true); // mematikan fungsi text
                        button.setText("Main Lagi"); // agar kondisi diatas bisa membuat game restart
                    }
                }
            }
            catch (NumberFormatException ex)
            {
                label2.setText("Input tidak valid. Masukkan angka!");
                System.err.println("Error konversi: " + ex.getMessage());
            }
            text.clear();
        });
        HBox inputButtonBox = new HBox(10, text, button); // TextField dan Button dalam satu baris
        inputButtonBox.setAlignment(Pos.CENTER); // Pusatkan HBox

        VBox root = new VBox(20, label, inputButtonBox, label2, labelPercobaan);
        root.setAlignment(Pos.CENTER); //dicenter

        Scene scene = new Scene(root, 650, 450); //ukuran dari aplikasi

        primaryStage.setScene(scene);
        primaryStage.setTitle("Tebak Aku");// untuk judul stage yang ada di window aplikasi ketika dibuka
        primaryStage.setResizable(true); // agar ukuran aplikasi bisa diubah ubah walau defaultnya 300 x 250
        primaryStage.show(); // method menampilkan stage

    }
    public static void main (String[] args)
    {
        launch(args);
    }
}