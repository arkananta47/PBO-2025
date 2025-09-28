
/**
 * Write a description of class matakuliah here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

public class MataKuliah {
    private String kodeMk;
    private String namaMk;
    private int sks;
    private Dosen dosenPengampu;

    public MataKuliah(String kodeMk, String namaMk, int sks, Dosen dosenPengampu) {
        this.kodeMk = kodeMk;
        this.namaMk = namaMk;
        this.sks = sks;
        this.dosenPengampu = dosenPengampu;
    }

    public String getKodeMk() { return kodeMk; }
    public String getNamaMk() { return namaMk; }
    public int getSks() { return sks; }
    public Dosen getDosenPengampu() { return dosenPengampu; }
}