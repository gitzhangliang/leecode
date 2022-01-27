import entity.TreeNode;

/**二叉树的最小深度
 *
 * 给定一个二叉树，找出其最小深度。
 *
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 * @author zhangliang
 * @date 2021/7/8.
 */
public class Test111 {
    public int minDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        int leftHeight = minDepth(root.left);
        int rightHeight = minDepth(root.right);
        if(leftHeight == 0){
            return rightHeight+1;
        }
        if(rightHeight == 0){
            return leftHeight+1;
        }
        return Math.min(leftHeight, rightHeight) + 1;
    }

}
