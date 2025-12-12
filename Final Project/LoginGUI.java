
/**
 * Write a description of class LoginGUI here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import javax.swing.*;
import java.awt.*;

public class LoginGUI extends JFrame {
    private JTextField txtUser;
    private JPasswordField txtPass;
    private AuthService authService;

    public LoginGUI() {
        authService = new AuthService();

        setTitle("Login Coretax");
        setSize(350, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(5, 2, 10, 10)); 

        add(new JLabel("  Username:"));
        txtUser = new JTextField();
        add(txtUser);

        add(new JLabel("  Password:"));
        txtPass = new JPasswordField();
        add(txtPass);

        add(new JLabel("")); 
        JButton btnLogin = new JButton("Login");
        add(btnLogin);

        add(new JLabel(""));
        JButton btnDaftar = new JButton("Buat Akun Baru");
        add(btnDaftar);

        JLabel lblStatus = new JLabel("");
        add(lblStatus);

        btnLogin.addActionListener(e -> {
            String user = txtUser.getText();
            String pass = new String(txtPass.getPassword());
            
            String role = authService.checkLogin(user, pass);

            if (role == null) {
                JOptionPane.showMessageDialog(this, "Username/Password Salah!");
            } else if (role.equals("admin")) {
                new AdminGUI().setVisible(true);
                this.dispose();
            } else if (role.equals("customer")) {
                new CustomerGUI(user).setVisible(true);
                this.dispose();
            }
        });

        btnDaftar.addActionListener(e -> {
            new SignUpGUI().setVisible(true);
            this.dispose(); 
        });
    }
}