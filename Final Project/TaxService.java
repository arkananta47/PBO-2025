
/**
 * Write a description of class TaxService here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TaxService {

    public double hitungPajak(double penghasilan) {
        return penghasilan * 0.10;
    }

    public boolean simpanData(WajibPajak wp) {
        String sql = "INSERT INTO wajib_pajak (npwp, nama, penghasilan_tahunan, pajak_terutang, status) VALUES (?, ?, ?, ?, ?)";
        
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, wp.getNpwp());
            pstmt.setString(2, wp.getNama());
            pstmt.setDouble(3, wp.getPenghasilan());
            pstmt.setDouble(4, wp.getPajak());
            pstmt.setString(5, wp.getStatus()); 
            
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateData(WajibPajak wp) {
        String sql = "UPDATE wajib_pajak SET nama=?, penghasilan_tahunan=?, pajak_terutang=?, status=? WHERE npwp=?";
        
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, wp.getNama());
            pstmt.setDouble(2, wp.getPenghasilan());
            pstmt.setDouble(3, wp.getPajak());
            pstmt.setString(4, wp.getStatus()); 
            pstmt.setString(5, wp.getNpwp());
            
            int row = pstmt.executeUpdate();
            return row > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<WajibPajak> getAllData() {
        List<WajibPajak> listWp = new ArrayList<>();
        String sql = "SELECT * FROM wajib_pajak";

        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                listWp.add(new WajibPajak(
                    rs.getString("npwp"),
                    rs.getString("nama"),
                    rs.getDouble("penghasilan_tahunan"),
                    rs.getDouble("pajak_terutang"),
                    rs.getString("status")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listWp;
    }
}