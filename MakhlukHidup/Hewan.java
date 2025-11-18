
/**
 * Write a description of class Hewan here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

class Hewan extends MakhlukHidup {
    private String jenisHewan;
    
    public Hewan(String nama, String jenisHewan) {
        super(nama);
        this.jenisHewan = jenisHewan;
    }
    
    @Override
    public void membutuhkanEnergi() {
        System.out.println("Makhluk hidup membutuhkan energi dan menjalani proses kehidupan.");
        System.out.println(nama + " memperoleh makanan dengan cara berburu, mencari, atau menyaring sesuai jenisnya.");
    }
    
    @Override
    public void berkembangBiak() {
        System.out.println(nama + " berkembang biak secara bertelur, melahirkan, atau ovovivipar.");
    }
}