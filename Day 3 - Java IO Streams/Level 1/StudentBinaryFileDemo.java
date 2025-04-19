import java.io.*;
import java.util.Scanner;

public class StudentBinaryFileDemo {

    private static final String FILE_NAME = "students.dat";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Writing student data to binary file
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(FILE_NAME))) {
            System.out.print("Enter number of students: ");
            int count = Integer.parseInt(scanner.nextLine());

            for (int i = 0; i < count; i++) {
                System.out.println("\nEnter details for student #" + (i + 1));
                System.out.print("Roll number: ");
                int roll = Integer.parseInt(scanner.nextLine());
                System.out.print("Name: ");
                String name = scanner.nextLine();
                System.out.print("GPA: ");
                float gpa = Float.parseFloat(scanner.nextLine());

                // Writing data
                dos.writeInt(roll);
                dos.writeUTF(name);
                dos.writeFloat(gpa);
            }

            System.out.println("\nStudent data saved to " + FILE_NAME);

        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }

        // Reading student data from binary file
        System.out.println("\nReading data from file:");
        try (DataInputStream dis = new DataInputStream(new FileInputStream(FILE_NAME))) {
            while (true) {
                int roll = dis.readInt();
                String name = dis.readUTF();
                float gpa = dis.readFloat();

                System.out.printf("Roll: %d, Name: %s, GPA: %.2f%n", roll, name, gpa);
            }
        } catch (EOFException eof) {
            System.out.println("End of file reached.");
        } catch (IOException e) {
            System.out.println("Error reading from file: " + e.getMessage());
        }

        scanner.close();
    }
}
