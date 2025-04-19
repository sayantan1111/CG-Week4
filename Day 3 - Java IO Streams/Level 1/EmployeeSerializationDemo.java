import java.io.*;
import java.util.*;

class Employee implements Serializable {
    private static final long serialVersionUID = 1L;

    private int id;
    private String name;
    private String department;
    private double salary;

    // Constructor
    public Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    // toString method for displaying employee info
    @Override
    public String toString() {
        return String.format("ID: %d, Name: %s, Dept: %s, Salary: %.2f", id, name, department, salary);
    }
}

public class EmployeeSerializationDemo {

    private static final String FILE_NAME = "employees.ser";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Employee> employees = new ArrayList<>();

        System.out.print("Enter number of employees to add: ");
        int count = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < count; i++) {
            System.out.println("\nEnter details for employee #" + (i + 1));
            System.out.print("ID: ");
            int id = Integer.parseInt(scanner.nextLine());
            System.out.print("Name: ");
            String name = scanner.nextLine();
            System.out.print("Department: ");
            String department = scanner.nextLine();
            System.out.print("Salary: ");
            double salary = Double.parseDouble(scanner.nextLine());

            employees.add(new Employee(id, name, department, salary));
        }

        // Serialize the list to file
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(employees);
            System.out.println("\nEmployees have been serialized to " + FILE_NAME);
        } catch (IOException e) {
            System.out.println("Serialization error: " + e.getMessage());
        }

        // Deserialize the list from file
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            List<Employee> deserializedEmployees = (List<Employee>) ois.readObject();
            System.out.println("\nDeserialized Employee List:");
            for (Employee emp : deserializedEmployees) {
                System.out.println(emp);
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Deserialization error: " + e.getMessage());
        }

        scanner.close();
    }
}
