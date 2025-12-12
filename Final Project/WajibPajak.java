
/**
 * Write a description of class WajibPajak here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

public class WajibPajak {
    private String npwp;
    private String nama;
    private double penghasilan;
    private double pajak;
    private String status; 

    public WajibPajak(String npwp, String nama, double penghasilan, double pajak, String status) {
        this.npwp = npwp;
        this.nama = nama;
        this.penghasilan = penghasilan;
        this.pajak = pajak;
        this.status = status;
    }

    public String getNpwp() { return npwp; }
    public String getNama() { return nama; }
    public double getPenghasilan() { return penghasilan; }
    public double getPajak() { return pajak; }
    public String getStatus() { return status; } 
}