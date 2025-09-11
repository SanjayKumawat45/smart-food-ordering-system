import models.Customer;
import ui.AuthUi;
import ui.Menu;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        System.out.println("Welcome to Smart Online Food Ordering System");

        Customer customer = AuthUi.login();
        if (customer == null){
            customer = AuthUi.register();
        }

        Menu menu = new Menu();
        menu.start(customer);
    }
}