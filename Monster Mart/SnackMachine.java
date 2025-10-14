
/**
 * Write a description of class SnackMachine here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class SnackMachine {
    private ArrayList<Product> products;
    private ArrayList<Transaction> transactions;
    private Logger logger;
    private final String PRODUCT_FILE = "products.txt";

    public SnackMachine() {
        products = new ArrayList<>();
        transactions = new ArrayList<>();
        logger = new Logger("transactions.log");

        loadProducts(); 
    }

    private void loadProducts() {
        File file = new File(PRODUCT_FILE);
        if (!file.exists()) {
            System.out.println("File produk belum ditemukan. Membuat data default...");
            products.add(new Product("Chips", 10000, 5));
            products.add(new Product("Coklat", 12000, 5));
            products.add(new Product("Soda", 8000, 5));
            products.add(new Product("Air Mineral", 5000, 5));
            saveProducts(); 
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(";");
                if (data.length == 3) {
                    String name = data[0];
                    int price = Integer.parseInt(data[1]);
                    int stock = Integer.parseInt(data[2]);
                    products.add(new Product(name, price, stock));
                }
            }
        } catch (IOException e) {
            System.out.println("Gagal membaca file produk: " + e.getMessage());
        }
    }

    private void saveProducts() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(PRODUCT_FILE))) {
            for (Product p : products) {
                writer.println(p.toFileFormat());
            }
        } catch (IOException e) {
            System.out.println("Gagal menyimpan data produk: " + e.getMessage());
        }
    }

    public void displayMenu() {
        System.out.println("\n=== VENDING SNACK MACHINE ===");
        for (int i = 0; i < products.size(); i++) {
            System.out.println((i + 1) + ". " + products.get(i));
        }
        System.out.println("A. Mode Admin");
        System.out.println("0. Keluar");
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        String input;

        while (true) {
            displayMenu();
            System.out.print("Pilih produk (0 untuk keluar): ");
            input = scanner.next();

            if (input.equals("0")) {
                System.out.println("Terima kasih! Mesin berhenti.");
                saveProducts(); // Simpan stok sebelum keluar
                break;
            }

            if (input.equalsIgnoreCase("A")) {
                adminMenu(scanner);
                continue;
            }

            int choice;
            try {
                choice = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Input tidak valid!");
                continue;
            }

            if (choice < 1 || choice > products.size()) {
                System.out.println("Pilihan tidak valid!");
                continue;
            }

            Product selected = products.get(choice - 1);

            if (!selected.isAvailable()) {
                System.out.println("Stok habis! Mohon hubungi admin untuk refill.");
                logger.log("[WARNING] Stok habis untuk produk: " + selected.getName());
                continue;
            }

            System.out.println("Anda memilih: " + selected.getName());
            System.out.println("Harga: Rp" + selected.getPrice());
            System.out.print("Masukkan jumlah uang: Rp");

            int payment = scanner.nextInt();

            if (payment >= selected.getPrice()) {
                int change = payment - selected.getPrice();
                selected.dispense();
                saveProducts(); 

                Transaction t = new Transaction(selected.getName(), payment);
                transactions.add(t);
                t.printTransaction();
                logger.log(t.formatTransaction());

                System.out.println("Produk keluar: " + selected.getName());
                if (change > 0) {
                    System.out.println("Kembalian Anda: Rp" + change);
                }
            } else {
                System.out.println("Uang tidak cukup! Transaksi dibatalkan.");
            }
        }

        showSummary();
    }

    private void adminMenu(Scanner scanner) {
        System.out.print("\nMasukkan password admin: ");
        String pass = scanner.next();

        if (!pass.equals("admin123")) {
            System.out.println("Password salah!");
            return;
        }

        boolean lowStock = false;
        for (Product p : products) {
            if (p.getStock() == 0) {
                System.out.println("[Peringatan] Produk '" + p.getName() + "' stoknya habis. Segera refill!");
                lowStock = true;
            }
        }
        if (!lowStock) {
            System.out.println("Semua produk masih tersedia dengan baik.");
        }

        while (true) {
            System.out.println("\n=== MODE ADMIN ===");
            System.out.println("1. Refill stok");
            System.out.println("2. Lihat semua produk");
            System.out.println("3. Lihat total transaksi");
            System.out.println("0. Kembali");

            System.out.print("Pilih menu: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> refillProduct(scanner);
                case 2 -> showProducts();
                case 3 -> System.out.println("Total transaksi: " + transactions.size());
                case 0 -> {
                    saveProducts();
                    return;
                }
                default -> System.out.println("Pilihan tidak valid!");
            }
        }
    }

    private void refillProduct(Scanner scanner) {
        showProducts();
        System.out.print("Pilih nomor produk untuk refill: ");
        int index = scanner.nextInt() - 1;

        if (index < 0 || index >= products.size()) {
            System.out.println("Produk tidak ditemukan!");
            return;
        }

        System.out.print("Masukkan jumlah tambahan stok: ");
        int amount = scanner.nextInt();

        products.get(index).refill(amount);
        saveProducts();
        System.out.println("Stok berhasil ditambah!");

        logger.log("[ADMIN] Refill " + products.get(index).getName() + " sebanyak " + amount);
    }

    private void showProducts() {
        System.out.println("\n=== DAFTAR PRODUK ===");
        for (int i = 0; i < products.size(); i++) {
            System.out.println((i + 1) + ". " + products.get(i));
        }
    }

    private void showSummary() {
        System.out.println("\n=== RINGKASAN MESIN ===");
        for (Product p : products) {
            System.out.println(p);
        }
        System.out.println("========================");
        System.out.println("Total transaksi: " + transactions.size());
    }
}
