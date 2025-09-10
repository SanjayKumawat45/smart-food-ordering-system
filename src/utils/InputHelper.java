package utils;

import java.util.Scanner;

public class InputHelper {
    private static final Scanner scanner  = new Scanner(System.in);

    public static String getString(String message){
        System.out.println(message + ": ");
        return scanner.nextLine();
    }

    public static int getInt(String message){
        System.out.println(message + ": ");
        while (!scanner.hasNextInt()){
            System.out.println("Please enter a valid number.");
            scanner.next();
        }
        return scanner.nextInt();
    }

    public static double getDouble(String message){
        System.out.println(message + ": ");
        while (!scanner.hasNextDouble()){
            scanner.next();
        }
        return scanner.nextDouble();
    }

}
