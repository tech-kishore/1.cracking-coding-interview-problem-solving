// Online Java Compiler
// Use this editor to write, compile and run your Java code online
class GraphTraversal {
    public static void main(String[] args) {
        int len=6;
        Graph graph = createGraph(len);
        // DFS(graph,0,len);
        Graph.Node start = graph.getVertex(0);
        dfs(graph,start);
    }
    
     private static void dfs(Graph g, Graph.Node root){
        if(root==null)
            return;
        root.visited = true;
        for(Graph.Node n: root.neighbors){
            if(n!=null && n.visited==false){
                System.out.printf("> Pnode = %s \n",n);
                dfs(g,n);
            }
        }
        // Above code lists child nodes
        
        //******** WHAT ABOUT NEXT PARENT NODES -- WORK HERE *********
        // dfs(g, g.getVertex(idx+1),idx+1);
     }
    
    private static void DFS1(Graph g,int idx,int len){
        if(idx>=len)
            return;
        Graph.Node start = g.getVertex(idx);
        System.out.printf("> Pnode = %s \n",start);
        search(start);
        DFS1(g,idx++,len);
    }
    
    private static void search(Graph.Node start){
        if(start==null) 
            return;
        // visit(start);
        start.visited=true;

        for(Graph.Node n:start.neighbors){
            if(n==null){
                continue;
            }
            if(n.visited==false){
                System.out.printf(" \t\t - {Cnode = %s} \n",n);
                search(n);
            }
        }
        
    }
    
    private static Graph createGraph(int len){
        Graph g = new Graph(len);
        
        Graph.Node n1 = g.new Node("n1");
        Graph.Node n2 = g.new Node("n2");
        Graph.Node n3 = g.new Node("n3");
        Graph.Node n4 = g.new Node("n4");
        Graph.Node n5 = g.new Node("n5");
        
        
        g.addVertex(n1);
        g.addVertex(n2);
        g.addVertex(n3);
        g.addVertex(n4);
        g.addVertex(n5);
        
        n1.setNeighbor(n2);
        n1.setNeighbor(n3);
        
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
        
        public String toString(){
            return name;
        }
        
    }
    
    public void addVertex(Node n){
        nodes[vertexNo++] = n;
    }
    
    public Node getVertex(int idx){
        return nodes[idx];
    }
    
}
