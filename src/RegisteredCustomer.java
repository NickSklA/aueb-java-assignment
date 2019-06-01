import java.util.ArrayList;

public class RegisteredCustomer extends Customer {

    private int id;
    private String email;
    private String password;

    public RegisteredCustomer(String email, String password, String firstName, String lastName, String phoneNumber, String address) {
        super(firstName, lastName, phoneNumber, address);
        this.id = generateId();
        this.email = email;
        this.password = password;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    @Override
    public void getMenu() {
        System.out.println("----- Menu -----");
    }

    public static RegisteredCustomer login(String email, String password) {

        // get customer list
        ArrayList<Customer> customers = Customer.getCustomers();

        // loop through customer list
        for (Customer customer : customers) {
            if (customer instanceof RegisteredCustomer) {
                if (((RegisteredCustomer) customer).getEmail().equals(email))
                    if (((RegisteredCustomer) customer).getPassword().equals(password))
                        return (RegisteredCustomer) customer;
            }
        }

        // no customer found with this email & password
        return null;
    }
}
