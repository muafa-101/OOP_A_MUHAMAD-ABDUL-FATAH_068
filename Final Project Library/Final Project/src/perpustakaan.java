import javax.swing.*;

public class perpustakaan{
    private JPanel panelperpus;

    public static void main(String [] args) {
        JFrame panelperpus = new JFrame("UMM_LIBRARY");
        panelperpus.setContentPane(new UMM_LIBRARY().panelperpus);
        panelperpus.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panelperpus.pack();
        panelperpus.setVisible(true);
    }
}
