import java.util.ArrayList;

public class Shop {

    private int id;
    private String name;
    private String address;
    private ArrayList<Product> products;

    public Shop(int id, String name, String address, ArrayList<Product> products) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.products = products;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    public static void printAllShops() {
        System.out.println();
    }

    public static void filterAndPrintShops(String param) {

    }

    @Override
    public String toString() {
        return "Shop{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", products=" + products +
                '}';
    }
}
