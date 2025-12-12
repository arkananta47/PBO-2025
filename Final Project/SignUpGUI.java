
/**
 * Write a description of class SignUpGUI here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import javax.swing.*;
import java.awt.*;

public class SignUpGUI extends JFrame {
    private JTextField txtUser;
    private JPasswordField txtPass;
    private AuthService authService;

    public SignUpGUI() {
        authService = new AuthService();

        setTitle("Daftar Akun Baru");
        setSize(350, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(5, 2, 10, 10));

        add(new JLabel("  Username Baru:"));
        txtUser = new JTextField();
        add(txtUser);

        add(new JLabel("  Password Baru:"));
        txtPass = new JPasswordField();
        add(txtPass);

        add(new JLabel("")); 
        JButton btnDaftar = new JButton("Daftar Sekarang");
        add(btnDaftar);

        add(new JLabel("")); 
        JButton btnBatal = new JButton("Kembali ke Login");
        add(btnBatal);
        
        add(new JLabel("")); 
        add(new JLabel("")); 

        btnDaftar.addActionListener(e -> {
            String user = txtUser.getText();
            String pass = new String(txtPass.getPassword());

            if (user.isEmpty() || pass.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Username dan Password tidak boleh kosong!");
                return;
            }

            if (authService.register(user, pass)) {
                JOptionPane.showMessageDialog(this, "Registrasi Berhasil! Silakan Login.");
                new LoginGUI().setVisible(true);
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Gagal! Username mungkin sudah dipakai.");
            }
        });

        btnBatal.addActionListener(e -> {
            new LoginGUI().setVisible(true);
            this.dispose();
        });
    }
}