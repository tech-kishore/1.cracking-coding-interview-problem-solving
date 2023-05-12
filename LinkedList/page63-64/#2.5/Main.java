// Online Java Compiler
// Use this editor to write, compile and run your Java code online

// CHECK IF LINKED LIST IS PALINDROME
public class Main {
    public static void main(String[] args) {
        MyLinkedList l1=new MyLinkedList();
        l1.add(7);l1.add(1);l1.add(6);l1.add(1);l1.add(7);l1.add(6);

        boolean isPalindrome=true;

        MyLinkedList.Node slow=l1.getHead();
        MyLinkedList.Node fast=l1.getHead();
        
        int[] arr=new int[10]; // come back to this
        
        int c=0;
        MyLinkedList.Node mid=null;
        arr[c]=slow.data;
        // fast.next is null (Odd elements) - mid
        // fast is null (Even elements) - mid=mid+1
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            
            arr[++c]=slow.data;
            mid=slow;
        }
        
        /**
        * Handle even length lists
        * ========================
        * if c is even then even length linked list; midddle at mid+1
        * else odd length linked list; middle at mid
        **/
        if(c%2!=0) // even length
            c--; // point to previous element of mid
        
        while(mid!=null){
            if(mid.data!=arr[c--])
                isPalindrome=false;
            mid=mid.next;
        }
        System.out.printf("Is palindrome:{%b}",isPalindrome);
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
    
    public void printAll(){
        Node n=head;
        while(n!=null){
            System.out.printf(" %d ",n.data);
            n=n.next;
            if(n!=null)
                System.out.printf("->");
        }        
    }
}
