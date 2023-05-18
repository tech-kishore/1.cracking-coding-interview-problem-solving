// Online Java Compiler
// Use this editor to write, compile and run your Java code online

public class QueueGenericExample {
    public static void main(String[] args) throws Exception {
        
        Queue<Character> q=new Queue<>();
        q.add('a');
        q.add('b');
        q.add('c');
        q.add('d');
        q.add('e');
        q.add('f');
        
        try{
            System.out.printf("Pop 1: %s\n", q.pop());
            System.out.printf("Pop 2: %s\n", q.pop());
            System.out.printf("Peek 1: %s\n", q.peek());
            System.out.printf("Pop 3: %s\n", q.pop());
            System.out.printf("Peek 2: %s\n", q.peek());
        }catch(Exception e){
             System.out.println(e.getMessage());
        }
    }
}

class Queue<T>{
    private QueueNode<T> front;
    private QueueNode<T> rear;
    
    public Queue(){
    }
    
    public Queue(T data){
        front=new QueueNode(data);
        rear=front;
    }
    
    private class QueueNode<T>{
        T data;
        QueueNode next;
        
        QueueNode(T _data){
            this.data=_data;    
        }
    }
    
    public boolean isEmpty(){
        return front==null;    
    }
    
    public void add(T data){
        QueueNode newNode=new QueueNode(data);
        // check empty queue for NULL
        if(isEmpty())
        {
            front=newNode;
            rear=front;
            return;
        }
        
        rear.next=newNode; // link new node behind current rear
        rear=rear.next; // mark new node as rear
    }
    
    public T pop() throws Exception{
        if(isEmpty())
            throw new Exception("Pop: No element");
            
        T value = front.data;
        front=front.next; // remove current front
        return value;
    }
    
    public T peek() throws Exception{
        if(isEmpty()) 
            throw new Exception("Peek: No element");
        return front.data;
    }
}