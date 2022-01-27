import entity.TreeNode;

/**对称二叉树
 * @author zhangliang
 * @date 2021/7/2.
 */
public class Test101 {
    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }
        return isSymmetric(root.left,root.right);

    }
    public boolean isSymmetric(TreeNode left,TreeNode right) {

        if(left == null && right== null){
            return true;
        }
        if(left == null || right == null){
            return false;
        }
        if (left.val == right.val) {
            return isSymmetric(left.left,right.right)&&isSymmetric(left.right,right.left);
        }
        return false;
    }
}
