// Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.util.*;

class Main{
     
    public static void main(String[] args) throws Exception {

        StackOfPlates sp=new StackOfPlates();
        sp.push(1200);
        sp.push(1300);
        sp.push(1400);
        
        sp.push(2200);
        sp.push(2300);
        sp.push(2400);
        
        sp.push(3200);
        sp.push(3300);
        sp.push(3400);
        
        sp.push(4200);
        sp.push(4300);
        sp.push(4400);
        
        sp.printAllStacks(1);
        // System.out.println("PEEK:   "+sp.peek());
        // System.out.println("POP:    "+sp.pop());
        System.out.println("PEEK1:   "+sp.peek());
        int popStackIndex=0;
        System.out.println("POP AT Stack index - "+popStackIndex +":   " +sp.popAt(popStackIndex));
        System.out.println("PEEK2:   "+sp.peek());
        System.out.println("\n");
        sp.printAllStacks(2);
    }
}


class StackOfPlates {

    private List<Stack> stacks= new ArrayList();
    private int stackCapacity=3;
    
    public StackOfPlates(){
    }
    
    private void addStack(Stack s){
        stacks.add(s);
    }
    // >>> TEMPORARY METHOD
    public void printAllStacks(int c){
        System.out.println("#"+c+"\n~~~~~~~~~~~~~~~~~~~~~~");
        for(Stack s:stacks){
            int[] arr=s.getStack();
            for(int i=0;i<arr.length;i++){
                System.out.print(arr[i]+" | ");
            }
            System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~");
        }
    }
    
    private void removeStack(Stack stack){
        stacks.remove(stack);
    }
    
    private Stack getLastStack(){
        int stackIndex = getLastStackIndex();
        if(stackIndex<0){
            return null;
        }
        return stacks.get(stackIndex);
    }
    
    private int getLastStackIndex(){
        return stacks.size()-1;
    }
    
    public void push(int data){
        Stack stack=getLastStack();
        
        if(stack == null || stack.isFull()){
            stack = new Stack(stackCapacity);
            addStack(stack);
        }
        
        stack.push(data);
    }
    
    public int peek() throws Exception{
        Stack stack=getLastStack();
        if(stack==null)
            throw new Exception("Not stack available; Create a new stack first!");
        return stack.peek();
    }
    
    public int pop() throws Exception{
        Stack stack=getLastStack();
        if(stack==null)
            throw new Exception("Not stack available; Create a new stack first!");
        int data = stack.pop();
        if(stack.isEmpty())
            removeStack(stack);
        return data;
    }
    
    // pop element at a sub-stack; not necessarily the last stack
    // takes in the index of the stack in the arraylist
    public int popAt(int stackIndex) throws Exception{

        if(stackIndex < 0 || stackIndex > stacks.size()-1){
            throw new Exception("Invalid StackIndex - " + stackIndex);
        }
            
        Stack stack = stacks.get(stackIndex);
        int data = stack.pop(); 
        // ~~~ x ~~~~ Now here comes the trade-off ~~~ x ~~~~
        
            // if |>Performance<| if important then I leave it at this
                // No re-adjustment of the elements to fill up the empty stack index
                
            // if |>Space<| is important then
                // Shift all the next elements across all stacks to 1-step left
                
            //ASSUMING SPACE IS IMPOIRTANT
            reArrangeStackElements(stackIndex);
            
        return data;
    }
    
    private void reArrangeStackElements(int stackIndex){
        
        // get next indexes
        int noOfNextStacks = stacks.size()-(stackIndex+1);
        
        //1. stack index limit check
        if(noOfNextStacks<=0)
            return;
        
        Stack stack = stacks.get(stackIndex);   
        //2. element index in stack limit check
        if(stack.isEmpty())  // discard this stack from the  stacks collection
            return;
        
        // i. if stack is full
            // ii. move current stack to next stack
        if(stack.isFull()){
            stackIndex++;
            stack = stacks.get(stackIndex); 
        }
        
        //iii. if stack is not full 
            // iv. get bottom of next stack
            //  v. push
        int v = removeBottom(stackIndex+1);
        stack.push(v);
        
        // vi. recursive until last stack is null
        reArrangeStackElements(stackIndex+1);
     
    }
    
    private int removeBottom(int index){
        Stack stack = stacks.get(index);
        int bottom = stack.getBottom();
        //re-adjust stack elements at 1 go to left shift
        stack.leftShift(); 
        return bottom;
    }
  
}

class Stack{
     
    private static int capacity;
    private int[] arr;
    private int top=-1;
    
    public Stack(int _capacity){
        this.capacity=_capacity;
        arr=new int[capacity];
    }
    //>>>> temporary method
    public int[] getStack(){
        return arr;
    }
    // ::: NEW MOTHOD
    public int getBottom(){
        return arr[0];
    }
    
    // ::: NEW MOTHOD
    public void leftShift(){
        for(int i=0;i<top;i++){
            arr[i]=arr[i+1];
        }
        arr[top]=0;
        top--;
    }
    
    public boolean isEmpty(){
        return top==-1;
    }
    
    public boolean isFull(){
        return top==capacity-1;
    }
    
    public void push(int data){
        arr[++top]=data;
    }
    
    public int pop() throws Exception{
        if(isEmpty())
            throw new Exception("Empty stack, nothing to pop!");
        int val=arr[top];
        arr[top]=0; // clean data
        top-=1;
        return val;
    }
    
    public int peek() throws Exception{
        if(isEmpty())
            throw new Exception("Empty stack, nothing to peek!");
        return arr[top];
    }
}