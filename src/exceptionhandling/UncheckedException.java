package exceptionhandling;
import java.util.Scanner;


class NegativeNumberException extends RuntimeException {
    public NegativeNumberException(String message) {
        super(message);
    }
}

public class UncheckedException {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.println("Enter an integer: ");
            int num = sc.nextInt();


            if (num < 0) {
                throw new NegativeNumberException("Negative numbers are not allowed!");
            }

            System.out.println("You entered: " + num);
        }

        catch (NegativeNumberException e) {
            System.out.println("Error: " + e.getMessage());
        }

        catch (Exception e) {
            System.out.println("Invalid input! Please enter an integer.");
        }
    }
}
