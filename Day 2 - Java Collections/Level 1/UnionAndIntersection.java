import java.util.*;
class UnionAndIntersection{
    public static void main(String[]args){
        HashSet<Integer>h=new HashSet<>();
        h.add(1);
        h.add(2);
        h.add(3);
        HashSet<Integer>h1=new HashSet<>();
        h1.add(3);
        h1.add(4);
        h1.add(5);
        HashSet<Integer>h2=new HashSet<>(h);
        h2.addAll(h1);
        HashSet<Integer>h3=new HashSet<>(h);
        h3.retainAll(h1);
        System.out.println(h2);
        System.out.println(h3);
    }
}
