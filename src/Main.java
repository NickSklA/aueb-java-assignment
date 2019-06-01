import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // load all objects
        // to start the program
//        loadObjects();

        RegisteredCustomer customer1 = new RegisteredCustomer("nik1@gmail.com", "123", "nik", "6942277574", "leva");
        System.out.println(customer1.getId());

        RegisteredCustomer customer2 = new RegisteredCustomer("nids2@gmail.com", "121243", "nisdfk", "694227sdf7574", "leva");
        System.out.println(customer2.getId());

        RegisteredCustomer customer3 = new RegisteredCustomer("nids3@gmail.com", "121243", "nisdfk", "694227sdf7574", "leva");
        System.out.println(customer3.getId());


        // print connection menu
//        printMenu();
    }

    private static void printMenu() {

        // create a scanner object
        Scanner scanner = new Scanner(System.in);

        // print menu options
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

    private static void printVisitorMenu() {

    }

    private static void printLoginDialog() {

    }

    private static void printSignUpDialog() {

    }

    static void loadObjects() {
        Product product = new Product(1, "Fish", 2.3);
        Product product2 = new Product(2, "Fish2", 2.3);
        Product product3 = new Product(3, "Fish3", 2.3);

        ArrayList<Product> products = new ArrayList<>();
        products.add(product);
        products.add(product2);
        products.add(product3);

        Shop shop = new Shop(1, "Name", "Address", products);
        Shop shop2 = new Shop(2, "Name2", "Address2", products);


        Shop.printAllShops();

        Customer customer = new RegisteredCustomer("@gmail.com", "1234", "name", "6942277574", "glyfada");
        Customer customer2 = new RegisteredCustomer("@gmail.com", "1234", "name", "6942277574", "glyfada");


        System.out.println();

    }
}
