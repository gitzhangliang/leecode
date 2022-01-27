import entity.TreeNode;

import java.util.ArrayList;
import java.util.List;

/** 二叉树的前序遍历
 * @author zhangliang
 * @date 2021/7/8.
 */
public class Test144 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        preorderTraversal(root,list);
        return list;

    }

    public void preorderTraversal(TreeNode node, List<Integer> list) {
        if(node == null){
            return;
        }
        list.add(node.val);
        preorderTraversal(node.left,list);
        preorderTraversal(node.right,list);

    }
}
