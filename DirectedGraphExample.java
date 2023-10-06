package graph;

import graph.DirectedGraph.Node;

public class DirectedGraphExample{
    public static void main(String[] args) {
        DirectedGraph g = new DirectedGraph(6);
        populateGraph(g);

        Node n1=g.getNode(0);
        Node n2=g.getNode(5);

        boolean routeExist = dfs_search_route_exist(g,n1,n2);
        System.out.printf("Route exist: %b",routeExist);
        
        // traverse
        // g.traverse();
    }

    private static boolean dfs_search_route_exist(DirectedGraph g, Node n1, Node n2) {
        System.out.printf("%s - %s - %b\n",n1,n2, n1==n2);
         if(n1==n2)
            return true;

        Node start = n1;
        start.visited = true;
        
        for(Node curr: n1.neighbors){
            if(curr==null)
                continue;
            
           
            if(!curr.visited){
                //recursive
               return dfs_search_route_exist(g, curr, n2);
            }
        }

        return false;
    }

    private static void populateGraph(DirectedGraph g) {
        g.addEdge(0,2); // n1->n3
        g.addEdge(0,3); // n1->n4
        g.addEdge(0,4); // n1->n5

        g.addEdge(4,1); // n5->n2
        g.addEdge(4,5); // n5->n6

        g.addEdge(2,5); // n3->n6 
        
        g.addEdge(5,3); // n6->n3 
    }
}
class DirectedGraph{
    private int size;
    private Node[] nodes;
    public DirectedGraph(int v){
        this.size=v;
        nodes = new Node[size];
        
        // create vertices of graph
        for(int i=0;i<size;i++){
            nodes[i]=new Node("n"+i);
        }
    }
    public Node getNode(int idx) {
    	return nodes[idx];
    }
    
    public void addEdge(int idx1, int idx2){
        Node v1=nodes[idx1];
        Node v2=nodes[idx2];
        
        v1.neighbors[v1.idx++]=v2; // create edge from v1 to v2
        // v2.neighbors[v2.idx++]=v1; // create edge from v2 to v1
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
    
   protected class Node{
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
