import entity.TreeNode;

/**二叉树的最大深度
 *
 * 给定一个二叉树，找出其最大深度。
 *二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 * @author zhangliang
 * @date 2021/7/7.
 */
public class Test104 {
    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left,right)+1;

    }
}
