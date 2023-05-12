// Online Java Compiler
// Use this editor to write, compile and run your Java code online

//PARTITION LINKEDLIST ARROUND VALUE OF P
public class Main {
    public static void main(String[] args) {
        int p=5;
        
        MyLinkedList il=new MyLinkedList();
        il.add(3);
        il.add(5);
        il.add(8);
        il.add(5);
        il.add(10);
        il.add(2);
        il.add(1);
        
       
        //Head if input linked list
        MyLinkedList.Node head=il.getHead();
        //Current Node of input LL
        MyLinkedList.Node currNode=head;
        
        
        //Before LL
        MyLinkedList.Node beforeHead=null;
        MyLinkedList.Node beforeTail=null;
        //After LL
        MyLinkedList.Node afterHead=null;
        MyLinkedList.Node afterTail=null;
        
      
        //loop thru input LL
        while(currNode!=null){
            //store next of current node
            MyLinkedList.Node nextNode=currNode.next;
            
            //make next of current node null so that tail of input LL is removed in the new nodes.
            currNode.next=null;
            
            if(currNode.data<p){
                if(beforeHead==null){
                    beforeHead=currNode;
                    beforeTail=beforeHead;
                }else{
                    beforeTail.next=currNode;
                    beforeTail=beforeTail.next;
                }
             }else{
                if(afterHead==null){
                    afterHead=currNode;
                    afterTail=afterHead;
                }else{
                    afterTail.next=currNode;
                    afterTail=afterTail.next;
                }
             }
            currNode=nextNode;
        }
        
        //merge before LL with after LL
        if(beforeHead==null){
            beforeHead=afterHead;        
        }else{
             beforeTail.next=afterHead;
        }

        while(beforeHead!=null){
            System.out.printf(" %d ",beforeHead.data);
            beforeHead=beforeHead.next;
        }
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
    
    public void merge(MyLinkedList ll){
        Node node=head;
        //loop thru till end of LL
        while(node.next!=null){
            node=node.next;
        }
        //SET last node next of 1st LL to head of 2nd LL 
        node.next=ll.getHead();
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
            System.out.printf("Node(%s) [data- %d; next- %s]",n,n.data,n.next);
            n=n.next;
            System.out.println();
        }        
    }
}
