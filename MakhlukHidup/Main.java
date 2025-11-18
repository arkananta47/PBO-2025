
/**
 * Write a description of class main here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

public class Main {
    public static void main(String[] args) {
        Manusia mangJarwo = new Manusia("mangJarwo");
        mangJarwo.tampilkanInfo();
        mangJarwo.membutuhkanEnergi();
        mangJarwo.berkembangBiak();
        mangJarwo.kemampuanKhusus();
        
        System.out.println();
        
        Hewan Beruang = new Hewan("Beruang", "Karnivora");
        Beruang.tampilkanInfo();
        Beruang.membutuhkanEnergi();
        Beruang.berkembangBiak();
        
        System.out.println();
        
        Tumbuhan Anggrek = new Tumbuhan("Anggrek");
        Anggrek.tampilkanInfo();
        Anggrek.membutuhkanEnergi();
        Anggrek.berkembangBiak();
    }
}