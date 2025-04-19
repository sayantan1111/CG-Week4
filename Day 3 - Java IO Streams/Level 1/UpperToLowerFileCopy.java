import java.io.*;

public class UpperToLowerFileCopy {
    public static void main(String[] args) {
        String sourceFile = "input.txt";           // Source file path
        String destinationFile = "output.txt";     // Destination file path
        String encoding = "UTF-8";                 // Specify encoding (e.g., UTF-8)

        try (
            BufferedReader reader = new BufferedReader(
                new InputStreamReader(new FileInputStream(sourceFile), encoding)
            );
            BufferedWriter writer = new BufferedWriter(
                new OutputStreamWriter(new FileOutputStream(destinationFile), encoding)
            )
        ) {
            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line.toLowerCase());
                writer.newLine(); // preserve line breaks
            }

            System.out.println("File copied with all uppercase letters converted to lowercase.");

        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}
