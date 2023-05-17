// Online Java Compiler
// Use this editor to write, compile and run your Java code online

public class StackExample {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
    }
    
}

class Stack{
    private StackNode bottom;
    private StackNode top;
    
    public Stack(int data){
        top=new StackNode(data);
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
    
    // continue .....
}