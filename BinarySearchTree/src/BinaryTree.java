import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BinaryTree {
	static Node root;
	 
    /* A function that constructs Balanced Binary Search Tree
     from a sorted array */
    Node sortedArrayToBST(List<Integer> arr, int start, int end) {
    	Collections.sort(arr);
        /* Base Case */
        if (start > end) {
            return null;
        }
 
        /* Get the middle element and make it root */
        int mid = (start + end) / 2;
        Node node = new Node((int)arr.get(mid));
        
 
        /* Recursively construct the left subtree and make it
         left child of root */
        node.left = sortedArrayToBST(arr, start, mid - 1);
 
        /* Recursively construct the right subtree and make it
         right child of root */
        node.right = sortedArrayToBST(arr, mid + 1, end);
         
        return node;
    }
 
    /* A utility function to print preorder traversal of BST */
    void preOrder(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.data + " ");
        preOrder(node.left);
        preOrder(node.right);
    }
     
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        Integer ar[]=new Integer[]{9, 2, 3, 4, 5, 6, 7};
        List<Integer> arr = Arrays.asList(ar); //new ArrayList<>();
       
        
        int n = arr.size();
        root = tree.sortedArrayToBST(arr, 0, n - 1);
        System.out.println("Preorder traversal of constructed BST");
        tree.preOrder(root);
    }
}
