
/**
 * Write a description of class Transaction here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

// transaction section

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transaction {
    private String productName;
    private int amountPaid;
    private LocalDateTime date;

    public Transaction(String productName, int amountPaid) {
        this.productName = productName;
        this.amountPaid = amountPaid;
        this.date = LocalDateTime.now();
    }

    public String getProductName() {
        return productName;
    }

    public int getAmountPaid() {
        return amountPaid;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public String formatTransaction() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        return String.format("[%s] Produk: %s | Bayar: Rp%d",
                date.format(formatter), productName, amountPaid);
    }

    public void printTransaction() {
        System.out.println("=== Log Transaksi ===");
        System.out.println("Produk : " + productName);
        System.out.println("Jumlah Bayar : Rp" + amountPaid);
        System.out.println("Waktu : " + date.format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")));
        System.out.println("=====================");
    }
}
