import java.util.Scanner;

public class DivisionWithFinally {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Take two integers from the user
            System.out.print("Enter the numerator: ");
            int numerator = scanner.nextInt();
            System.out.print("Enter the denominator: ");
            int denominator = scanner.nextInt();

            // Perform division
            int result = numerator / denominator;
            System.out.println("Result: " + result);

        } catch (ArithmeticException e) {
            // Handle ArithmeticException if dividing by zero
            System.out.println("Error: Division by zero is not allowed.");
        } finally {
            // This block will always execute
            System.out.println("Operation completed");
            scanner.close();
        }
    }
}
