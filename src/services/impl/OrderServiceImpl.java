package services.impl;

import exceptions.InvalidOrderException;
import models.Customer;
import models.FoodItem;
import models.Order;
import services.OrderService;

import java.util.ArrayList;
import java.util.List;

public class OrderServiceImpl implements OrderService  {

    private List<Order> orders;

    public OrderServiceImpl(){
        this.orders = new ArrayList<>();
    }


    @Override
    public Order placeOrder(Customer customer, List<FoodItem> foodItems) throws InvalidOrderException {
        if (customer == null || foodItems == null || foodItems.isEmpty()){
            throw new InvalidOrderException("Invalid order: Customer or food items cannot be empty.");
        }

        int orderId = orders.size() + 1;
        Order order = new Order(orderId, customer);

        for (FoodItem item : foodItems){
            order.addFoodItem(item);
        }

        orders.add(order);
        System.out.println("✅ Order placed successfully! Order ID: " + orderId);
        return order;
    }

    @Override
    public List<Order> getOrdersByCustomer(Customer customer) {
        List<Order> customerOrders = new ArrayList<>();
        for(Order order : orders){
            if (order.getCustomer().equals(customer)){
                customerOrders.add(order);
            }
        }
        return customerOrders;
    }

    @Override
    public boolean cancelOrder(int orderId, Customer customer) throws InvalidOrderException {
        for (Order order: orders){
            if (order.getOrderId() == orderId && order.getCustomer().equals(customer)){
                System.out.println("❌ Order ID " + orderId + " has been cancelled.");
                return true;
            }
        }
        throw new InvalidOrderException("Order not found or not authorized to cancel.");
    }

    @Override
    public Order getOrderById(int orderId){
        for (Order order : orders){
            if(order.getOrderId() == orderId){
                return order;
            }
        }
        return null;
    }
}
