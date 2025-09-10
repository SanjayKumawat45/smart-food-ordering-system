package utils;

public class FormatterUtil {
    public static String formatCurrency(double amount){
        return "₹" + String.format("%.2f", amount);
    }
}
