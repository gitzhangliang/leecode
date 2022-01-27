import entity.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**二叉树的层序遍历
 * @author zhangliang
 * @date 2021/7/7.
 */
public class Test102 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        List<List<Integer>> listList = new Test102().levelOrder(root);
        for (List<Integer> list : listList) {

        }
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if(root == null){
            return list;
        }
        List<TreeNode> c = new ArrayList<>();
        List<Integer> rootV  = new ArrayList<>();
        rootV.add(root.val);
        c.add(root);
        list.add(rootV);
        levelOrder(c,list);
        return list;
    }

    public void levelOrder(List<TreeNode> c,List<List<Integer>> list){
        if(c.isEmpty()){
            return;
        }
        List<TreeNode> copy = new ArrayList<>(c);
        c.clear();
        List<Integer> v  = new ArrayList<>();
        for (TreeNode treeNode : copy) {
            if(treeNode.left != null){
                v.add(treeNode.left.val);
                c.add(treeNode.left);
            }
            if(treeNode.right != null){
                v.add(treeNode.right.val);
                c.add(treeNode.right);
            }
        }
        if (!v.isEmpty()) {
            list.add(v);
        }
        levelOrder(c,list);
    }
}
