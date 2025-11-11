
/**
 * Write a description of class penyewa here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

public class Penyewa {
    private String nama;
    private Kendaraan kendaraan;
    private int lamaSewa;
    private double totalHarga;

    public Penyewa(String nama, Kendaraan kendaraan, int lamaSewa) {
        this.nama = nama;
        this.kendaraan = kendaraan;
        this.lamaSewa = lamaSewa;
        this.totalHarga = kendaraan.getHargaSewa() * lamaSewa;
    }

    public void info() {
        System.out.println("Nama Penyewa: " + nama);
        System.out.print("Menyewa kendaraan: ");
        kendaraan.info();
        System.out.println("Lama sewa: " + lamaSewa + " hari");
        System.out.println("Total biaya sewa: Rp" + totalHarga);
        System.out.println();
    }
}