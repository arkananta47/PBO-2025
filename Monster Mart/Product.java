
/**
 * Write a description of class Product here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

public class Product {
    private String name;
    private int price;
    private int stock;

    public Product(String name, int price, int stock) {
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

    public boolean isAvailable() {
        return stock > 0;
    }

    public void dispense() {
        if (stock > 0) {
            stock--;
        }
    }

    public void refill(int amount) {
        stock += amount;
    }

    public String toFileFormat() {
        return name + ";" + price + ";" + stock;
    }

    @Override
    public String toString() {
        return name + " - Rp" + price + " (" + stock + " tersedia)";
    }
}
