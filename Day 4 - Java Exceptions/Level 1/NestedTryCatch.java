import java.util.Scanner;

public class NestedTryCatch {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Sample array
        int[] array = {10, 20, 30, 40, 50}; 

        try {
            // Take index input from the user
            System.out.print("Enter the index: ");
            int index = scanner.nextInt();

            try {
                // Access the element at the specified index
                int element = array[index];

                // Take divisor input from the user
                System.out.print("Enter the divisor: ");
                int divisor = scanner.nextInt();

                try {
                    // Perform the division
                    int result = element / divisor;
                    System.out.println("Division result: " + result);

                } catch (ArithmeticException e) {
                    // Handle division by zero
                    System.out.println("Cannot divide by zero!");
                }

            } catch (ArrayIndexOutOfBoundsException e) {
                // Handle invalid index
                System.out.println("Invalid array index!");
            }

        } catch (Exception e) {
            // Catch any other unexpected exceptions
            System.out.println("Invalid input. Please enter valid integers.");
        } finally {
            // Close the scanner
            scanner.close();
        }
    }
}
