import java.util.PriorityQueue;
import java.util.Queue;

class Patient implements Comparable<Patient> {
    String name;
    int severity; 
    public Patient(String name, int severity) {
        this.name = name;
        this.severity = severity;
    }

    public String getName() {
        return name;
    }

    public int getSeverity() {
        return severity;
    }

    @Override
    public int compareTo(Patient other) {
        // Higher severity should have higher priority (treated first)
        // So, we compare in reverse order of severity
        return Integer.compare(other.severity, this.severity);
    }

    @Override
    public String toString() {
        return "(" + name + ", Severity: " + severity + ")";
    }
}

public class HospitalTriage {

    public static void main(String[] args) {
        Queue<Patient> triageQueue = new PriorityQueue<>();

        // Add patients to the triage queue
        triageQueue.offer(new Patient("John", 3));
        triageQueue.offer(new Patient("Alice", 5));
        triageQueue.offer(new Patient("Bob", 2));
        triageQueue.offer(new Patient("Charlie", 4));
        triageQueue.offer(new Patient("Eve", 1));

        System.out.println("Triage Queue (initial order based on insertion): " + triageQueue);

        System.out.println("\nOrder of treatment (highest severity first):");
        while (!triageQueue.isEmpty()) {
            Patient nextPatient = triageQueue.poll();
            System.out.println("Treating: " + nextPatient);
        }
    }
}