import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        loadObjects();
    }

    static void loadObjects() {
        Product product = new Product(1, "Fish", 2.3);
        Product product2 = new Product(2, "Fish2", 2.3);
        Product product3 = new Product(3, "Fish3", 2.3);

        ArrayList<Product> products = new ArrayList<>();
        products.add(product);
        products.add(product2);
        products.add(product3);

        Shop shop = new Shop(1, "Name", "Address", products);
        Shop shop2 = new Shop(2, "Name2", "Address2", products);


        Shop.printAllShops();

        Customer customer = new RegisteredCustomer(123, "@gmail.com", "1234", "name", "6942277574", "glyfada");
        Customer customer2 = new RegisteredCustomer(1234, "@gmail.com", "1234", "name", "6942277574", "glyfada");


        System.out.println();

    }
}
