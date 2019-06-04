import java.util.Scanner;

public class VisitorCustomer extends Customer {

    public VisitorCustomer() {
    }

    @Override
    public void getMenu() {

        // create a scanner object
        Scanner scanner = new Scanner(System.in);

        // welcome message
        System.out.println("\nWelcome visitor");

        while (true) {

            // print the menu
            System.out.println("===== Visitor Menu =====");
            System.out.println("1. Available shops");

            String option = "";
            while (true) {
                // read user input
                System.out.print("Select an option [1]: ");
                option = scanner.nextLine();

                // if user gives valid input continue
                if (option.equals("1"))
                    break;
            }

            switch (option) {
                case "1":
                    showAvailableShops();
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
}
