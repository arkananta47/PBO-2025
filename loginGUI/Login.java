
/**
 * Write a description of class loginGUI here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import javax.swing.*;  
import java.awt.*;  
import java.awt.event.*; 

public class Login {
    String Username = "aqil";
    String Password = "tes123";
    String msg = " ";
    JTextField txtUsername;
    JTextField txtPassword;
    public static void main(String[] args) {
        Login gui = new Login();
        gui.go();
    }
    public void go() {
        JFrame frame = new JFrame("Login Form");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel(new GridLayout(3, 2));
        JLabel lblUsername = new JLabel("Username:");
        JLabel lblPassword = new JLabel("Password:");
        txtUsername = new JTextField(20);
        txtPassword = new JTextField(20);
        JButton btnLogin = new JButton("Login");
        btnLogin.addActionListener(new LoginListener());
        JButton btnCancel = new JButton("Cancel");
        btnCancel.addActionListener(new CancelListener());
        panel.add(lblUsername);
        panel.add(txtUsername);
        panel.add(lblPassword);
        panel.add(txtPassword);
        panel.add(btnLogin);
        panel.add(btnCancel);
        frame.add(panel);
        frame.setSize(300, 150);
        frame.setVisible(true);
    }
    public class LoginListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            if (Username.equals(txtUsername.getText())) {
                if (Password.equals(txtPassword.getText())) {
                    msg = "Login Granted!";
                } else {
                    msg = "Login Denied";
                }
            } else {
                msg = "Login Denied";
            }
            JOptionPane.showMessageDialog(null, msg);
        }
    }
    public class CancelListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            txtUsername.setText("");
            txtPassword.setText("");
            txtUsername.requestFocus();
        }
    }
}