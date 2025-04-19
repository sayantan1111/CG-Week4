import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class RemoveDuplicates {

    public static <T> List<T> removeDuplicatesOrdered(List<T> list) {
        // Use LinkedHashSet to maintain insertion order and remove duplicates
        Set<T> set = new LinkedHashSet<>(list);
        // Create a new ArrayList from the LinkedHashSet to get the ordered list without duplicates
        return new ArrayList<>(set);
    }

    public static void main(String[] args) {
        List<Integer> inputList = List.of(3, 1, 2, 2, 3, 4);
        List<Integer> outputList = removeDuplicatesOrdered(inputList);
        System.out.println("Input: " + inputList);
        System.out.println("Output: " + outputList); // Output: [3, 1, 2, 4]

        List<String> stringList = List.of("apple", "banana", "apple", "orange", "banana");
        List<String> uniqueStringList = removeDuplicatesOrdered(stringList);
        System.out.println("Input: " + stringList);
        System.out.println("Output: " + uniqueStringList); // Output: [apple, banana, orange]
    }
}