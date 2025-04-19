import java.util.LinkedList;
import java.util.Queue;

class StoQ {
    private Queue<Integer> q1 = new LinkedList<>();
    private Queue<Integer> q2 = new LinkedList<>();
    public void push(int x){
        q1.add(x);
    }
    public int pop(){
        if(q1.isEmpty()){
            throw new RuntimeException("stack empty");
        }
        while(q1.size()>1){
            q2.add(q1.remove());
        }
        int top=q1.remove();
        Queue<Integer>temp=q1;
        q1=q2;
        q2=temp;
        return top;
    }
    public int top(){
        if(q1.isEmpty()){
            throw new RuntimeException("Stack empty");
        }
        while(q1.size()>1){
            q2.add(q1.remove());
        }
        int top=q1.remove();
        q2.add(top);
        Queue<Integer>temp=q1;
        q1=q2;
        q2=temp;
        return top;
    }
    public boolean empty(){
        return q1.isEmpty();
    }}
    public class StacktoQueue{
        public static void main(String[]args){
            StoQ a=new StoQ();
            a.push(2);
            a.push(3);
            a.push(4);
            System.out.println("Top element: " + a.top()); // Output: 3
            System.out.println("Popped element: " +a.pop()); // Output: 3
            System.out.println("Top after pop: " + a.top()); // Output: 2
        }
        }
    