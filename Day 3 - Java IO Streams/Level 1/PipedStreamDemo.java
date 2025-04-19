import java.io.*;

public class PipedStreamDemo {

    public static void main(String[] args) {
        try {
            // Create piped streams
            PipedOutputStream pos = new PipedOutputStream();
            PipedInputStream pis = new PipedInputStream(pos); // Connect input to output

            // Writer Thread
            Thread writerThread = new Thread(() -> {
                try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(pos))) {
                    String[] messages = {
                        "Hello from writer thread!",
                        "This is a test of piped streams.",
                        "Each message will be read by another thread.",
                        "Goodbye!"
                    };

                    for (String msg : messages) {
                        writer.write(msg);
                        writer.newLine();
                        writer.flush();
                        System.out.println("[Writer] Sent: " + msg);
                        Thread.sleep(500); // Simulate delay
                    }
                } catch (IOException | InterruptedException e) {
                    System.out.println("Writer error: " + e.getMessage());
                }
            });

            // Reader Thread
            Thread readerThread = new Thread(() -> {
                try (BufferedReader reader = new BufferedReader(new InputStreamReader(pis))) {
                    String line;
                    while ((line = reader.readLine()) != null) {
                        System.out.println("[Reader] Received: " + line);
                    }
                } catch (IOException e) {
                    System.out.println("Reader error: " + e.getMessage());
                }
            });

            // Start both threads
            readerThread.start();
            writerThread.start();

            // Wait for threads to finish
            writerThread.join();
            readerThread.join();

        } catch (IOException | InterruptedException e) {
            System.out.println("Main error: " + e.getMessage());
        }
    }
}
