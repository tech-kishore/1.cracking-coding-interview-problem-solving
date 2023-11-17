package cci;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * CCI - #4.3 
 * <strong>List of Depths: </strong> Given a binary tree, design an algorithm which
 * creates a linked list of all the nodes at each depth(e.g., if you have a tree with depth D,
 * you'll have D linked lists
 * 
 */
public class ListOfDepths {
	
	public static void main(String[] args) {
		Node root = createBinaryTree();
		
		// traverse pre-porder and print 
		/*
		 * System.out.println("PRE-ORDER TRAVERSAL ..."); 
		 * traversePreOrder(root);
		 */
		
		// find list of depths
		List<LinkedList<Node>> list = new ArrayList<>();
		listOfdepths(root,list,0);
		
		System.out.println("LIST OF DEPTHS ...\n");
		
		for(LinkedList<Node> l: list) {
			System.out.printf("Level:%d \n\n",list.indexOf(l)+1);
			
			Iterator<Node> it= l.iterator();
			while(it.hasNext()) {
				System.out.printf("%s\t",it.next());
			}
			System.out.println("\n");
		}
		
		
	}
	
	/**
	 * Creates a list of linked list of nodes at each level
	 * 
	 * Pre-Order Traversal is implemented
	 * 
	 * @param node parent node
	 * @param list List of the linked lists to be added at each level of the BT
	 * @param i current level of the BT
	 * **/
	private static void listOfdepths(Node node, List<LinkedList<Node>> list, int i) {
		//base condition
		if(node==null)
			return;
		
		
		LinkedList<Node> curr = null;
		try {
			curr = list.get(i);
		}catch (IndexOutOfBoundsException e) {
			curr = new LinkedList<Node>();
			list.add(i,curr);
		}
		
		curr.add(node);
		
		// set level to next
		i=i+1;
		
		listOfdepths(node.left, list, i);
		listOfdepths(node.right, list, i);
		
	}

	/**
	 * P - Parent node 
	 * L - Left child node
	 * R - Right child node
	 * 
	 * Traverses BT in Pre-Order
	 * i.e., P -> L -> R
	 * **/
	private static void traversePreOrder(Node node) {
		if(node==null)
			return;
		
		System.out.printf("%s\n",node);
		
		traversePreOrder(node.left);
		traversePreOrder(node.right);
	}

	/**
	 * Initialize - create default input binary tree
	 * Returns root node of the binary tree
	 * 
	 * @return the root node of the binary tree
	 **/
	private static Node createBinaryTree() {
		/*
		Node root = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		Node n4 = new Node(4);
		Node n5 = new Node(5);
		Node n6 = new Node(6);
		Node n7 = new Node(7);
		*/
		
		Node root = new Node(16);
		Node n2 = new Node(21);
		Node n3 = new Node(13);
		Node n4 = new Node(142);
		Node n5 = new Node(235);
		Node n6 = new Node(65);
		Node n7 = new Node(57);
		
		
		root.left=n2;
		root.right=n3;
		
		n2.left=n4;
		n2.right=n5;
		
		n3.left=n6;
		n3.right=n7;
		
		return root;
	}

	/**
	 * Inner Node class
	 * */
	static class Node{
		int data;
		Node left;
		Node right;
		
		public Node(int data) {
			super();
			this.data = data;
		}
		
		@Override
		public String toString() {
			return String.valueOf(data);
		}
		
	}

}
