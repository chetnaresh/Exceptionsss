package exceptionhandling;

public class ExceptionHierarchy {
    public static void main(String[] args) {
        try {

            int num1 = 10, num2 = 0;
            int result = num1 / num2;

        }
        catch (ArithmeticException e) {
            System.out.println("Caught ArithmeticException: Division by zero is not allowed.");
        }
        catch (NullPointerException e) {
            System.out.println("Caught NullPointerException: Null object accessed.");
        }
        catch (Exception e) {
            System.out.println("Caught Exception: " + e);
        }

        System.out.println("Program continues after exception handling...");
    }
}
