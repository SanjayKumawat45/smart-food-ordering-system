package models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {
    private int orderId;
    private Customer customer;
    private List<FoodItem> foodItems;
    private double totalAmount;
    private String status;
    private Date orderDate;

    public Order(int orderId, Customer customer){
        this.orderId = orderId;
        this.customer = customer;
        this.foodItems = new ArrayList<>();
        this.totalAmount = 0.0;
        this.status = "Pending";
        this.orderDate = new Date();
    }

    public void addFoodItem(FoodItem foodItem){
        foodItems.add(foodItem);
        totalAmount += foodItem.getPrice();
    }

    public void removedFoodItem(FoodItem foodItem){
        if (foodItems.remove(foodItem)){
            totalAmount -= foodItem.getPrice();
        }
    }

    public void confirmOrder(){
        this.status = "Confirmed!";
    }

    public void markAsDelivered(){
        this.status = "Delivered.";
    }

    public int getOrderId() {
        return orderId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public List<FoodItem> getFoodItems() {
        return foodItems;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public String getStatus() {
        return status;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    @Override
    public String toString(){
        return "Order{" +
                "orderId=" + orderId +
                ", customer=" +customer.getName() +
                ", totalAmount=" + totalAmount +
                ", status+'" + status + '\'' +
                ", orderDate=" + orderDate +
                '}';
    }
}
