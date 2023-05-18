// Online Java Compiler
// Use this editor to write, compile and run your Java code online

public class StackGenericExample {
    public static void main(String[] args) throws Exception {
        
        Stack<Character> s=new Stack<>();
        s.push('a');
        s.push('b');
        s.push('c');
        s.push('d');
        s.push('e');
        s.push('f');
        
        try{
            System.out.printf("Pop 1: %s\n", s.pop());
            System.out.printf("Pop 2: %s\n", s.pop());
            System.out.printf("Peek 1: %s\n", s.peek());
            System.out.printf("Pop 3: %s\n", s.pop());
            System.out.printf("Peek 2: %s\n", s.peek());
        }catch(Exception e){
             System.out.println(e.getMessage());
        }
    }
}

class Stack<T>{
    private StackNode<T> top;
    
    public Stack(){
    }
    
    public Stack(T data){
        top=new StackNode(data);
    }
    
    private class StackNode<T>{
        T data;
        StackNode next;
        
        StackNode(T _data){
            this.data=_data;    
        }
    }
    
    public boolean isEmpty(){
        return top==null;    
    }
    
    public void push(T data){
        StackNode newNode=new StackNode(data);
        //check empty stack
        if(isEmpty()){
            top=newNode;
            return;
        }
        
        newNode.next=top; // place new node above current top of the stack
        top = newNode; // Make new node the current top
    }
    
    public T pop() throws Exception{
        if(isEmpty())
            throw new Exception("Pop: No element");
            
        T value = top.data;
        top=top.next; //remove top of stack
        return value;
    }
    
    public T peek() throws Exception{
        if(isEmpty()) 
            throw new Exception("Peek: No element");
        return top.data;
    }
}