package exceptions;

public class PaymentFaildException extends RuntimeException {
    public PaymentFaildException(String message) {
        super(message);
    }
}
