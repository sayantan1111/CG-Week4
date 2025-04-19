import java.util.*;
class MergeOfMap{
    public static void main(String[]args){
        Map<String,Integer>m=new HashMap<>();
        m.put("A",1);
        m.put("B",2);
        Map<String,Integer>m1=new HashMap<>();
        m1.put("B",3);
        m1.put("C",4);
        Map<String,Integer>m2=new HashMap<>();

        for(Map.Entry<String,Integer>e:m.entrySet()){
            m2.put(e.getKey(),e.getValue());
        }
        for(Map.Entry<String,Integer>e1:m1.entrySet()){
            m2.put(e1.getKey(),m2.getOrDefault(e1.getKey(),0)+e1.getValue());
        }
        System.out.println(m2);
    }
}