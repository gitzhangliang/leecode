import entity.TreeNode;

/**平衡二叉树
 *
 * 给定一个二叉树，判断它是否是高度平衡的二叉树
 * 本题中，一棵高度平衡二叉树定义为：
 *
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。
 *
 * 自顶向下
 * @author zhangliang
 * @date 2021/7/8.
 */
public class Test110 {
    public boolean isBalanced(TreeNode root) {
        if(root == null){
            return true;
        }
        return Math.abs(height(root.left) - height(root.right)) <=1 && isBalanced(root.left) && isBalanced(root.right);

    }

    private int height(TreeNode node){
        if(node == null){
            return 0;
        }
        return Math.max(height(node.left),height(node.right))+1;
    }
}
