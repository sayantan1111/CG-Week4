import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.File;
import java.io.IOException;

public class FileCopy {
    public static void main(String[] args) {
        String sourcePath = "source.txt";      
        String destinationPath = "destination.txt"; 

        FileInputStream inputStream = null;
        FileOutputStream outputStream = null;

        try {
            File sourceFile = new File(sourcePath);
            if (!sourceFile.exists()) {
                System.out.println("Source file does not exist: " + sourcePath);
                return;
            }

            File destinationFile = new File(destinationPath);
            // Create the destination file if it doesn't exist
            if (!destinationFile.exists()) {
                destinationFile.createNewFile();
            }

            inputStream = new FileInputStream(sourceFile);
            outputStream = new FileOutputStream(destinationFile);

            byte[] buffer = new byte[1024];
            int length;
            while ((length = inputStream.read(buffer)) > 0) {
                outputStream.write(buffer, 0, length);
            }

            System.out.println("File copied successfully.");

        } catch (IOException e) {
            System.out.println("An I/O error occurred: " + e.getMessage());
        } finally {
            try {
                if (inputStream != null)
                    inputStream.close();
                if (outputStream != null)
                    outputStream.close();
            } catch (IOException e) {
                System.out.println("Failed to close streams: " + e.getMessage());
            }
        }
    }
}
