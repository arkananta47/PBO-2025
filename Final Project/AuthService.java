
/**
 * Write a description of class AuthService here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AuthService {
    
    public String checkLogin(String user, String pass) {
        String role = null;
        String sql = "SELECT role FROM users WHERE username = ? AND password = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, user);
            pstmt.setString(2, pass);
            
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                role = rs.getString("role");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return role;
    }

    public boolean register(String user, String pass) {
        String sql = "INSERT INTO users (username, password, role) VALUES (?, ?, 'customer')";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, user);
            pstmt.setString(2, pass);
            
            int row = pstmt.executeUpdate();
            return row > 0;
        } catch (SQLException e) {
            return false; 
        }
    }
}