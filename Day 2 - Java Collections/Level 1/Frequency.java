import java.util.*;
class Frequency{
    public static void main(String[]args){
        List<String>list=new ArrayList();
        list.add("apple");
        list.add("banana");
        list.add("apple");
        list.add("orange");
        System.out.println(list);

        Map<String,Integer> m=new HashMap<>();
        for(String element:list){
            if(m.containsKey(element)){
                m.put(element,m.get(element)+1);
            }
            else{
                m.put(element,1);
            }
        }
        System.out.println(m);
    }
}