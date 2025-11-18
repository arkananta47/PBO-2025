
/**
 * Write a description of class Tumbuhan here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

class Tumbuhan extends MakhlukHidup {
    
    public Tumbuhan(String nama) {
        super(nama);
    }
    
    @Override
    public void membutuhkanEnergi() {
        System.out.println("Makhluk hidup membutuhkan energi dan menjalani proses kehidupan.");
        System.out.println(nama + " memperoleh nutrisi melalui proses fotosintesis dan penyerapan mineral dari tanah.");
    }
    
    @Override
    public void berkembangBiak() {
        System.out.println(nama + " berkembang biak melalui biji, spora, tunas, atau stek.");
    }
}