import java.util.ArrayList;

public class Product {

    private int id;
    private String name;
    private double price;
    private static ArrayList<Product> products = new ArrayList<>();

    public Product(String name, double price) {
        this.id = generateId();
        this.name = name;
        this.price = price;
        products.add(this);
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public static ArrayList<Product> getProducts() {
        return products;
    }

    private int generateId() {

        // if there are no products
        // give id: 1
        if (products.size() == 0) {
            return 1;
        }
        else {
            // find last product's id
            int lastId = products.get(products.size()-1).getId();
            return lastId + 1;
        }
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
