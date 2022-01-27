import entity.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author zhangliang
 * @date 2021/7/2.
 */
public class Test95A {
    public static void main(String[] args) {
        List<TreeNode> treeNodes = new Test95A().generateTrees(3);
        for (TreeNode treeNode : treeNodes) {
            System.out.print(treeNode.val);
            System.out.print(treeNode.left == null?null:treeNode.left.val);
            System.out.print(treeNode.right == null?null:treeNode.right.val);
            System.out.println();
        }
    }
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new LinkedList<TreeNode>();
        }
        return generateTrees(1, n);
    }

    public List<TreeNode> generateTrees(int start, int end) {
        List<TreeNode> allTrees = new LinkedList<TreeNode>();
        if (start > end) {
            allTrees.add(null);
            return allTrees;
        }

        // 枚举可行根节点
        for (int i = start; i <= end; i++) {
            // 获得所有可行的左子树集合
            List<TreeNode> leftTrees = generateTrees(start, i - 1);

            // 获得所有可行的右子树集合
            List<TreeNode> rightTrees = generateTrees(i + 1, end);

            // 从左子树集合中选出一棵左子树，从右子树集合中选出一棵右子树，拼接到根节点上
            for (TreeNode left : leftTrees) {
                for (TreeNode right : rightTrees) {
                    TreeNode currTree = new TreeNode(i);
                    currTree.left = left;
                    currTree.right = right;
                    allTrees.add(currTree);
                }
            }
        }
        return allTrees;
    }
}
