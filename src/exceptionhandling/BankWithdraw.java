package exceptionhandling;
import java.util.Scanner;
class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String message) {
        super(message);
    }
}

public class BankWithdraw {


    public static void withdraw(int balance, int amount) throws InsufficientFundsException {
        if (amount > balance) {
            throw new InsufficientFundsException("Error: Insufficient balance! You tried to withdraw " + amount + " but only " + balance + " is available.");
        } else {
            balance -= amount;
            System.out.println("Withdrawal successful! Remaining balance: " + balance);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int balance = 5000;

        System.out.println("Enter amount to withdraw: ");
        int withdrawAmount = sc.nextInt();

        try {
            withdraw(balance, withdrawAmount);
        }
        catch (InsufficientFundsException e) {
            System.out.println("Caught Exception: " + e.getMessage());
        }

        System.out.println("Transaction complete.");
    }
}
