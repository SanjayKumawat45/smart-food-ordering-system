package services;

import enums.PaymentStatus;
import exceptions.PaymentFaildException;
import models.Order;
import models.Payment;

public interface PaymentService {
    Payment processPayment(Order order, String method) throws PaymentFaildException;
    PaymentStatus getPaymentStatus(int paymentId);
}
