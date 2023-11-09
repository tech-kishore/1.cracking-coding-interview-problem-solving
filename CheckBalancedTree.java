package graph;

/**
 * #4.4
 * CheckBalancedTree
 */
public class CheckBalancedTree {

    public static void main(String[] args) {

        Node root = NewTree.generate();

        // NewTree.traverse(root);

        boolean res = isTreeBalanced(root);
        System.out.printf("Is tree balanced? %b",res);
        
    }

    private static boolean isTreeBalanced(Node root) {
        return getHeight(root)!=Integer.MIN_VALUE;
    }



    private static int getHeight(Node node) {
        System.out.printf("P Node:%s \n", node);
        if(node==null)
            return -1;
        
        int leftHeight = getHeight(node.left);
        System.out.printf("Node-%s > left: %d\n",node,leftHeight);

        if(leftHeight==Integer.MIN_VALUE)
            return Integer.MIN_VALUE;
        
        int rightHeight = getHeight(node.right);
        System.out.printf("Node-%s > right: %d\n",node, rightHeight);

        if(rightHeight==Integer.MIN_VALUE)
            return Integer.MIN_VALUE;

        int heightDiff= leftHeight-rightHeight;
        if(Math.abs(heightDiff)>1)
            return Integer.MIN_VALUE;

        System.out.println("==============================");
        return Math.max(leftHeight, rightHeight)+1;
    }



    class NewTree{

        /**
         * Travese and prints the tree in console
         * Pre-Order Traversal implemented
         * 
         * @param root root element of the given tree 
        */
        public static void traverse(Node root){
            if(root==null)
                return;
            
            System.out.printf("%s\n",root);
            
            traverse(root.left);
            traverse(root.right);
        }
    
        public static Node generate(){
    
            // BT
            Node root = new Node(1);
            Node n2 = new Node(2);
            Node n3 = new Node(3);
            Node n4 = new Node(4);
            Node n5 = new Node(5);
            Node n6 = new Node(6);
            Node n7 = new Node(7);
            Node n8 = new Node(8);
            Node n9 = new Node(9);
            Node n10 = new Node(10);

                
            root.left=n2;
            root.right=n3;
            
            n2.left=n4;
            n2.right=n5;
            
            n3.left=n6;
            n3.right=n7;

            n5.right=n8;

            n8.left=n9;
            n8.right=n10;
            
            return root;
        }
    }
}
