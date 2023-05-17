// Online Java Compiler
// Use this editor to write, compile and run your Java code online

public class StackExample {
    public static void main(String[] args) throws Exception {
        
        Stack s=new Stack();
        s.push(100);
        s.push(200);
        s.push(300);
        s.push(400);
        s.push(500);
        s.push(600);
        
        try{
            System.out.printf("Pop 1: %d\n", s.pop());
            System.out.printf("Pop 2: %d\n", s.pop());
            System.out.printf("Peek 1: %d\n", s.peek());
            System.out.printf("Pop 3: %d\n", s.pop());
            System.out.printf("Peek 2: %d\n", s.peek());
        }catch(Exception e){
             System.out.println(e.getMessage());
        }
    }
}

class Stack{
    private StackNode top;
    
    public Stack(){
    }
    
    public Stack(int data){
        top=new StackNode(data);
    }
    
    private class StackNode{
        int data;
        StackNode next;
        
        StackNode(int _data){
            this.data=_data;    
        }
    }
    
    public boolean isEmpty(){
        return top==null;    
    }
    
    public void push(int data){
        StackNode newNode=new StackNode(data);
        //check empty stack
        if(isEmpty()){
            top=newNode;
            return;
        }
        
        newNode.next=top; // place new node above current top of the stack
        top = newNode; // Make new node the current top
    }
    
    public int pop() throws Exception{
        if(isEmpty())
            throw new Exception("Pop: No element");
            
        int value = top.data;
        top=top.next; //remove top of data
        return value;
    }
    
    public int peek() throws Exception{
        if(isEmpty()) 
            throw new Exception("Peek: No element");
        return top.data;
    }
}