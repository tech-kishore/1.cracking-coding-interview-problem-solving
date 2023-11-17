package graph;

public class MinimalBST {
    public static void main(String[] args) {

        String[] arr = {"10","11","12","13","14","15","16"};
        int len = arr.length;

        Node node = bst(arr,0,len-1);

        System.out.println(node);
    }

    private static Node bst(String[] arr, int start, int end) {
        if(end<start)
            return null;

        int mid = (start+end)/2;
        
        Node node = new Node(arr[mid]);
        node.left = bst(arr,start,mid-1);
        node.right = bst(arr,mid+1,end);

        return node;
    }

    private static class Node{
        private String name;
        private Node left;
        private Node right;

        Node(String name){
            this.name=name;
        }

        public String toString(){
            return "["+ name+"; l: "+ left+"; r: "+right+ "]";
        }
    }
}
