import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // load fake data
        loadObjects();

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

        // add some customers for testing
        RegisteredCustomer customer1 = new RegisteredCustomer("maria.hudson@example.com", "Hudson95@!", "Maria", "Hudson", "(308) 911 9115", "United States");
        RegisteredCustomer customer2 = new RegisteredCustomer("sara_hicks@example.com", "Hicks95^*", "Sara", "Hicks","(753) 777 4899", "Greece");
        RegisteredCustomer customer3 = new RegisteredCustomer("jerry89@example.com", "Andrews89{{", "Jerry", "Andrews","(409) 538 6916", "France");

        // add some products
        Product product = new Product("Bread", 1);
        Product product2 = new Product("Pizza", 5);
        Product product3 = new Product("Fries", 3);
        Product product4 = new Product("Water", 0.5);
        Product product5 = new Product("Nuggets", 6);
        Product product6 = new Product("Burger", 7.5);

        // product list
        ArrayList<Product> products = new ArrayList<>();
        products.add(product);
        products.add(product2);
        products.add(product3);
        products.add(product4);

        // product list
        ArrayList<Product> products2 = new ArrayList<>();
        products2.add(product);
        products2.add(product5);
        products2.add(product6);
        products2.add(product4);

        // product list
        ArrayList<Product> products3 = new ArrayList<>();
        products3.add(product);
        products3.add(product3);
        products3.add(product5);
        products3.add(product4);

        // add some food shops
        Shop shop1 = new Shop("NFood", "Athens", "(308) 911 9115", products);
        Shop shop2 = new Shop("Meal.ly", "Piraeus", "(753) 777 4899", products2);
        Shop shop3 = new Shop("Tastia", "Loutraki", "(409) 538 6916", products3);
    }
}
