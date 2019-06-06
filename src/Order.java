import java.util.ArrayList;

public class Order {

    private Customer customer;
    private Shop shop;
    private ArrayList<Integer[][]> idsQuantities;
    private String datetime;
    private static ArrayList<Order> orders = new ArrayList<>();

    public Order(Customer customer, Shop shop, ArrayList<Integer[][]> idsQuantities, String datetime) {
        this.customer = customer;
        this.shop = shop;
        this.idsQuantities = idsQuantities;
        this.datetime = datetime;
        if (customer instanceof RegisteredCustomer)
            orders.add(this);
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    public ArrayList<Integer[][]> getIdsQuantities() {
        return idsQuantities;
    }

    public void setIdsQuantities(ArrayList<Integer[][]> idsQuantities) {
        this.idsQuantities = idsQuantities;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    @Override
    public String toString() {

        String shopName = shop.getName();
        String customerName = customer.getFirstName() + " " + customer.getLastName();
        String products = "";

        for (Integer[][] idQuantity : idsQuantities) {
            String productName = shop.getProducts().get(idQuantity[0][0]-1).getName();
            String quantity = "x" + idQuantity[0][1];
            products += productName + ":    " + quantity + "\n";
        }

        return "Shop Name: " + shopName + "\n" +
                "Customer:  " + customerName + "\n" +
                "Datetime:  " + datetime + "\n" +
                "----- Products -----" + "\n" +
                products;
    }

    public static void printOrder(Customer customer) {

        String leftAlignFormat = "| %-3d | %-20s | %-10s | %-13s|%n";

        System.out.format("+-----+----------------------+------------+--------------+%n");
        System.out.format("| No. | Datetime             | Shop Name  | Total Cost   |%n");
        System.out.format("+-----+----------------------+------------+--------------+%n");

        // if there are no orders print message
        if (orders.isEmpty()) {
            String centerAlignFormat = "|%-22s %-18s %-14s|%n";
            System.out.format(centerAlignFormat, "", "No orders yet", "");
            System.out.format("+-----+----------------------+------------+--------------+%n");
            return;
        }

        int i = 0;
        for (Order order : orders) {
            if (order.getCustomer().equals(customer)) {

                // print it
                System.out.format(leftAlignFormat, ++i, order.datetime, order.shop.getName(), order.calculateTotalCost());
            }
        }
        System.out.format("+-----+----------------------+------------+--------------+%n");
    }

    private String calculateTotalCost() {

        // total cost
        double totalCost = 0;

        for (Integer[][] idQuantity : idsQuantities) {

            // get product
            Product product = shop.getProducts().get(idQuantity[0][0]-1);

            // get product quantity
            int quantity = idQuantity[0][1];

            // get product price
            double price = product.getPrice();

            // calculate cost
            double cost = price * quantity;

            // add to total cost
            totalCost += cost;
        }

        return totalCost + "$";
    }
}
