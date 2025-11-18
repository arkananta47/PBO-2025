
/**
 * Write a description of class MakhlukHidup here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

abstract class MakhlukHidup {
    protected String nama;
    
    public MakhlukHidup(String nama) {
        this.nama = nama;
    }
    
    public abstract void membutuhkanEnergi();
    public abstract void berkembangBiak();
    
    public void tampilkanInfo() {
        System.out.println("Nama: " + nama);
    }
}