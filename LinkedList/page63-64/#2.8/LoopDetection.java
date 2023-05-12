// Online Java Compiler
// Use this editor to write, compile and run your Java code online

public class Main {
    public static void main(String[] args) {
        
        MyLinkedList.Node common=new MyLinkedList.Node('C');

        MyLinkedList l1=new MyLinkedList();
        l1.append(new MyLinkedList.Node('A'));
        l1.append(new MyLinkedList.Node('B'));
        l1.append(common);
        l1.append(new MyLinkedList.Node('D'));
        l1.append(new MyLinkedList.Node('E'));
        l1.append(common);
        // l1.printAll();
        
        delectLoopAndFindFirstCollidingNode(l1);

    }
    
    private static void delectLoopAndFindFirstCollidingNode(MyLinkedList l){
        MyLinkedList.Node head = l.getHead();
        MyLinkedList.Node slow= head;
        MyLinkedList.Node fast=head;
        
        boolean isCircular = false;
        int c=1;
         while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            System.out.printf("\n %d. slow: %c - fast: %c",c++,(char)slow.data,(char)fast.data);
            if(slow==fast){
                isCircular = true;
                break;
            }
        }
        
        if(!isCircular)
        {
             System.out.println("No loop detected!");
             return;
        }
        
        //reset slow to compare from begining
        slow=head;
        while(slow!=fast){
            slow=slow.next;
            fast=fast.next;
        }
        System.out.printf("\n ***** Loop starting node: %c",(char)fast.data);
        
    }
    
}

class MyLinkedList {
    
    Node head;
    
    MyLinkedList(){
    }
    
    MyLinkedList(int data){
        head=new Node(data);
    }
    
    public Node getHead(){
        return this.head;
    }

    static class Node{
        int data;
        Node next;
        Node(int _data){
            this.data=_data;
        }
    }
    
    public void add(int data){
        if(head==null){
            head=new Node(data);
        }else{
            Node current=head;
            while(current.next!=null){
                current=current.next;
            }
            current.next=new Node(data);
        }
        
    }
    
    public void append(Node n){
        if(head==null){
            head=n;
        }else{
            Node end=head;
            while(end.next!=null){
                end=end.next;
            }
            end.next=n;
        }
    }
    
    public void printAll(){
        Node n=head;
        
        while(n!=null){
            System.out.printf(" %c ",(char)n.data);
            n=n.next;
            if(n!=null)
                System.out.printf("->");
        }        
    }
    
    public int length(){
        Node n=head;
        int c=0;
        while(n!=null){
            c++;
            n=n.next;
        }
        return c;
    }
}
