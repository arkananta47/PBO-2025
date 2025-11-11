
/**
 * Write a description of class mobil here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

public class Mobil extends Kendaraan {
    private int jumlahRoda;

    public Mobil(String merk, String model, int tahunProduksi, int stok, double hargaSewa, int jumlahRoda) {
        super(merk, model, tahunProduksi, stok, hargaSewa);
        this.jumlahRoda = jumlahRoda;
    }

    @Override
    public void info() {
        System.out.println("[Mobil] " + merk + " " + model + " (" + tahunProduksi + 
                           ") - " + jumlahRoda + " roda - Stok: " + stok +
                           " - Harga sewa: Rp" + hargaSewa + "/hari");
    }
}