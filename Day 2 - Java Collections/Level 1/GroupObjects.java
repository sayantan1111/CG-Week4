import java.util.*;
class GroupObjects{
public static void main(String[]args){

List<Map.Entry<String, String>> employees = Arrays.asList(
            new AbstractMap.SimpleEntry<>("Alice", "HR"),
            new AbstractMap.SimpleEntry<>("Bob", "IT"),
            new AbstractMap.SimpleEntry<>("Carol", "HR")
        );

        Map<String, List<String>> deptMap = new HashMap<>();

        for (Map.Entry<String, String> emp : employees) {
            String name = emp.getKey();
            String dept = emp.getValue();

            deptMap
                .computeIfAbsent(dept, k -> new ArrayList<>())
                .add(name);
        }

        for (Map.Entry<String, List<String>> entry : deptMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        } 
}
}