package graph;
/*
 *  #4.5
 */
public class ValidateBST {
    public static void main(String[] args) {
        Node root = NewTree.generate();

        // Print tree in console
        NewTree.traverse(root);

        boolean res = checkBST(root);
        System.out.printf("Is given tree a binary search tree: %b",res);
        
    }

    private static boolean checkBST(Node root) {
        return checkBST(root,null,null);
    }

    // Understand logic ......
    private static boolean checkBST(Node parent, Integer min, Integer max) {
        //base condition
        if(parent==null)
            return true;

        // For left child
        if(min!=null && min > parent.val)
            return false;
        else if(!checkBST(parent.left, null, parent.val))
            return false;
      
        // For right child
        if(max!=null && max < parent.val)
            return false;
        else if(!checkBST(parent.right, parent.val, null))
            return false;

        return true;
    }
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

    // BST
    // /*
    Node root = new Node(8);
		Node n2 = new Node(4);
		Node n3 = new Node(10);
		Node n4 = new Node(2);
		Node n5 = new Node(6);
		// Node n6 = new Node(0);
		Node n7 = new Node(20);

    root.left=n2;
		root.right=n3;
		
		n2.left=n4;
		n2.right=n5;
		
		// n3.left=n6;
		n3.right=n7;
    // */
        
    // Non BST
    /*
    Node root = new Node(8);
		Node n2 = new Node(41);
		Node n3 = new Node(10);
		Node n4 = new Node(2);
		Node n5 = new Node(6);
		// Node n6 = new Node(0);
		Node n7 = new Node(20);

    root.left=n2;
		root.right=n3;
		n2.left=n4;
		n2.right=n5;
		n3.right=n7;
    */

    // Non BST - 2
    /* Test case fails gor this >>> work on this...
        Node root = new Node(20);
		Node n2 = new Node(10);
		Node n3 = new Node(30);
		// Node n4 = new Node(2);
		Node n5 = new Node(25);
		// Node n6 = new Node(0);
		// Node n7 = new Node(20);

    root.left=n2;
		root.right=n3;
		n2.right=n5;
    */

		return root;
    }
}
