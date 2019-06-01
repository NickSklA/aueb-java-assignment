import java.util.ArrayList;

public class RegisteredCustomer extends Customer {

    private int id;
    private String email;
    private String pass;

    public RegisteredCustomer(String email, String pass, String name, String phoneNumber, String address) {
        super(name, phoneNumber, address);
        this.id = generateId();
        this.email = email;
        this.pass = pass;
    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    @Override
    public void getMenu() {
        System.out.println("----- Menu -----");
    }

    private int generateId() {

        // get stored customers list
        ArrayList<Customer> customers = Customer.getCustomers();

        // if customers size equals 1
        // give id: 1
        // else find last register customer
        // give his id+1
        if (customers.size() == 1) {
            return 1;
        }
        else {
            // start loop from the second last customer
            // cause the last one is the one which just create
            for (int i = customers.size()-2; i >= 0; i--) {
                if (customers.get(i) instanceof RegisteredCustomer) {
                    return ((RegisteredCustomer) customers.get(i)).getId() + 1;
                }
            }
        }

        // in case something goes wrong
        return -1;
    }
}
