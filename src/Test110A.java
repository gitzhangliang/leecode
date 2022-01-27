import entity.TreeNode;

/**自底向上
 * @author zhangliang
 * @date 2021/7/8.
 */
public class Test110A {
    public boolean isBalanced(TreeNode root) {
        return height(root)>=0;

    }
    private int height(TreeNode root){
        if(root == null){
            return 0;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        if (leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        } else {
            return Math.max(leftHeight, rightHeight) + 1;
        }

    }
}
