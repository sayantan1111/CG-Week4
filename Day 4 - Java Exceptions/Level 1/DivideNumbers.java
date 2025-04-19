import java.util.Scanner;
import java.util.InputMismatchException;

public class DivideNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter the numerator: ");
            double numerator = scanner.nextDouble();

            System.out.print("Enter the denominator: ");
            double denominator = scanner.nextDouble();

            double result = numerator / denominator;

            System.out.println("Result: " + result);

        } catch (InputMismatchException e) {
            System.out.println("Error: Please enter valid numeric values.");
        } catch (ArithmeticException e) {
            // Handle case where denominator is zero
            System.out.println("Error: Division by zero is not allowed.");
        } finally {
            // Close the scanner
            scanner.close();
        }
    }
}
