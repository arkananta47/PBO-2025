
/**
 * Write a description of class kendaraan here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

public abstract class Kendaraan {
    protected String merk;
    protected String model;
    protected int tahunProduksi;
    protected int stok;
    protected double hargaSewa;

    public Kendaraan(String merk, String model, int tahunProduksi, int stok, double hargaSewa) {
        this.merk = merk;
        this.model = model;
        this.tahunProduksi = tahunProduksi;
        this.stok = stok;
        this.hargaSewa = hargaSewa;
    }

    public boolean tersedia() {
        return stok > 0;
    }

    public void sewa() {
        if (stok > 0) stok--;
        else System.out.println("Stok kendaraan ini habis!");
    }

    public void kembalikan() {
        stok++;
    }

    public double getHargaSewa() {
        return hargaSewa;
    }

    public abstract void info();
}