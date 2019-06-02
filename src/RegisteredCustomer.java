import java.util.ArrayList;
import java.util.Scanner;

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

    @Override
    public void getMenu() {

        // create a scanner object
        Scanner scanner = new Scanner(System.in);

        // welcome message
        System.out.println("Welcome " + getFirstName() + " " + getLastName());

        // print the menu
        System.out.println("===== Registered Menu =====");
        System.out.println("1. Coming soon");
        System.out.println("2. Show available shops");
        System.out.println("3. Coming soon");

        String option = "";
        while (true) {
            // read user input
            System.out.print("Select an option [1-3]: ");
            option = scanner.nextLine();

            // if user gives valid input continue
            if (option.equals("1") || option.equals("2") || option.equals("3"))
                break;
        }

        switch (option) {
            case "1":
                break;
            case "2":
                showAvailableShops();
                break;
            case "3":
        }
    }

    private void showAvailableShops() {

    }
}
