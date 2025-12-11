
/**
 * Write a description of class CustomerGUI here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.text.DecimalFormat; 
import java.text.DecimalFormatSymbols;

public class CustomerGUI extends JFrame {
    
    public CustomerGUI(String username) {
        setTitle("Dashboard Wajib Pajak - User: " + username);
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JLabel lblWelcome = new JLabel("Halo, " + username + "! Cek Status Pajak Anda.", SwingConstants.CENTER);
        lblWelcome.setFont(new Font("Arial", Font.BOLD, 14));
        lblWelcome.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        add(lblWelcome, BorderLayout.NORTH);

        JPanel centerPanel = new JPanel(new GridLayout(4, 1, 5, 5));
        JTextField txtCariNPWP = new JTextField();
        JButton btnCari = new JButton("Cek NPWP Saya");
        JTextArea txtHasil = new JTextArea();
        txtHasil.setEditable(false);

        centerPanel.add(new JLabel("Masukkan NPWP Anda:"));
        centerPanel.add(txtCariNPWP);
        centerPanel.add(btnCari);
        centerPanel.add(new JScrollPane(txtHasil));
        centerPanel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        
        add(centerPanel, BorderLayout.CENTER);
        
        JButton btnLogout = new JButton("Logout");
        add(btnLogout, BorderLayout.SOUTH);

        btnCari.addActionListener(e -> {
            String npwp = txtCariNPWP.getText();
            cariDataPajak(npwp, txtHasil);
        });

        btnLogout.addActionListener(e -> {
            new LoginGUI().setVisible(true);
            this.dispose();
        });
    }

    private void cariDataPajak(String npwp, JTextArea output) {
        String sql = "SELECT * FROM wajib_pajak WHERE npwp = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, npwp);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
            DecimalFormat kursIndonesia = (DecimalFormat) DecimalFormat.getCurrencyInstance();
            DecimalFormatSymbols formatRp = new DecimalFormatSymbols();
    
            formatRp.setCurrencySymbol("Rp ");
            formatRp.setMonetaryDecimalSeparator(',');
            formatRp.setGroupingSeparator('.');
            kursIndonesia.setDecimalFormatSymbols(formatRp);
            kursIndonesia.setMaximumFractionDigits(0);
            
            double penghasilan = rs.getDouble("penghasilan_tahunan");
            double pajak = rs.getDouble("pajak_terutang");
            String statusDb = rs.getString("status"); 

            String penghasilanStr = String.format("Rp %,.0f", penghasilan);
            String pajakStr = String.format("Rp %,.0f", pajak);

    String info = "Nama: " + rs.getString("nama") + "\n" +
                  "Penghasilan: " + penghasilanStr + "\n" +
                  "Pajak Terutang: " + pajakStr + "\n" +
                  "Status: " + statusDb; 
    
    output.setText(info);
            } else {
                output.setText("Data NPWP tidak ditemukan.");
            }
        } catch (Exception e) {
            output.setText("Error Database.");
        }
    }
}