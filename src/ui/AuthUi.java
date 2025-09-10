package ui;


import database.DataStore;
import models.Customer;
import utils.InputHelper;

public class AuthUi {
    public static Customer login(){
        String email = InputHelper.getString("Enter email");
        String password = InputHelper.getString("Enter password");

        for (Customer c : DataStore.customer){
            if (c.getEmail().equals(email) && c.getPassword().equals(password)) {
                System.out.println("✅ Login successful. Welcome, " + c.getName());
                return c;
            }
        }
        System.out.println("❌ Login failed. Please register first.");
        return null;
    }

    public static Customer register(){
        int id = DataStore.customer.size() + 1;
        String name = InputHelper.getString("Enter name");
        String email = InputHelper.getString("Enter email");
        String password = InputHelper.getString("Enter password");
        String address = InputHelper.getString("Enter address");
        String phoneNumber = InputHelper.getString("Enter mobile number");

        Customer customer = new Customer(id, name, email, password, address);
        DataStore.customer.add(customer);

        System.out.println("✅ Registration successful. Welcome, " + name);
        return customer;
    }
}


