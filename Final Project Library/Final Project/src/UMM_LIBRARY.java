import com.mysql.cj.protocol.Resultset;
import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class UMM_LIBRARY extends JDialog{
    private JPanel loginPanel;
    private JTextField tfID;
    private JTextField tfTitle;
    private JTable table1;
    private JButton saveButton;
    private JButton updateButton;
    private JButton deleteButton;
    private JButton searchButton;
    private JTextField txSearch;
    private JComboBox tfStatus;
    private JScrollPane table_1;
    private JButton btnBorrow;

    public static void main(String[] args) {
        JFrame frame = new JFrame("UMM_LIBRARY");
        frame.setContentPane(new UMM_LIBRARY().loginPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    Connection con;
    PreparedStatement pst;
    ResultSet rs;

    public void connect(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/belajar_mysql", "root", "");
            System.out.println("Connected to the database");
        }
        catch (ClassNotFoundException ex)
        {
            ex.printStackTrace();
        }
        catch (SQLException ex)
        {
            ex.printStackTrace();
        }
    }

    void table_load()
    {
        try
        {
           pst = con.prepareStatement("select * from buku ");
           rs = pst.executeQuery();
           table1.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }





    public UMM_LIBRARY() {
        connect();
        table_load();
//        bikin tombol save
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String idBuku, judulBuku, status;
                idBuku = tfID.getText();
                judulBuku = tfTitle.getText();
                status = tfStatus.getSelectedItem().toString();

                try{
//                    ini insert into buku ke table belajar_mysql
                    pst = con.prepareStatement("insert into buku(idBuku, judulBuku, status)values(?, ?, ?)");
                    pst.setString(1, idBuku);
                    pst.setString(2, judulBuku);
                    pst.setString(3, status);
                    pst.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Data Berhasil Di Tambahkan");
                    tfID.setText("");
                    tfTitle.setText("");
                    tfStatus.setSelectedIndex(0);
                    tfID.requestFocus();
                }
                catch (SQLException e1)
                {
                    e1.printStackTrace();
                }
            }
        });


        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try
                {
                    String idBuku, judulBuku;
                    idBuku = txSearch.getText();
                    judulBuku = txSearch.getText();
                }
            }
        });
    }
}


