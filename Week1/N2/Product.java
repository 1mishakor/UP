package Misha.Week1.N2;

public class Product {
    private int id;
    private String name;
    private String UPC;
    private String Manufacturer;
    private double price;
    private short ShelfLife;
    private int quantity;

    public Product(int id, String name, String UPC, String Manufacturer, double price, short ShelfLife, int quantity) {
        this.id = id;
        this.name = name;
        this.UPC = UPC;
        this.Manufacturer = Manufacturer;
        this.price = price;
        this.ShelfLife = ShelfLife;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUPC() {
        return UPC;
    }

    public void setUPC(String UPC) {
        this.UPC = UPC;
    }

    public String getManufacturer() {
        return Manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        Manufacturer = manufacturer;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public short getShelfLife() {
        return ShelfLife;
    }

    public void setShelfLife(short shelfLife) {
        ShelfLife = shelfLife;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String toString() {
        return "ID: " + id + ", " +
                "Наименование: " + name + ", " +
                "UPC: " + UPC + ", " +
                "Производитель: " + Manufacturer + ", " +
                "Цена: " + price + ", " +
                "Срок хранения: " + ShelfLife + ", " +
                "Количество: " + quantity + ".";
    }
}
