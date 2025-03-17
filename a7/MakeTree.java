import java.util.Arrays;

public class MakeTree {
    public static BinaryTreeNode buildBST(int[] keys){
        if(keys == null || keys.length == 0) return null; //Running time: O(1)
        Arrays.sort(keys); // Running Time: O(n log n)
        return BinaryTree(keys, 0, keys.length-1); // Running Time: O(n)

    }
    public static BinaryTreeNode BinaryTree(int[] keys, int low, int high){
        if(low > high){
            return null; // Running Time: O(1).
        }
        int mid = (low + high)/2; // Running Time: O(1)
        BinaryTreeNode root = new BinaryTreeNode(keys[mid]);  // Running Time: O(1)

        root.left = BinaryTree(keys, low, mid-1);
        root.right = BinaryTree(keys, mid+1, high);
        //recursive calls to buildBST - T(n/) for each call

        return root; //Running time : O(1)
    }


//    public static void main(String[] args) {
//        int[] keys = {7, 2, 5, 4, 1, 6, 3};
//        BinaryTreeNode root = buildBST(keys);
//        printTree(root);
//    }
//
//    public static void printTree(BinaryTreeNode node) {
//        if (node == null) return;
//        printTree(node.left);
//        System.out.print(node.key + " ");
//        printTree(node.right);
//    }
}

