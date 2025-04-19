import java.io.*;

public class ReadFirstLine {
    public static void main(String[] args) {
        String filePath = "info.txt"; // File name (info.txt)

        // Use try-with-resources to automatically close the BufferedReader
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String firstLine = reader.readLine(); // Read the first line
            if (firstLine != null) {
                System.out.println("First line: " + firstLine);
            } else {
                System.out.println("File is empty.");
            }
        } catch (IOException e) {
            // Handle IOException if the file does not exist or any read error
            System.out.println("Error reading file");
        }
    }
}
