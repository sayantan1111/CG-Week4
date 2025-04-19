import java.util.*;
class SortedList{
    public static void main(String[]args){
        Set<Integer>s=new TreeSet<>();
        s.add(5);
        s.add(3);
        s.add(9);
        s.add(1);
        List<Integer>list=new ArrayList<>(s);
        System.out.println(list);
    }
}