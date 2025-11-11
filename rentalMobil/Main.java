
/**
 * Write a description of class main here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Kendaraan> daftarKendaraan = new ArrayList<>();
        daftarKendaraan.add(new Mobil("Toyota", "Avanza", 2021, 7, 185000, 4));
        daftarKendaraan.add(new Mobil("Honda", "Jazz", 2012, 4, 200000, 4));
        daftarKendaraan.add(new Mobil("Hyundai", "Palisade", 2022, 2, 750000, 4));
        daftarKendaraan.add(new Motor("Kawasaki", "ZX25R", 2021, 3, 117500, 2));
        daftarKendaraan.add(new Motor("Ducati", "Panigale", 2024, 2, 799000, 2));
        daftarKendaraan.add(new Sepeda("Polygon", "Helios", 2020, 5, 7890, "Balap"));
        daftarKendaraan.add(new Sepeda("United", "Detro", 2019, 5, 4500, "BMX"));

        List<Penyewa> daftarPenyewa = new ArrayList<>();

        while (true) {
            System.out.println("\n=== MENU RENTAL ===");
            System.out.println("1. Lihat daftar kendaraan");
            System.out.println("2. Sewa kendaraan");
            System.out.println("3. Lihat daftar penyewa");
            System.out.println("4. Keluar");
            System.out.print("Pilih menu: ");
            int pilih = sc.nextInt();
            sc.nextLine();

            if (pilih == 1) {
                System.out.println("\n=== DAFTAR KENDARAAN TERSEDIA ===");
                for (int i = 0; i < daftarKendaraan.size(); i++) {
                    System.out.print((i + 1) + ". ");
                    daftarKendaraan.get(i).info();
                }

            } else if (pilih == 2) {
                System.out.print("Masukkan nama penyewa: ");
                String nama = sc.nextLine();

                System.out.println("\nPilih kendaraan yang ingin disewa:");
                for (int i = 0; i < daftarKendaraan.size(); i++) {
                    System.out.print((i + 1) + ". ");
                    daftarKendaraan.get(i).info();
                }

                System.out.print("Masukkan nomor kendaraan: ");
                int idx = sc.nextInt() - 1;
                sc.nextLine();

                if (idx >= 0 && idx < daftarKendaraan.size()) {
                    Kendaraan k = daftarKendaraan.get(idx);
                    if (k.tersedia()) {
                        System.out.print("Berapa hari ingin disewa? ");
                        int hari = sc.nextInt();
                        sc.nextLine();

                        k.sewa();
                        Penyewa p = new Penyewa(nama, k, hari);
                        daftarPenyewa.add(p);
                        System.out.println("\n✅ " + nama + " berhasil menyewa " + k.merk + " " + k.model);
                        System.out.println("Total biaya: Rp" + (k.getHargaSewa() * hari));
                    } else {
                        System.out.println("❌ Maaf, stok kendaraan ini habis.");
                    }
                } else {
                    System.out.println("Pilihan tidak valid!");
                }

            } else if (pilih == 3) {
                System.out.println("\n=== DAFTAR PENYEWA ===");
                if (daftarPenyewa.isEmpty()) {
                    System.out.println("Belum ada penyewa.");
                } else {
                    for (Penyewa p : daftarPenyewa) {
                        p.info();
                    }
                }

            } else if (pilih == 4) {
                System.out.println("Terima kasih telah menggunakan layanan kami!");
                break;
            } else {
                System.out.println("Pilihan tidak valid!");
            }
        }

        sc.close();
    }
}