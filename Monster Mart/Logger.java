
/**
 * Write a description of class Logger here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

// section logger (mencatat log keluar masuk)
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Logger {
    private String filename;

    public Logger(String filename) {
        this.filename = filename;
    }

    public void log(String message) {
        try (FileWriter fw = new FileWriter(filename, true);
             PrintWriter out = new PrintWriter(fw)) {
            out.println(message);
        } catch (IOException e) {
            System.out.println("Gagal menulis log: " + e.getMessage());
        }
    }
}
