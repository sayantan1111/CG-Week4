import java.util.LinkedList;

public class FindNthFromEnd<T> {

    public T findNthFromEnd(LinkedList<T> list, int n) {
        if (list == null || list.isEmpty() || n <= 0) {
            return null; // Handle invalid input
        }

        LinkedList.Node<T> slowPtr = list.getFirst();
        LinkedList.Node<T> fastPtr = list.getFirst();

        // Move fastPtr N nodes ahead
        for (int i = 0; i < n; i++) {
            if (fastPtr == null) {
                return null; // N is greater than the list size
            }
            fastPtr = fastPtr.next;
        }

        // Move both pointers until fastPtr reaches the end
        while (fastPtr != null) {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next;
        }

        return slowPtr != null ? slowPtr.item : null;
    }

    public static void main(String[] args) {
        FindNthFromEnd<String> finder = new FindNthFromEnd<>();
        LinkedList<String> list = new LinkedList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("E");

        int n = 2;
        String nthElement = finder.findNthFromEnd(list, n);

        if (nthElement != null) {
            System.out.println("The " + n + "th element from the end is: " + nthElement); // Output: The 2th element from the end is: D
        } else {
            System.out.println("Invalid input or N is out of bounds.");
        }

        LinkedList<Integer> numList = new LinkedList<>();
        numList.add(10);
        numList.add(20);
        numList.add(30);

        int m = 1;
        Integer mthElement = finder.findNthFromEnd(numList, m);
        if (mthElement != null) {
            System.out.println("The " + m + "st element from the end is: " + mthElement); // Output: The 1st element from the end is: 30
        } else {
            System.out.println("Invalid input or M is out of bounds.");
        }

        Integer outOfBounds = finder.findNthFromEnd(numList, 4);
        if (outOfBounds == null) {
            System.out.println("Finding 4th element from end: Invalid input or N is out of bounds."); // Output: Finding 4th element from end: Invalid input or N is out of bounds.
        }
    }
}