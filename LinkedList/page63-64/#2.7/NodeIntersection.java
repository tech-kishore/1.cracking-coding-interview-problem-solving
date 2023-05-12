// Online Java Compiler
// Use this editor to write, compile and run your Java code online

// FIND INTERSECTION NODE OF 2 SINGLY LINKED LIST
public class NodeIntersection {
    public static void main(String[] args) {
        
        MyLinkedList.Node common=new MyLinkedList.Node(7);
        
        MyLinkedList l1=new MyLinkedList();
        l1.append(new MyLinkedList.Node(3));
        l1.append(new MyLinkedList.Node(1));
        l1.append(new MyLinkedList.Node(5));
        l1.append(new MyLinkedList.Node(9));
        l1.append(common);
        l1.append(new MyLinkedList.Node(2));
        l1.append(new MyLinkedList.Node(1));
        
        MyLinkedList l2=new MyLinkedList();
        l2.append(new MyLinkedList.Node(4));
        l2.append(new MyLinkedList.Node(6));
        l2.append(common);
        l1.printAll();
        l2.printAll();

        MyLinkedList.Node l1_node=l1.getHead();
        MyLinkedList.Node l2_node=l2.getHead();
        
        // System.out.printf("L1 %s,L2 %s",l1_node,l2_node);
        
        int l1_len=l1.length();
        int l2_len=l2.length();

        int diff=l1_len > l2_len ? l1_len-l2_len : l2_len-l1_len;
        
        // make both list of equal lengths
        if(l1_len > l2_len){
            while(diff!=0){
                l1_node=l1_node.next;
                diff--;
            }
        }else{
             while(diff!=0){
                l2_node=l2_node.next;
                diff--;
            }
        }
        
        MyLinkedList.Node intersection_node=null;
        while(l1_node!=null && l2_node!=null){
            if(l1_node==l2_node){
                intersection_node=l1_node;
                break;
            }
            
            l1_node=l1_node.next;
            l2_node=l2_node.next;
        }
        
        if(intersection_node==null){
            System.out.println("No Intersection");
            return;
        }
        
        System.out.printf("Intersection Node -  %s , Data- %s ", intersection_node,intersection_node.data);
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
            System.out.printf(" %d ",n.data);
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
