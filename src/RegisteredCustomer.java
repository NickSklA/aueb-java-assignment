import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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

        while (true) {

            // print the menu
            System.out.println("===== Registered Menu =====");
            System.out.println("1. My orders");
            System.out.println("2. Available shops");
            System.out.println("3. Catalogue - New Order \n");

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
                    showCatalogue();
            }
        }
    }

    private void showAvailableShops() {

        // create a scanner object
        Scanner scanner = new Scanner(System.in);

        System.out.println();
        System.out.print("Search shop by name: ");

        String searchName = scanner.nextLine();
        while (searchName != null) {

            // given no name
            if (searchName.isEmpty()) {
                Shop.printAllShops();
                return;
            }
            else {
                // given name
                Shop.filterAndPrintShops(searchName);
                break;
            }
        }
    }

    private void showCatalogue() {

        // create a scanner object
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println();
            System.out.print("Shop id: ");

            // read shop id
            String shopId = scanner.nextLine();
            while (shopId != null) {
                // read enter key
                if (shopId.isEmpty()) {
                    return;
                }
                else {

                    try {
                        // given shop id
                        // search for shop id
                        Shop requestedShop = Shop.searchId(Integer.parseInt(shopId));

                        // if shop exists
                        if (requestedShop != null) {
                            requestedShop.printCatalogue();
                            ArrayList<Integer[][]> idsQuantities = makeOrder(requestedShop);
                            checkout(requestedShop, idsQuantities);
                            return;
                        }
                        else {
                            System.out.print("The shop id " + shopId + " does not exist!\n");
                            System.out.print("Enter new id or press enter key to return.\n");
                        }

                        // exit loop
                        break;
                    }
                    catch (Exception e) {
                        System.out.println("Wrong input! Try again.");
                        break;
                    }
                }
            }
        }
    }

    private void checkout(Shop requestedShop, ArrayList<Integer[][]> idsQuantities) {
        System.out.println();
        System.out.println("===== Checkout =====");
        System.out.println("Shop: " + requestedShop.getName());

        String leftAlignFormat = "| %-8s | %-8s | %-9.2f|%n";

        System.out.format("+----------+----------+----------+%n");
        System.out.format("| Product  | Quantity | Cost     |%n");
        System.out.format("+----------+----------+----------+%n");

        // total cost
        double totalCost = 0;

        for (Integer[][] idQuantity : idsQuantities) {

            // get product
            Product product = requestedShop.getProducts().get(idQuantity[0][0]-1);

            // get product name from id
            String productName = product.getName();

            // get product quantity
            int quantity = idQuantity[0][1];

            // get product price
            double price = product.getPrice();

            // calculate cost
            double cost = price * quantity;

            // add to total cost
            totalCost += cost;

            // print it
            System.out.format(leftAlignFormat, productName, "x" + quantity, cost);
        }

        // format for total cost
        String alignFormat = "| %-8s  %-8s  %-9.2f|%n";

        System.out.format("+----------+----------+----------+%n");
        System.out.format(alignFormat, "Total Cost", "", totalCost);
        System.out.format("+--------------------------------+%n");
        System.out.println();

        while (true) {
            // create a scanner object
            Scanner scanner = new Scanner(System.in);

            // submit order
            System.out.print("Submit order for " + totalCost + " $ [Y/N]:");
            String answer = scanner.nextLine();

            if (answer.toUpperCase().equals("Y")) {

                // get datetime
                DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                Date date = new Date();
                String datetime = dateFormat.format(date);

                // add order
                Order order = new Order(this, requestedShop, idsQuantities, datetime);

                // print order receipt
                System.out.println("\n===== Receipt =====");
                System.out.println(order.toString());

                // press enter key to continue
                System.out.print("Press enter to return to the menu.");
                String enterKey = scanner.nextLine();
                while (enterKey != null) {
                    if (enterKey.isEmpty()) {
                        break;
                    }
                    else {
                        break;
                    }
                }

                // exit loop
                return;
            }
            else if (answer.toUpperCase().equals("N")){
                // return to menu
                // exit loop
                return;
            }
        }
    }

    private ArrayList<Integer[][]> makeOrder(Shop requestedShop) {

        // store products & quantities
        ArrayList<Integer[][]> idsQuantities = new ArrayList<>();

        // read products & quantities
        while (true) {
            System.out.println();
            System.out.print("Product id: ");

            // create a scanner object
            Scanner scanner = new Scanner(System.in);

            // read product id
            String productId = scanner.nextLine();

            // when input is enter key, exit
            while (productId != null) {

                // read enter key
                if (productId.isEmpty()) {
                    return idsQuantities;
                }
                else {
                    // given product id
                    try {
                        // try parse to Integer
                        int productIndex = Integer.parseInt(productId);

                        // valid product id
                        if (requestedShop.getProducts().size() >= productIndex) {

                            // loop until user give valid quantity
                            while (true) {
                                // read quantity
                                System.out.print("Quantity: ");
                                int quantity = scanner.nextInt();

                                // valid quantity
                                if (quantity >=1 && quantity <=20) {

                                    // create array to store the product-quantity
                                    Integer[][] idQuantity = {{productIndex, quantity}};

                                    // add it to the list
                                    idsQuantities.add(idQuantity);

                                    // exit loop
                                    break;
                                }
                                else {
                                    // wrong quantity input
                                    System.out.println("Please enter quantity value [1-20]\n");
                                }
                            }
                        }
                        else {
                            // product id does not exist
                            System.out.println("Product with id [" + productIndex + "] does not exist!\n");
                        }
                    }
                    catch (Exception e) {
                        System.out.println("Wrong input! Try again.\n");
                    }
                    break;
                }
            }
        }
    }
}
