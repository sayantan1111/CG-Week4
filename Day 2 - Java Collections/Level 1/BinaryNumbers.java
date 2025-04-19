import java.util.*;
class BinaryNumbers{
    public static void main(String[]args){
        int n=5;
        List<String>l=getB(n);
       for(String Binary: l){
        System.out.println(Binary+" ");
       }
       System.out.println(l);
    }
    public static List<String>getB(int N){
       List<String>result=new ArrayList<>();
       Queue<String>q=new LinkedList<>();
       q.add("1");
       for(int i=0;i<N;i++){
        String current=q.remove();
        result.add(current);
        q.add(current+"0");
        q.add(current+"1");
       }
       return result;
    }
}