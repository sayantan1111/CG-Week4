import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class RotateArray {
    public static void rotateArray(Integer[] arr, int positions) {
        List<Integer> list = Arrays.asList(arr);
        Collections.rotate(list, positions);
        list.toArray(arr);
    }

    public static void main(String[] args) {
        Integer[] arr = {10, 20, 30, 40, 50};
        int positions = 3;

        System.out.println("Original Array: " + Arrays.toString(arr));
        rotateArray(arr, positions);
        System.out.println("Rotated Array by " + positions + " positions: " + Arrays.toString(arr));
    }
}