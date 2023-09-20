// Online Java Compiler
// Use this editor to write, compile and run your Java code online
class GraphTraversal {
    public static void main(String[] args) {
        Graph graph = createGraph();
        DFS(graph);
    }
    
    private static void DFS(Graph g){
        Graph.Node start = g.getVertex(0);
        search(start);
    }
    
    private static void search(Graph.Node start){
        System.out.println(start.visited);
        if(start==null) 
            return;
        // visit(start);
        start.visited=true;
        for(Graph.Node n:start.neighbors){
            if(n.visited==false){
                System.out.println(n);
                search(n);
            }
        }
        
    }
    
    private static Graph createGraph(){
        Graph g = new Graph(6);
        
        Graph.Node n1 = g.new Node("n1");
        Graph.Node n2 = g.new Node("n2");
        Graph.Node n3 = g.new Node("n3");
        Graph.Node n4 = g.new Node("n4");
        Graph.Node n5 = g.new Node("n5");
        
        n1.setNeighbor(n2);
        n1.setNeighbor(n3);
        
        g.addVertex(n1);
        g.addVertex(n2);
        g.addVertex(n3);
        g.addVertex(n4);
        g.addVertex(n5);
        return g;
    }
}

class Graph{
    private Node [] nodes;
    private int size;
    private int vertexNo;
    Graph(int size){
        this.size=size;
        nodes = new Node[size];
    }
    
    class Node{
        public String name;
        public Node[] neighbors = new Node[size];
        private int last;
        public boolean visited=false;
        Node(String n){
            this.name = n;
        }
        public void setNeighbor(Node n){
            neighbors[last++] = n;
        }
        
        
    }
    
    public void addVertex(Node n){
        nodes[vertexNo++] = n;
    }
    
    public Node getVertex(int idx){
        return nodes[idx];
    }
    
}
