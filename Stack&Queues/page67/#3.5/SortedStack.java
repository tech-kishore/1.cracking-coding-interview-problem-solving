/* Online Java Compiler and Editor */
public class SortedStack extends Stack{
    
    private Stack<Integer> ts = new Stack<>();
    
     public void push(Integer data) throws Exception{
         if(super.isEmpty()){
             super.push(data);
             return;
         }
        
         // if new data is greater than current top
         if(data>(Integer)super.peek()){
             super.push(data); // simply push new data
             return;
         }
         // ELSE if new data is smaller than top, then
         //loop curr top going downwards
         while(!super.isEmpty() && data<(Integer)super.peek()){
             ts.push((Integer)super.pop()); // push in temporary stack; ts
         }
         //insert data
         super.push(data);
         
         // loop temp stack; insert to main stack
         while(!ts.isEmpty()){
             super.push(ts.pop());
         }
         
     }

     public static void main(String []args) throws Exception{
        SortedStack ss = new SortedStack();
        ss.push(100);
        ss.push(200);
        ss.push(30);
        ss.push(150);
        ss.push(50);
        
        System.out.printf("1. %d",ss.pop());
        System.out.printf("2. %d",ss.pop());
        System.out.printf("3. %d",ss.pop());
        System.out.printf("4. %d",ss.pop());
        System.out.printf("5. %d",ss.pop());
     }
}

class Stack<T> {
    private StackNode<T> top;

    public Stack() {
    }

    public Stack(T data) {
        top=new StackNode(data);
    }

    private class StackNode<T> {
        T data;
        StackNode next;

        StackNode(T _data) {
            this.data=_data;
        }
    }
    
    public boolean isEmpty() {
        return top==null;
    }

    public void push(T data) {
        StackNode newNode=new StackNode(data);
        //check empty stack
        if(isEmpty()) {
            top=newNode;
            return;
        }

        newNode.next=top; // place new node above current top of the stack
        top = newNode; // Make new node the current top
    }

    public T pop() throws Exception {
        if(isEmpty())
            throw new Exception("Pop: No element");

        T value = top.data;
        top=top.next; //remove top of stack
        return value;
    }

    public T peek() throws Exception {
        if(isEmpty())
            throw new Exception("Peek: No element");
        return top.data;
    }
}