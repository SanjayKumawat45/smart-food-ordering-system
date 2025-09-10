package services.impl;

import enums.PaymentStatus;
import exceptions.PaymentFaildException;
import models.Order;
import models.Payment;
import services.PaymentService;

import java.util.ArrayList;
import java.util.List;

public class PaymentServiceImpl implements PaymentService {

    private List<Payment> payments;

    public PaymentServiceImpl(){
        this.payments = new ArrayList<>();
    }

    @Override
    public Payment processPayment(Order order, String method) throws PaymentFaildException {
        if (order == null || order.getFoodItems().isEmpty()){
            throw new PaymentFaildException("Cannot process payment for empty order.");
        }

        int paymentId = payments.size()+1;
        Payment payment = new Payment(paymentId, order, method);
        payment.processPayment();
        payments.add(payment);
        return payment;
    }

    @Override
    public PaymentStatus getPaymentStatus(int paymentId) {
        for (Payment payment : payments){
            if (payment.getPaymentId() == paymentId){
                return payment.isPaymentStatus() ? PaymentStatus.SUCCESS : PaymentStatus.FAILED;
            }
        }
        return PaymentStatus.PENDING;

    }
}
