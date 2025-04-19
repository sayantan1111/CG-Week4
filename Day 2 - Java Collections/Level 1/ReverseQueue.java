import java.util.*;
class ReverseQueue{
    public static void main(String[]args){
        Queue<Integer>q=new LinkedList<>();
        q.add(2);
        q.add(3);
        q.add(4);

        System.out.println(q);
        reverse(q);
        System.out.println(q);
    }
    public static void reverse(Queue<Integer>q){
        if(q.isEmpty()){
            return ;
        }
        int front=q.remove();
        reverse(q);
        q.add(front);
    }
}