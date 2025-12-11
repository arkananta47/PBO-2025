
/**
 * Write a description of class DBConnection here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/coretax_db";
    private static final String USER = "root"; 
    private static final String PASSWORD = ""; 

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}