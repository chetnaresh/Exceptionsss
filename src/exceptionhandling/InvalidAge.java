package exceptionhandling;

import java.util.Scanner;


class InvalidAgeException extends Exception {
    public InvalidAgeException(String message) {
        super(message);
    }
}

public class InvalidAge {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println("Enter the age: ");
            int age = sc.nextInt();


            if (age < 18) {
                throw new InvalidAgeException("Age must be 18 or above to proceed!");
            }


            System.out.println("Valid age. You are eligible.");
        }
        catch (InvalidAgeException e) {

            System.out.println("Exception Caught: " + e.getMessage());
        }
        catch (Exception e) {

            System.out.println("Error: " + e);
        }
    }
}
