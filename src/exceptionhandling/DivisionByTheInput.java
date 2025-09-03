package exceptionhandling;
import java.util.Scanner;
public class DivisionByTheInput {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int user=sc.nextInt();

        try{
            int res=100/user;
            System.out.println("The result is "+res);
        }
        catch (ArithmeticException e){
            System.out.println("Division by zero"+e.getMessage());
        }
    }
}

