// Online Java Compiler
// Use this editor to write, compile and run your Java code online

public class GraphExample {
    public static void main(String[] args) {
        Graph g = new Graph(6);
        g.addEdge(0,2);
        g.addEdge(0,4);
        g.addEdge(2,1);
        g.addEdge(0,5);
        g.addEdge(4,3);
        g.addEdge(4,5);
        g.traverse();
    }
}

class Graph{
    private int size;
    private Node[] nodes;
    public Graph(int v){
        this.size=v;
        nodes = new Node[size];
        
        // create graph
        for(int i=0;i<size;i++){
            nodes[i]=new Node("n"+i);
        }
    }
    
    public void addEdge(int idx1, int idx2){
        Node v1=nodes[idx1];
        Node v2=nodes[idx2];
        
        v1.neighbors[v1.idx++]=v2; // create edge from v1 to v2
        v2.neighbors[v2.idx++]=v1; // create edge from v2 to v1
    }
    
    public void traverse(){
        for(Node n: nodes){
            System.out.printf("\n%s",n);
            for(Node r: n.neighbors){
                if(r!=null)
                    System.out.printf("\n \t>%s ", r);
            }
        }
    }
    
    class Node{
        public String name;
        public Node[] neighbors = new Node[size-1];
        public int idx; // neighbours current size
        public boolean visited=false;
        
        Node(String n){
            this.name = n;
        }
        
        public String toString(){
            return name;
        }
        
    }
    
    
}
