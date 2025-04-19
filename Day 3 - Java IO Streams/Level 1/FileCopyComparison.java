import java.io.*;

public class FileCopyComparison {
    private static final int BUFFER_SIZE = 4096; // 4 KB buffer

    public static void main(String[] args) {
        String sourceFile = "largefile.dat";              // Use a real large file
        String bufferedCopy = "copy_buffered.dat";
        String unbufferedCopy = "copy_unbuffered.dat";

        // Buffered Stream Copy
        long startBuffered = System.nanoTime();
        copyFileBuffered(sourceFile, bufferedCopy);
        long endBuffered = System.nanoTime();
        System.out.println("Buffered copy time: " + (endBuffered - startBuffered) / 1_000_000 + " ms");

        // Unbuffered Stream Copy
        long startUnbuffered = System.nanoTime();
        copyFileUnbuffered(sourceFile, unbufferedCopy);
        long endUnbuffered = System.nanoTime();
        System.out.println("Unbuffered copy time: " + (endUnbuffered - startUnbuffered) / 1_000_000 + " ms");
    }

    public static void copyFileBuffered(String sourcePath, String destPath) {
        try (
            BufferedInputStream bis = new BufferedInputStream(new FileInputStream(sourcePath));
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destPath))
        ) {
            byte[] buffer = new byte[BUFFER_SIZE];
            int bytesRead;
            while ((bytesRead = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, bytesRead);
            }
        } catch (IOException e) {
            System.out.println("Buffered copy failed: " + e.getMessage());
        }
    }

    public static void copyFileUnbuffered(String sourcePath, String destPath) {
        try (
            FileInputStream fis = new FileInputStream(sourcePath);
            FileOutputStream fos = new FileOutputStream(destPath)
        ) {
            byte[] buffer = new byte[BUFFER_SIZE];
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }
        } catch (IOException e) {
            System.out.println("Unbuffered copy failed: " + e.getMessage());
        }
    }
}
