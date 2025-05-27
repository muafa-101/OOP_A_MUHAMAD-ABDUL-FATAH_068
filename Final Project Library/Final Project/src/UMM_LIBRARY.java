import com.mysql.cj.protocol.Resultset;
import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class UMM_LIBRARY extends JDialog{
    public Container panelperpus;
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
                table_load();
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
                    String searchTerm = txSearch.getText();

                    pst = con.prepareStatement("SELECT idBuku, judulBuku, status FROM buku where idBuku  LIKE ? OR judulBuku LIKE ?");
                    pst.setString(1, "%" + searchTerm + "%");
                    pst.setString(2, "%" + searchTerm + "%");
                    rs = pst.executeQuery();

                    if(rs.next()==true)
                    {
                        idBuku = rs.getString(1);
                        judulBuku = rs.getString(2);
                        String status = rs.getString(3);

                        tfID.setText(idBuku);
                        tfTitle.setText(judulBuku);
                        tfStatus.setSelectedIndex(Integer.parseInt(status));
                    }else
                    {
                        tfID.setText("");
                        tfTitle.setText("");
                        tfStatus.setSelectedIndex(0);
                        JOptionPane.showMessageDialog(null, "invalid data search");
                    }
                }
                catch (SQLException ex)
                {

                }
                table_load();
            }
        });


        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String idBuku, judulBuku, status;
                idBuku = tfID.getText();
                judulBuku = tfTitle.getText();
                status = tfStatus.getSelectedItem().toString();


                try {
                    pst = con.prepareStatement("UPDATE buku SET  judulBuku = ?, status = ? WHERE idBuku = ?");
                    pst.setString(1, idBuku);
                    pst.setString(2, judulBuku);
                    pst.setString(3, status);

                    pst.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Data Berhasil Di Update");
                    table_load();
                    tfID.setText("");
                    tfTitle.setText("");
                    tfStatus.setSelectedIndex(0);
                    tfID.requestFocus();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
                table_load();
            }
            });


        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String idBook;
                idBook = tfID.getText();

                try
                {
                    pst = con.prepareStatement("DELETE FROM buku WHERE idBuku = ?");
                    pst.setString(1,idBook);

                    pst.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Data Berhasil Di Delete");
                    table_load();
                    tfID.setText("");
                    tfTitle.setText("");
                    tfStatus.setSelectedIndex(0);
                    tfID.requestFocus();
                }
                catch (SQLException e1)
                {
                    e1.printStackTrace();
                }
                table_load();
            }
        });



    }//umm library

}//keseluruhan code


