import java.io.*;
import java.nio.file.Files;
import java.util.Arrays;

public class ImageByteArrayConverter {
    public static void main(String[] args) {
        String inputImagePath = "original.jpg";       // Replace with your image file path
        String outputImagePath = "copy.jpg";          // Output image file

        try {
            // Step 1: Read image into a byte array
            byte[] originalBytes = imageToByteArray(inputImagePath);

            // Step 2: Convert byte array back to image file
            byteArrayToImage(originalBytes, outputImagePath);

            // Step 3: Verify that both files are identical
            byte[] newBytes = Files.readAllBytes(new File(outputImagePath).toPath());

            if (Arrays.equals(originalBytes, newBytes)) {
                System.out.println("Success: The copied image is identical to the original.");
            } else {
                System.out.println("Failure: The copied image is not identical to the original.");
            }

        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }

    // Converts an image file to a byte array using ByteArrayOutputStream
    private static byte[] imageToByteArray(String imagePath) throws IOException {
        try (FileInputStream fis = new FileInputStream(imagePath);
             ByteArrayOutputStream baos = new ByteArrayOutputStream()) {

            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                baos.write(buffer, 0, bytesRead);
            }
            return baos.toByteArray();
        }
    }

    // Writes a byte array back to an image file using ByteArrayInputStream
    private static void byteArrayToImage(byte[] data, String outputPath) throws IOException {
        try (ByteArrayInputStream bais = new ByteArrayInputStream(data);
             FileOutputStream fos = new FileOutputStream(outputPath)) {

            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = bais.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }
        }
    }
}
