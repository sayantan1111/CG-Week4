import java.util.*;
class CheckingForEqual{
    public static void main(String[]args){
        HashSet<Integer>h=new HashSet<>();
        h.add(1);
        h.add(2);
        h.add(3);
        HashSet<Integer>h1=new HashSet<>();
        h1.add(3);
        h1.add(2);
        h1.add(1);
        System.out.println(h.equals(h1));
    }
}