import java.util.ArrayList;

public class Order {

    private Customer customer;
    private Shop shop;
    private ArrayList<Integer[][]> idsQuantities;
    private String datetime;
    private static ArrayList<Order> orders;

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
        return "Order{" +
                "customer=" + customer +
                ", shop=" + shop +
                ", idsQuantities=" + idsQuantities +
                ", datetime='" + datetime + '\'' +
                '}';
    }

    public static void printOrder() {
        for (Order order : orders) {
            order.toString();
        }
    }
}
