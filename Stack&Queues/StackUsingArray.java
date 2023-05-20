// Online Java Compiler
// Use this editor to write, compile and run your Java code online


class StackUsingArray {
   
    
    public static void main(String[] args)  throws Exception {
        Stack<String> stack= new Stack<>();
        stack.push(2000);
        stack.push(4000);
        System.out.printf("pop1: %s \n",stack.pop());
        System.out.printf("peek1: %s \n",stack.peek());
        System.out.printf("pop2: %s \n",stack.pop());
        System.out.printf("peek2: %s \n",stack.peek());
    }
}

class Stack<T>{
     
    private static final int SIZE= 256;
    private int[] arr=new int[SIZE];
    private int top=-1;
    
    public Stack(){
    }
    
    public Stack(int data){
        arr[++top]=data;
    }
    
    public boolean isEmpty(){
        return top==-1;
    }
    
    public void push(int data){
        arr[++top]=data;
    }
    
    public int pop() throws Exception{
        if(isEmpty())
            throw new Exception("Empty stack, nothing to pop!");
        int val=arr[top];
        top-=1;
        return val;
    }
    
    public int peek() throws Exception{
        if(isEmpty())
            throw new Exception("Empty stack, nothing to peek!");
        return arr[top];
    }
}