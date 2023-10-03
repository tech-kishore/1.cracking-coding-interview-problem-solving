package cci;

import java.util.LinkedList;

import cci.Graph.Node;

public class GraphExample {
	public static void main(String[] args) {
		 Graph g = new Graph(6);
	        g.addEdge(0,2);
	        g.addEdge(0,4);
	        g.addEdge(2,1);
	        g.addEdge(0,5);
	        g.addEdge(4,3);
	        g.addEdge(4,5);
	        
            // g.traverse();
	        
	        //search node
	        Node searchNode=g.getNode(3);
	        
	        // BFS Search
	        // boolean found = bfs_search(g, searchNode);
	        
	        // DFS Search
            boolean found = dfs_search(g, searchNode);
            
	        System.out.printf("\nFound %s: %b",searchNode, found);
	}
	
	private static boolean dfs_search(Graph g, Node n){
	    return false;
	}
	
	private static boolean bfs_search(Graph g, Node n) {
		Node start = g.getNode(0);
		if(start==n)
			return true;

		LinkedList<Node> q = new LinkedList<Node>();
		q.add(start);
		
		while(!q.isEmpty()) {
			Node r = q.pollFirst();
			r.visited=true;
			for(Node curr:r.neighbors) {
				if(curr!=null && !curr.visited) {
					System.out.printf("\ncurr: %s",curr);
					q.add(curr);
					if(n==curr) {
						return true;
					}
				}
			}
		}
		
		return false;
	}
}
class Graph{
    private int size;
    private Node[] nodes;
    public Graph(int v){
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
