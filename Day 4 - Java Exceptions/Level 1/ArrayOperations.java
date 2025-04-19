import java.util.Scanner;

public class ArrayOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Sample array for demonstration purposes (You can modify as needed)
        int[] array = {10, 20, 30, 40, 50}; 
        
        try {
            System.out.print("Enter the index to retrieve the value: ");
            int index = scanner.nextInt();

            if (array == null) {
                throw new NullPointerException();
            }

            System.out.println("Value at index " + index + ": " + array[index]);

        } catch (ArrayIndexOutOfBoundsException e) {
            // Handle case where the index is out of bounds
            System.out.println("Invalid index!");
        } catch (NullPointerException e) {
            System.out.println("Array is not initialized!");
        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
