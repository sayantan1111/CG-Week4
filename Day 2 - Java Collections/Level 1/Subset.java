import java.util.*;
class Subset{
    public static void main(String[]args){
        Set<Integer>s1=new HashSet<>();
        s1.add(2);
        s1.add(3);
        Set<Integer>s2=new HashSet<>();
        s2.add(1);
        s2.add(2);
        s2.add(3);
        s2.add(4);
        System.out.println(s2.containsAll(s1));
    }
}