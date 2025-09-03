package exceptionhandling;
import java.util.Scanner;
public class Finally {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        try{
            System.out.println("Enter first number");
            int num1=sc.nextInt();

            System.out.println("Enter the second number");
            int num2=sc.nextInt();

            int res=(num1/num2);
            System.out.println("Result is"+res);

        }
        catch (ArithmeticException e){
            System.out.println("Error"+e);
        }
        finally{
            System.out.println("Program ended");
        }
    }
}
