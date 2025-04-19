import java.util.Scanner;

class InvalidAgeException extends Exception {
    public InvalidAgeException(String message) {
        super(message);
    }
}

public class InvalidAgeExceptionDemo {
    
    public static void validateAge(int age) throws InvalidAgeException {
        if (age < 18) {
            throw new InvalidAgeException("Age must be 18 or above");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter your age: ");
            int age = scanner.nextInt();

            validateAge(age);
            System.out.println("Access granted!");

        } catch (InvalidAgeException e) {
            // Handle InvalidAgeException
            System.out.println(e.getMessage());
        } catch (Exception e) {
            // Handle any other unexpected exceptions
            System.out.println("Invalid input. Please enter a valid age.");
        } finally {
            // Close the scanner
            scanner.close();
        }
    }
}
