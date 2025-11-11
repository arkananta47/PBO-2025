
/**
 * Write a description of class sepeda here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

public class Sepeda extends Kendaraan {
    private String jenisSepeda;

    public Sepeda(String merk, String model, int tahunProduksi, int stok, double hargaSewa, String jenisSepeda) {
        super(merk, model, tahunProduksi, stok, hargaSewa);
        this.jenisSepeda = jenisSepeda;
    }

    @Override
    public void info() {
        System.out.println("[Sepeda] " + merk + " " + model + " (" + tahunProduksi + 
                           ") - Jenis: " + jenisSepeda + " - Stok: " + stok +
                           " - Harga sewa: Rp" + hargaSewa + "/hari");
    }
}