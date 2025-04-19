import java.util.*;
class HighestValue{
    public static void main(String[]args){
        Map<String,Integer>m=new HashMap<>();
        m.put("A",10);
        m.put("B",20);
        m.put("C",15);
       String maxKey=null;
       int maxvalue=Integer.MIN_VALUE;
       for(Map.Entry<String,Integer>e:m.entrySet()){
        if(e.getValue()>maxvalue){
            maxvalue=e.getValue();
            maxKey=e.getKey();
        }
       }
            
           

        
        System.out.println(maxKey);
    }
}