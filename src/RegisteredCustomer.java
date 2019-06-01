
public class RegisteredCustomer extends Customer {

    private int id;
    private String email;
    private String pass;

    public RegisteredCustomer(int id, String email, String pass, String name, String phoneNumber, String address) {
        super(name, phoneNumber, address);
        this.id = id;
        this.email = email;
        this.pass = pass;
    }

    @Override
    public void getMenu() {
        System.out.println("----- Menu -----");
    }
}
