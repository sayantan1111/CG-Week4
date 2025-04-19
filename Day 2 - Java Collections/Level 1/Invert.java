import java.util.*;
class Invert{
    public static void main(String[]args){
        Map<String,Integer>m=new HashMap<>();
        m.put("A",1);
        m.put("B",2);
        m.put("C",1);

        Map<Integer,List<String>>m1=new HashMap<>();
        for(Map.Entry<String,Integer>e:m.entrySet()){
            String key=e.getKey();
            Integer value=e.getValue();
            m1.computeIfAbsent(value,k->new ArrayList<>()).add(key);
        }
        System.out.println(m1);
    }
}