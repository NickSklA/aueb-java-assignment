import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // load all objects
        // to start the program
//        loadObjects();

//        RegisteredCustomer customer1 = new RegisteredCustomer("nik1@gmail.com", "123", "nik", "skl", "6942277574", "leva");
//        System.out.println(customer1.getId());
//
//        RegisteredCustomer customer2 = new RegisteredCustomer("nids2@gmail.com", "121243", "nisdfk", "skl","694227sdf7574", "leva");
//        System.out.println(customer2.getId());
//
//        RegisteredCustomer customer3 = new RegisteredCustomer("nids3@gmail.com", "121243", "nisdfk", "skl","694227sdf7574", "leva");
//        System.out.println(customer3.getId());

        Shop shop1 = new Shop("Name1", "Levade 38", "6942277574", new ArrayList<Product>());
        Shop shop2 = new Shop("Name2", "Kakou 4", "2323556345", new ArrayList<Product>());
        Shop shop3 = new Shop("Name3", "Petroup 29", "234677867", new ArrayList<Product>());

//        Shop.filterAndPrintShops("nam");


        // print connection menu
        printMenu();
    }

    private static void printMenu() {

        // create a scanner object
        Scanner scanner = new Scanner(System.in);

        while (true) {

            // print menu options
            System.out.print("===== Connection Menu ===== \n");
            System.out.print("1. New here? Sign up \n");
            System.out.print("2. Have an account? Log in \n");
            System.out.print("3. Continue as a visitor \n\n");

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
                    printSignUpDialog();
                    break;
                case "2":
                    printLoginDialog();
                    break;
                case "3":
                    printVisitorMenu();
            }
        }

    }

    private static void printVisitorMenu() {
        VisitorCustomer customer = new VisitorCustomer();
        customer.getMenu();
    }

    private static void printLoginDialog() {

        // create a scanner object
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("\n===== Login ===== \n");
            System.out.print("Email: ");
            String email = scanner.nextLine();
            System.out.print("Password: ");
            String password = scanner.nextLine();

            RegisteredCustomer customer = RegisteredCustomer.login(email, password);

            if (customer == null) {
                System.out.println("Login failed wrong user credentials!");
                System.out.print("Press any key to try again, or press enter key to return to menu.");
                String option = scanner.nextLine();
                while (option != null) {

                    if (option.isEmpty()) {
                        System.out.println();
                        return;
                    }
                    else {
                        System.out.println();
                        break;
                    }
                }
            }
            else {
                System.out.print("You logged in successfully! Press enter to continue.\n");
                String enter = scanner.nextLine();

                // call registered menu
                customer.getMenu();

                return;
            }
        }
    }

    private static void printSignUpDialog() {

        // create a scanner object
        Scanner scanner = new Scanner(System.in);

        System.out.print("\n===== Sign Up ===== \n");
        System.out.print("First Name: ");
        String firstName = scanner.nextLine();
        System.out.print("Last Name: ");
        String lastName = scanner.nextLine();
        System.out.print("Phone No.: ");
        String phoneNumber = scanner.nextLine();
        System.out.print("Address: ");
        String address = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();

        // create new customer
        RegisteredCustomer customer =
                new RegisteredCustomer(email, password, firstName, lastName, phoneNumber, address);

        // if customer created successfully
        if (customer.getId() != -1) {
            System.out.println("You have successfully signed up! Press enter to continue.");
            String enter = scanner.nextLine();
        }
    }

    static void loadObjects() {
        Product product = new Product(1, "Fish", 2.3);
        Product product2 = new Product(2, "Fish2", 2.3);
        Product product3 = new Product(3, "Fish3", 2.3);

        ArrayList<Product> products = new ArrayList<>();
        products.add(product);
        products.add(product2);
        products.add(product3);
//
//        Shop shop = new Shop(1, "Name", "Address", products);
//        Shop shop2 = new Shop(2, "Name2", "Address2", products);


        Shop.printAllShops();
//
//        Customer customer = new RegisteredCustomer("@gmail.com", "1234", "name", "6942277574", "glyfada");
//        Customer customer2 = new RegisteredCustomer("@gmail.com", "1234", "name", "6942277574", "glyfada");


        System.out.println();

    }
}
