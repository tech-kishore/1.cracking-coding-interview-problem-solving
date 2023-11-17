package graph;

import java.util.LinkedList;
import graph.DirectedGraph.Node;

public class DirectedGraphExample{
    public static void main(String[] args) {
        DirectedGraph g = new DirectedGraph(6);
        populateGraph(g);

        Node n1=g.getNode(0);
        Node n2=g.getNode(5);
        
        //DFS
        System.out.println("Using DFS ................");
        boolean routeExistDFS = dfs_search_route_exist(g,n1,n2);
        System.out.printf("Route exist: %b\n",routeExistDFS);

        System.out.println("==========================================");
        
        // BFS [ ********** CHECK LOGIC ****************]
        System.out.println("Using BFS ................");
        boolean routeExistBFS = bfs_search_route_exist(g,n1,n2);
        System.out.printf("Route exist: %b",routeExistBFS);
               
        // traverse
        // g.traverse();
    }

    private static boolean bfs_search_route_exist(DirectedGraph g, Node n1, Node n2) {
        LinkedList<Node> queue = new LinkedList<>();
        Node start = n1;
        queue.add(start);
        Node r =null;
        System.out.printf("%s \n",start);
        while(!queue.isEmpty()){
            r=queue.pollFirst();
            r.visited=true;
            for(Node curr : r.neighbors){
                if(curr!=null && !curr.visited){
                    System.out.printf("%s - %s\n",curr,n2);
                    if(curr==n2)
                        return true;
                    queue.add(curr);
                }
            }
        }
        return false;
    }

    private static boolean dfs_search_route_exist(DirectedGraph g, Node n1, Node n2) {
        Node start = n1;
        start.visited = true;
        
        for(Node neighbor: start.neighbors){
            System.out.printf("%s - %s\n",neighbor,n2);
            if(neighbor==n2)
                return true;
            
            if(neighbor!=null && !neighbor.visited){
                //recursive
               return dfs_search_route_exist(g, neighbor, n2);
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
