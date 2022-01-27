import entity.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**不同的二叉搜索树 II
 * @author zhangliang
 * @date 2021/7/2.
 */
public class Test95 {
    public List<TreeNode> generateTrees(int n) {
        LinkedList<Integer> track = new LinkedList<>();
        return backtrack(1,n);
    }
    public List<TreeNode> backtrack(int left,int right) {
        List<TreeNode> treeNodes = new LinkedList<TreeNode>();
        if (left > right) {
            treeNodes.add(null);
            return treeNodes;
        }
        for (int i = left; i <=right; i++) {
            List<TreeNode> lefts = backtrack(left,i-1);
            List<TreeNode> rights = backtrack(i+1,right);
            for (TreeNode leftNode : lefts) {
                for (TreeNode rightNode : rights) {
                    TreeNode currTree = new TreeNode(i);
                    currTree.left = leftNode;
                    currTree.right = rightNode;
                    treeNodes.add(currTree);
                }
            }
        }
        return treeNodes;
    }
}
