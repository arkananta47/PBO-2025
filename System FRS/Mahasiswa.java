
/**
 * Write a description of class mahasiswa here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import java.util.ArrayList;
import java.util.List;

public class Mahasiswa {
    private String nama;
    private String nrp;
    private List<MataKuliah> daftarMataKuliah;
    private int totalSks;

    public static final int MAKS_SKS = 15;

    public Mahasiswa(String nama, String nrp) {
        this.nama = nama;
        this.nrp = nrp;
        this.daftarMataKuliah = new ArrayList<>();
        this.totalSks = 0;
    }

    public void tambahMataKuliah(MataKuliah mataKuliah) {
        if (totalSks + mataKuliah.getSks() > MAKS_SKS) {
            System.out.println("❌ GAGAL: Penambahan '" + mataKuliah.getNamaMk() + "' akan melebihi batas SKS (" + totalSks + "/" + MAKS_SKS + ").");
            return;
        }

        daftarMataKuliah.add(mataKuliah);
        this.totalSks += mataKuliah.getSks();
        System.out.println("✅ BERHASIL: '" + mataKuliah.getNamaMk() + "' ditambahkan ke FRS Anda.");
    }

    public void lihatFRS() {
        System.out.println("\n===== FRS Mahasiswa: " + this.nama + " (" + this.nrp + ") =====");
        if (daftarMataKuliah.isEmpty()) {
            System.out.println("Belum ada mata kuliah yang diambil.");
        } else {
            for (MataKuliah mk : daftarMataKuliah) {
                System.out.println("- " + mk.getKodeMk() + " | " + mk.getNamaMk() + " (" + mk.getSks() + " SKS) - Dosen: " + mk.getDosenPengampu().getNama());
            }
        }
        System.out.println("---------------------------------------------------------");
        System.out.println("Total SKS diambil: " + this.totalSks + "/" + MAKS_SKS);
        System.out.println("=========================================================\n");
    }

    public String getNama() {
        return nama;
    }

    public String getNrp() {
        return nrp;
    }

    public int getTotalSks() {
        return totalSks;
    }
}