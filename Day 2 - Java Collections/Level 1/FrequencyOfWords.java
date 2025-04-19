import java.util.*;

class FrequencyOfWords{
    public static void main(String[]args){
        Scanner s=new Scanner(System.in);
        String st=s.nextLine();
      String clean=st.toLowerCase().replaceAll("[^a-z\\s]", " ");
      String [] words=clean.split("\\s+");
      Map<String,Integer>m=new HashMap<>();
      for(String word:words){
        m.put(word,m.getOrDefault(word, 0)+1);
      }
        System.out.println(m);
    }
}