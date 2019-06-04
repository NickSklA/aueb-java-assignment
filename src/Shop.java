import java.util.ArrayList;

public class Shop {

    private int id;
    private String name;
    private String address;
    private String phoneNumber;
    private ArrayList<Product> products;
    private static ArrayList<Shop> shops = new ArrayList<>();

    public Shop(String name, String address, String phoneNumber, ArrayList<Product> products) {
        this.id = generateId();
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.products = products;
        shops.add(this);
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    private int generateId() {

        // if there are no shops
        // give id: 1
        if (shops.size() == 0) {
            return 1;
        }
        else {
            // find last shop's id
            int lastId = shops.get(shops.size()-1).getId();
            return lastId + 1;
        }
    }

    public boolean productIdExists(int productId) {
        for (Product product : products) {
            if (product.getId() == productId)
                return true;
        }
        return false;
    }

    public String printProductName(int productId) {
        for (Product product : products) {
            if (product.getId() == productId)
                return product.getName();
        }
        return "";
    }

    public double printProductPrice(int productId) {
        for (Product product : products) {
            if (product.getId() == productId)
                return product.getPrice();
        }
        return -1;
    }

    public void printCatalogue() {
        String leftAlignFormat = "| %-3d | %-8s | %-9.2f|%n";

        System.out.format("+-----+----------+----------+%n");
        System.out.format("| ID  | Name     | Price    |%n");
        System.out.format("+-----+----------+----------+%n");

        for (Product product : products) {
            System.out.format(leftAlignFormat, product.getId(), product.getName(), product.getPrice());
        }

        System.out.format("+-----+----------+----------+%n");
        System.out.println();
    }

    public static Shop searchId(int shopId) {
        for (Shop shop : shops) {
            if (shop.getId() == shopId)
                return shop;
        }
        return null;
    }

    public static void printAllShops() {
        String leftAlignFormat = "| %-3d | %-8s | %-10s | %-11s |%n";

        System.out.format("+-----+----------+------------+-------------+%n");
        System.out.format("| ID  | Name     | Address    | Phone No.   |%n");
        System.out.format("+-----+----------+------------+-------------+%n");

        for (Shop shop : shops) {
            System.out.format(leftAlignFormat, shop.getId(), shop.getName(), shop.getAddress(), shop.getPhoneNumber());
        }

        System.out.format("+-----+----------+------------+-------------+%n");
        System.out.println();
    }

    public static void filterAndPrintShops(String shopName) {
        String leftAlignFormat = "| %-3d | %-8s | %-10s | %-11s |%n";

        System.out.format("+-----+----------+------------+-------------+%n");
        System.out.format("| ID  | Name     | Address    | Phone No.   |%n");
        System.out.format("+-----+----------+------------+-------------+%n");

        for (Shop shop : shops) {
            if (shop.getName().toLowerCase().contains(shopName.toLowerCase())) {
                System.out.format(leftAlignFormat, shop.getId(), shop.getName(), shop.getAddress(), shop.getPhoneNumber());
            }
        }

        System.out.format("+-----+----------+------------+-------------+%n");
        System.out.println();
    }
}
