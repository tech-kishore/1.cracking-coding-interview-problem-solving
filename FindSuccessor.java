package graph;

import java.util.HashMap;
import java.util.Map;

/**
 * Ex #4.6
 * Find in-order successor of a given node in a BST
 * 
 * 4 conditioned handled
 *  > 1. if right sub-tree exists
 *          1.1 find left most node fo right subtree
 *  > 2. if right sub-tree does not exists 
            2.1 if the node itself is the left subtree of the parent
            2.2 if the parent(going up) is the left subtree of the ancestor
*/
public class FindSuccessor {
    public static void main(String[] args) {
        Node root = NewTree.generate();
        NewTree.traverse(root);

        Node n = NewTree.getNode(20);
        
        Node successor = getSuccessor(root,n);
        System.out.printf("Successor of %s is %s",n,successor);
    }
    
    
    private static Node getSuccessor(Node root,Node n) {

        if(n.right!=null) // if right sub-tree exists
            return leftMost(n.right);
        else{ // if right sub-tree does not exists
            Node parent = n.parent;
            
            // if the node itself is the left subtree of the parent
            if(parent.left == n)
                return parent;

            while(parent!=root){
                Node anchestor = parent.parent;
                if(anchestor.left == parent) //if the parent is the left subtree of the ancestor
                    return anchestor;
                parent = anchestor;
            }
        }

        return null;
    }

    private static Node leftMost(Node node) {
        if(node.left == null)
            return node;
        return leftMost(node.left);
    }

    class NewTree{

        // for testing only
        private static Map<Object,Node> nodes = new HashMap<>();

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

        // for testing only
        public static Node getNode(int val){
            return nodes.get(String.valueOf(val));
        }
    
        public static Node generate(){
    
            // BST
            Node root = new Node(20);
            Node n2 = new Node(8);
            Node n3 = new Node(22);
            Node n4 = new Node(4);
            Node n5 = new Node(12);
            Node n6 = new Node(10);
            Node n7 = new Node(14);

            nodes.put(root.toString(), root);
            nodes.put(n2.toString(), n2);
            nodes.put(n3.toString(), n3);
            nodes.put(n4.toString(), n4);    
            nodes.put(n5.toString(), n5);
            nodes.put(n6.toString(), n6);
            nodes.put(n7.toString(), n7);

            root.left=n2;
            root.right=n3;

            n2.left=n4;
            n2.right=n5;

            n5.left=n6;
            n5.right=n7;

            // set parents (Optional)
            n2.parent=root;
            n3.parent=root;
            n4.parent=n2;
            n5.parent=n2;
            n6.parent=n5;
            n7.parent=n5;
            
            return root;
        }
    }
}
