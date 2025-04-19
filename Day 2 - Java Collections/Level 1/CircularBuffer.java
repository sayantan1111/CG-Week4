import java.util.ArrayDeque;
import java.util.Queue;

public class CircularBuffer<T> {
    private final int capacity;
    private final Queue<T> buffer;

    public CircularBuffer(int capacity) {
        this.capacity = capacity;
        this.buffer = new ArrayDeque<>(capacity);
    }

    public void insert(T element) {
        if (buffer.size() == capacity) {
            buffer.poll(); // remove oldest element
        }
        buffer.offer(element); // add new element
    }

    public void printBuffer() {
        System.out.println(buffer);
    }

    public static void main(String[] args) {
        CircularBuffer<Integer> cb = new CircularBuffer<>(3);
        cb.insert(1);
        cb.insert(2);
        cb.insert(3);
        cb.printBuffer(); // Output: [1, 2, 3]

        cb.insert(4);
        cb.printBuffer(); // Output: [2, 3, 4]
    }
}
