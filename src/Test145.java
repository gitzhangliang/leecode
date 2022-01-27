import entity.TreeNode;

import java.util.ArrayList;
import java.util.List;

/** 二叉树的后序遍历
 * @author zhangliang
 * @date 2021/7/8.
 */
public class Test145 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        postorderTraversal(root,list);
        return list;

    }

    public void postorderTraversal(TreeNode node, List<Integer> list) {
        if(node == null){
            return;
        }
        postorderTraversal(node.left,list);
        postorderTraversal(node.right,list);
        list.add(node.val);

    }
}
