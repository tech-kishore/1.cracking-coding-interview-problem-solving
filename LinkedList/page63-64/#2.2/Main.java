// Online Java Compiler
// Use this editor to write, compile and run your Java code online

//FIND K-TH ELEMENT OF A SINGLY LINKEDLIST
class Main {
    public static void main(String[] args) {
        int k=9;
        MyLinkedList l=new MyLinkedList(10);
        l.add(20);
        l.add(30);
        l.add(40);
        l.add(50);
        l.add(60);
        l.add(70);
        l.add(80);
        l.add(90);
      
        MyLinkedList.Node p1=l.getHead();
        MyLinkedList.Node p2=l.getHead(); 
        
        // runner technique
        // move p1 k-nodes ahead of p2
        for(int i=0;i<k;i++){
            if(p1==null)
            {
                System.out.println("k Out of bound");                
                return;
            }
            //if not last node
            if(p1.next!=null){
                p1=p1.next;
            }
        }
        
        //move both p1,p2 ahead at the same pace until p1 reaches the end
        while(p1.next!=null){
            p1=p1.next;
            p2=p2.next;
        }
        
        //k-th node is p2
        System.out.printf("k-th {%d} node(p2) is {data:%d, next=%s}",k,p2.data,p2.next);
        
    }
}

class MyLinkedList {
    
    Node head;
    
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
        Node current=head;
        while(current.next!=null){
            current=current.next;
        }
        current.next=new Node(data);
    }
    
    public void printAll(){
        Node n=head;
        while(n!=null){
            System.out.printf("Node(%s) [data- %d; next- %s]",n,n.data,n.next);
            n=n.next;
            System.out.println();
        }        
    }
}
