package database;

import enums.FoodCategory;
import models.Customer;
import models.FoodItem;

import java.util.ArrayList;
import java.util.List;

public class DataStore {
    public static final List<Customer> customer = new ArrayList<>();
    public static final List<FoodItem> menu = new ArrayList<>();

    static {
        menu.add(new FoodItem(1, "Burger", 120, FoodCategory.STARTER));
        menu.add(new FoodItem(2, "Pizza", 250, FoodCategory.MAIN_COURSE));
        menu.add(new FoodItem(3, "Pasta", 180, FoodCategory.STARTER));
        menu.add(new FoodItem(4, "Coffee", 90, FoodCategory.DESSERT));
        customer.add(new Customer(1, "test", "test", "test", "Shyam Kripa", "1234567890"));
    }
}
