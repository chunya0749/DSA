import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class Decor {

    public static BinaryTreeNode mkTree(List<Integer> postOrder, List<Integer> inOrder) {
        //store in-order list in map
        Map<Integer, Integer> inOrderMap = new HashMap<>();
        for (int i = 0; i < inOrder.size(); i++) {
            inOrderMap.put(inOrder.get(i), i);
        }

        //recursive
        return BuildTree(postOrder, inOrder, 0, inOrder.size() - 1, 0, postOrder.size() - 1, inOrderMap);
    }

    private static BinaryTreeNode BuildTree(List<Integer> postOrder, List<Integer> inOrder, int inStart, int inEnd, int postStart, int postEnd, Map<Integer, Integer> inOrderMap) {
        // Base case: if no elements, return null
        if (inStart > inEnd) {
            if (postStart > postEnd) {
                return null;
            }
        }

        // Root = last element in the post-order
        int rootValue = postOrder.get(postEnd);
        BinaryTreeNode root = new BinaryTreeNode(rootValue);

        // Find the root's index in the in-order traversal
        int rootIndex = inOrderMap.get(rootValue);

        //size left subtree
        int leftSize = rootIndex - inStart;

        // Recursively build the left and right subtrees
        root.left = BuildTree(postOrder, inOrder, inStart, rootIndex - 1, postStart, postStart + leftSize - 1, inOrderMap);
        root.right = BuildTree(postOrder, inOrder, rootIndex + 1, inEnd, postStart + leftSize, postEnd - 1, inOrderMap);

        return root;
    }
//    public static void printPostOrder(BinaryTreeNode root) {
//        if (root == null) return;
//        printPostOrder(root.left);
//        printPostOrder(root.right);
//        System.out.print(root.key + " ");
//    }
//
//
//    public static void printInOrder(BinaryTreeNode root) {
//        if (root == null) return;
//        printInOrder(root.left);
//        System.out.print(root.key + " ");
//        printInOrder(root.right);
//    }
//    public static void main(String[] args) {
//        List<Integer> postOrder = Arrays.asList(9, 15, 7, 20, 3);
//        List<Integer> inOrder = Arrays.asList(9, 3, 15, 20, 7);
//        BinaryTreeNode root = mkTree(postOrder, inOrder);
//        System.out.print("In-Order: ");
//        printInOrder(root);
//        System.out.print("Post-Order: ");
//        printPostOrder(root);
//    }

}

