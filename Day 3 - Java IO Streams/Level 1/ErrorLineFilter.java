import java.io.*;

public class ErrorLineFilter {
    public static void main(String[] args) {
        String filePath = "largefile.txt"; // Replace with your actual file path

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            int lineNumber = 1;
            while ((line = reader.readLine()) != null) {
                if (line.toLowerCase().contains("error")) {
                    System.out.printf("Line %d: %s%n", lineNumber, line);
                }
                lineNumber++;
            }
        } catch (IOException e) {
            System.out.println("Failed to read file: " + e.getMessage());
        }
    }
}
