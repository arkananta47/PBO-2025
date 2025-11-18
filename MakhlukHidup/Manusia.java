
/**
 * Write a description of class Manusia here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

class Manusia extends MakhlukHidup {
    
    public Manusia(String nama) {
        super(nama);
    }
    
    @Override
    public void membutuhkanEnergi() {
        System.out.println("Makhluk hidup membutuhkan energi dan menjalani proses kehidupan.");
        System.out.println(nama + " makan dengan cara memasak dan mengonsumsi makanan kompleks.");
    }
    
    @Override
    public void berkembangBiak() {
        System.out.println(nama + " berkembang biak secara melahirkan.");
    }
    
    public void kemampuanKhusus() {
        System.out.println(nama + " dapat berbicara menggunakan bahasa.");
    }
}