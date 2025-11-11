
/**
 * Write a description of class motor here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

public class Motor extends Kendaraan {
    private int jumlahRoda;

    public Motor(String merk, String model, int tahunProduksi, int stok, double hargaSewa, int jumlahRoda) {
        super(merk, model, tahunProduksi, stok, hargaSewa);
        this.jumlahRoda = jumlahRoda;
    }

    @Override
    public void info() {
        System.out.println("[Motor] " + merk + " " + model + " (" + tahunProduksi + 
                           ") - " + jumlahRoda + " roda - Stok: " + stok +
                           " - Harga sewa: Rp" + hargaSewa + "/hari");
    }
}