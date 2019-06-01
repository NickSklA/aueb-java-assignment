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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public abstract void getMenu();

    public static ArrayList<Customer> getCustomers() {
        return customers;
    }
}
