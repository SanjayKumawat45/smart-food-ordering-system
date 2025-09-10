package services;

import exceptions.InvalidOrderException;
import models.Customer;
import models.FoodItem;
import models.Order;

import java.util.List;

public interface OrderService {

    Order placeOrder(Customer customer, List<FoodItem> foodItems) throws InvalidOrderException;

    List<Order> getOrdersByCustomer(Customer customer);

    boolean cancelOrder(int corderId, Customer customer) throws InvalidOrderException;

    Order getOrderById(int orderId);

}
