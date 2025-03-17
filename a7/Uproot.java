import java.util.HashMap;
import java.util.Map;

public class Uproot {

    public static void ToParentdMap(HashMap<Integer, Integer> map, Integer parent, BinaryTreeNode child) {
        if (child != null) {
            map.put(child.key, parent);
            ToParentdMap(map, child.key, child.left);
            ToParentdMap(map, child.key, child.right);
        }
    }

    // Task1: Convert binary tree to parent map
    public static HashMap<Integer, Integer> treeToParentMap(BinaryTreeNode T) {
        HashMap<Integer, Integer> TheParMap = new HashMap<>();
        ToParentdMap(TheParMap, null, T);
        return TheParMap;
    }

    // Task2: Convert parent map back to binary tree
    public static BinaryTreeNode parentMapToTree(Map<Integer, Integer> map) {
        if (map == null || map.isEmpty()) {
            return null;
        }

        Map<Integer, BinaryTreeNode> BinarynodeMap = new HashMap<>();
        BinaryTreeNode root = null;

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Integer Nodekey = entry.getKey();
            Integer parentkey = entry.getValue();

            BinaryTreeNode node = BinarynodeMap.getOrDefault(Nodekey, new BinaryTreeNode(Nodekey));
            BinarynodeMap.put(Nodekey, node);

            if (parentkey == null) {
                root = node; // Root node has no parent
            } else {
                BinaryTreeNode parent = BinarynodeMap.getOrDefault(parentkey, new BinaryTreeNode(parentkey));
                if (parent.left == null) {
                    parent.left = node;
                } else if (parent.right == null) {
                    parent.right = node;
                }
                BinarynodeMap.put(parentkey, parent);
            }
        }

        return root;
    }

//    public static void main(String[] args) {
//        BinaryTreeNode root = new BinaryTreeNode(
//                new BinaryTreeNode(new BinaryTreeNode(14), 20, null),
//                1,
//                new BinaryTreeNode(new BinaryTreeNode(2), 9, new BinaryTreeNode(18))
//        );
//
//        HashMap<Integer, Integer> parentMap = treeToParentMap(root);
//        System.out.println("Parent Mapping:");
//        for (Map.Entry<Integer, Integer> entry : parentMap.entrySet()) {
//            System.out.println(entry.getKey() + " -> " + entry.getValue());
//        }
//
//        BinaryTreeNode newRoot = parentMapToTree(parentMap);
//        printTree(newRoot);
//    }
//    public static void printTree(BinaryTreeNode node) {
//        if (node == null) return;
//        printTree(node.left);
//        System.out.print(node.key + " ");
//        printTree(node.right);
//    }
}
