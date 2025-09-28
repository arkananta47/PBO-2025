
/**
 * Write a description of class frs_system here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class System_FRS {
    public static void main(String[] args) {
        Dosen dosen1 = new Dosen("Dr. Budi Hartono", "198001012005011001");
        Dosen dosen2 = new Dosen("Prof. Dr. Anisa Lestari", "197503152000122002");

        List<MataKuliah> semuaMataKuliah = new ArrayList<>();
        semuaMataKuliah.add(new MataKuliah("IF101", "Pemrograman Berorientasi Objek", 3, dosen1));
        semuaMataKuliah.add(new MataKuliah("IF102", "Struktur Data", 3, dosen1));
        semuaMataKuliah.add(new MataKuliah("IF103", "Kecerdasan Buatan", 3, dosen2));
        semuaMataKuliah.add(new MataKuliah("MA101", "Kalkulus", 4, dosen2));
        semuaMataKuliah.add(new MataKuliah("IF104", "Jaringan Komputer", 3, dosen1));

        Mahasiswa mhs1 = new Mahasiswa("Aqil", "5025241161");
        Scanner scanner = new Scanner(System.in);
        int pilihan = 0;

        while (pilihan != 4) {
            System.out.println("\n===== Sistem FRS Online =====");
            System.out.println("Mahasiswa: " + mhs1.getNama() + " | Total SKS: " + mhs1.getTotalSks() + "/" + Mahasiswa.MAKS_SKS);
            System.out.println("1. Lihat Daftar Mata Kuliah Tersedia");
            System.out.println("2. Ambil Mata Kuliah");
            System.out.println("3. Lihat FRS Saya");
            System.out.println("4. Keluar");
            System.out.print("Masukkan pilihan Anda: ");
            
            if (scanner.hasNextInt()) {
                pilihan = scanner.nextInt();
            } else {
                System.out.println("Input tidak valid, silakan masukkan angka.");
                scanner.next(); 
                continue; 
            }
            scanner.nextLine();

            switch (pilihan) {
                case 1:
                    System.out.println("\n--- Daftar Mata Kuliah Tersedia ---");
                    for (MataKuliah mk : semuaMataKuliah) {
                        System.out.println(mk.getKodeMk() + " - " + mk.getNamaMk() + " (" + mk.getSks() + " SKS)");
                    }
                    break;
                case 2:
                    System.out.print("Masukkan Kode MK yang ingin diambil: ");
                    String kodeMk = scanner.nextLine().toUpperCase();
                    
                    MataKuliah mkDipilih = null;
                    for (MataKuliah mk : semuaMataKuliah) {
                        if (mk.getKodeMk().equals(kodeMk)) {
                            mkDipilih = mk;
                            break;
                        }
                    }

                    if (mkDipilih != null) {
                        mhs1.tambahMataKuliah(mkDipilih);
                    } else {
                        System.out.println("❌ Kode MK tidak ditemukan!");
                    }
                    break;
                case 3:
                    mhs1.lihatFRS();
                    break;
                case 4:
                    System.out.println("Terima kasih telah menggunakan sistem FRS. Sampai jumpa! 👋");
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan masukkan angka antara 1-4.");
            }
        }
        scanner.close();
    }
}