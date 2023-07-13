// Online Java Compiler
// Use this editor to write, compile and run your Java code online

public class StackWithMinExample {
    public static void main(String[] args) throws Exception {
        // StackWithMin s=new StackWithMin();
        StackWithMin s=new StackWithMin(20);// work here for min >>>>
        s.push(100);
        s.push(200);
        s.push(50);
         s.push(10);
        // s.push(300);
        // s.push(400);
        // s.push(500);
        // s.push(600);
        System.out.println("\n");
        
        try{
            System.out.printf("Peek 1: %d\n", s.peek());
            System.out.printf("Pop 1: %d\n", s.pop()); 
            System.out.printf("Peek 2: %d\n", s.peek());
            System.out.printf("Min ****: %d\n", s.min());
            // System.out.printf("Pop 2: %d\n", s.pop());
            // System.out.printf("Pop 3: %d\n", s.pop());
            // System.out.printf("Pop 4: %d\n", s.pop());
            // System.out.printf("Pop 5: %d\n", s.pop());
            // System.out.printf("Pop 6: %d\n", s.pop());
            // System.out.printf("Peek 3: %d\n", s.peek());
        }catch(Exception e){
             System.out.println(e.getMessage());
        }
    }
}

class StackWithMin extends Stack{
    
    private Stack minStack = new Stack();
    
    public StackWithMin(){
        super();
    }
    
    public StackWithMin(int data){
        super(data);
        minStack.push(data);
    }
    
    public int min() throws Exception{
        if(isEmpty()) 
            throw new Exception("Min: No element-> "+this);
        return minStack.peek();
    }
    
    public int pop() throws Exception{
         int val = super.peek();
        try{
            super.pop();
            if(!minStack.isEmpty()){
                minStack.pop();
            }
        }catch(Exception e){
            throw new Exception(e);
        }
        return val;
    }
    
    public void push(int data){
        // push in min stack only if new value less than top of min stack
        try{
            super.push(data);
            if(minStack.isEmpty() || minStack.peek()>data) {
                minStack.push(data);
            }
        }catch(Exception e){
            System.out.println(e);
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
            
        int value = peek();//top.data;
        top=top.next; //remove top of stack
        return value;
    }
    
    public int peek() throws Exception{
        if(isEmpty()) 
            throw new Exception("Peek: No element > " + this);
        return top.data;
    }
}