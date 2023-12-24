

/**
 * Ex #4.8
 * Design an algorithm to find the first common anchestor of two nodes in a binary tree.
 * Constraint - Avoid storing additional nodes in a datastructure.
 * Note: This is not a BST 
 * 
 * Implementation: Without using additional data-structure to store nodes
 * ----------------------------------------------------------------------
 * Algorithm designed :-
 * =====================
 *  [1] Find depth of each node
 *  [2] Find Deeper & Shallow node
 *  [3] Make both nodes equal in depths by moving the deeper node up towards its parent & anchestors
 *      Bring both nodes at equal height
 *  [4] Loop Thru
 *          - Move both nodes up towards respective parents
 *          - if both have the same parent; result found!
 * 
 * @author Kishore
 */
public class FirstCommonAnchestorWithNoAddlDataStructureNonBST {

    // For testing only declared here
    static Node i1 = null;
    static Node i2 = null;

    public static void main(String[] args) {

        Node root = buildTree();

        Node fca = findFCA(root,i1,i2);

        System.out.printf("\nLCA of %s & %s :    %s\n\n",i1.val,i2.val,fca.val);

        // traverse(root);
    }

    private static Node findFCA(Node root,
            Node node1, Node node2) {
        
        int delta = depth(node1)-depth(node2);
        
        Node shallow=delta>0?node2:node1;
        Node deep=delta>0?node1:node2;

        // Adjust depth and bring both to same height
        deep = adjustDepth(delta,deep);

        while(shallow!=deep){
            if(shallow.parent==deep.parent)
                return shallow.parent;
            
            shallow = shallow.parent;
            deep = deep.parent;
        }
        
        return null;
    }

    private static Node adjustDepth(int delta, Node node) {
        while(delta>0){
            node=node.parent;
            delta--;
        }
        return node;
    }

    private static int depth(Node node) {
        int depth = 0;
        
        while(node!=null){
            depth++;
            node=node.parent;
        }

        return depth;
    }

    private static Node buildTree(){

        Node root= new Node(1);
        Node n2=new Node(2);
        Node n3=new Node(3);
        Node n4=new Node(4);
        Node n5=new Node(5);
        Node n6=new Node(6);
        Node n7=new Node(7);

        // set for testing
        i1=n4;
        i2=n7;
        //===============
        
        root.left=n2;
        root.right=n3;

        n2.left=n4;
        n2.right=n5;
        n2.parent=root;

        n3.left=n6;
        n3.right=n7;
        n3.parent=root;

        n4.parent=n2;
        n5.parent=n2;

        n6.parent=n3;
        n7.parent=n3;

        return root;
    }

    /**
     * Travese and prints the tree in console
     * Pre-Order Traversal implemented
     * 
     * @param root root element of the given tree 
    */
    private static void traverse(Node node){
        if(node==null)
        return;

        if(node.parent==null){
            System.out.printf("%s \n",node.val);
        }
        
        int lVal=node.left==null?-1:node.left.val;
        int rVal=node.right==null?-1:node.right.val;

		System.out.printf("%s %s\n",lVal,rVal);
		
		traverse(node.left);
		traverse(node.right);
    }


    static class Node{
        int val;
        Node left;
        Node right;
        Node parent;

        Node(int v){
            this.val=v;
        }
    }
}