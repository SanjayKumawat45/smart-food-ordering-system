package models;

import java.beans.ConstructorProperties;
import java.text.DecimalFormat;

public class Payment {
    private int paymentId;
    private Order order;
    private double amount;
    private String paymentMethod;
    private boolean paymentStatus;

    public Payment(int paymentId, Order order, String paymentMethod){
        this.paymentId = paymentId;
        this.order = order;
        this.amount = order.getTotalAmount();
        this.paymentMethod = paymentMethod;
        this.paymentStatus = false;
    }

    public int getPaymentId() {
        return paymentId;
    }

    public Order getOrder() {
        return order;
    }

    public double getAmount() {
        return amount;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public boolean isPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public void setPaymentStatus(boolean paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public void processPayment(){

        System.out.println("Processing payment of ₹" + formatAmount(amount) + " via " +paymentMethod);
        this.paymentStatus = true;
        System.out.println("Payment Successful!");
    }

    private String formatAmount(double amount){
        DecimalFormat df = new DecimalFormat();
        return df.format(amount);
    }

    @Override
    public String toString(){
        return "Payment{" +
                "paymentId=" + paymentId +
                ", amount=₹" + formatAmount(amount) +
                ", method='" + paymentMethod + '\'' +
                ", status=" + (paymentStatus ? "Success" : "Pending") +
                '}';
    }

}
