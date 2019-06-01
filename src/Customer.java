import java.util.ArrayList;

public abstract class Customer {

    private String name;
    private String phoneNumber;
    private String address;
    private static ArrayList<Customer> customers = new ArrayList<Customer>();

    public Customer(String name, String phoneNumber, String address) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
        customers.add(this);
    }

    public abstract void getMenu();

    public static ArrayList<Customer> getCustomers() {
        return customers;
    }
}
