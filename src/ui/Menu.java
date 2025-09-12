package ui;

import database.DataStore;
import models.Customer;
import models.FoodItem;
import models.Order;
import models.Payment;
import services.OrderService;
import services.PaymentService;
import services.impl.OrderServiceImpl;
import services.impl.PaymentServiceImpl;
import utils.ExceptionHandler;
import utils.InputHelper;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private final OrderService orderService = new OrderServiceImpl();
    private final PaymentService paymentService = new PaymentServiceImpl();

    public void start(Customer customer){
        while(true){
            System.out.println("\n===== MENU =====");
            System.out.println("1. View Food Menu");
            System.out.println("2. Place Order");
            System.out.println("3. View My Orders");
            System.out.println("4. Exit");

            int choice = InputHelper.getInt("Choose an option");

            switch (choice){
                case 1 -> displayFoodMenu();
                case 2 -> placeOrder(customer);
                case 3 -> viewOrders(customer);
                case 4 ->{
                    System.out.println("👋 Goodbye " + customer.getName());
                    return;
                }
                default -> System.out.println("❌ Invalid choice. Try again.");
            }
        }
    }

    private void displayFoodMenu(){
        System.out.println("\n🍽 Food Menu:");
        for (FoodItem item : DataStore.menu){
            System.out.println(item);
        }
    }

    private void placeOrder(Customer customer){
        List<FoodItem> items = new ArrayList<>();
        while (true){
            displayFoodMenu();
            int foodId = InputHelper.getInt("Enter food ID to add order (0 to finish)");
            if (foodId == 0) break;

            for (FoodItem item : DataStore.menu){
                if (item.getId() == foodId){
                    items.add(item);
                    System.out.println(item.getName() + " added to order.");
                }
            }
        }

        try {
            if (items.isEmpty()){
                System.out.println("❌ No items selected.");
                return;
            }

            Order order = orderService.placeOrder(customer, items);
            System.out.println("Total: "+ order.getTotalAmount());



            InputHelper.getString("");

            String method;
            while (true) {
                method = InputHelper.getString("Enter payment method (UPI/Card/Cash)").trim();

                if (method.equalsIgnoreCase("UPI") ||
                        method.equalsIgnoreCase("Card") ||
                        method.equalsIgnoreCase("Cash")) {
                    break;
                } else {
                    System.out.println("❌ Invalid payment method. Please enter UPI, Card, or Cash.");
                }
            }

            Payment payment = paymentService.processPayment(order, method);


            System.out.println("✅ Payment Status: " + payment);
        } catch (Exception e){
            ExceptionHandler.handle(e);
        }
    }

    private void viewOrders(Customer customer){
        List<Order> orders = orderService.getOrdersByCustomer(customer);
        if (orders.isEmpty()){
            System.out.println("❌ You have no orders yet.");
            return;
        }
        for (Order order : orders){
            System.out.println(order);
        }
    }


}
