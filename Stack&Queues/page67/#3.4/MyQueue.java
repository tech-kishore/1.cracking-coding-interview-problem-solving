// Online Java Compiler : totorialspoint
// link: https://www.tutorialspoint.com/online_java_compiler.php

public class MyQueue<T> extends Stack<T>{

    private Stack<T> bs=new Stack<>(); // backup stack
    
    public MyQueue(){
    }
    
    private void  shiftToBackupStack() throws Exception{
        //loop till head of current stack(s) linked list is reached
            // pop mq stack
            // push mq element ot backup(bs) stack
            // if last element is reached
            do{
                bs.push(super.pop());
            }while(!isEmpty());
    }
    
    
    private void shiftBackToActualStack() throws Exception{
        // loop till end of back up stack linked list is reached
            // push element to current stack(s) linked list
            do{
                super.push(bs.pop());
            }while(!bs.isEmpty());
    }
    
    public T pop() throws Exception {
        shiftToBackupStack();
        T val = bs.pop();
        shiftBackToActualStack();
        return val;
    }
    
    
    public T peek() throws Exception {
        shiftToBackupStack();
        T val = bs.peek();
        shiftBackToActualStack();
        return val;
    }

    public static void main(String[] args) {
        MyQueue<Character> mq =new MyQueue<>();
        mq.push('a');
        mq.push('b');
        mq.push('c');
        mq.push('d');
        mq.push('e');
        mq.push('f');
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("----------------------------------------");
        try {
            System.out.printf("Peek 1: %s\n", mq.peek());
            mq.pop();
            System.out.printf("Pop1 - Peek 2: %s\n", mq.peek());
            mq.pop();
            System.out.printf("Pop2 - Peek 3: %s\n", mq.peek());
            mq.pop();
            System.out.printf("Pop3 - Peek 4: %s\n", mq.peek());
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
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