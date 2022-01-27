import entity.TreeNode;

/**
 * @author zhangliang
 * @date 2021/7/2.
 */
public class Test100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null){
            return true;
        }
        if(p == null || q == null){
            return false;
        }

        if (p.val != q.val){
            return false;
        }
        return isSameTree(p.left,q.left)&&isSameTree(p.right,q.right);
    }
}
