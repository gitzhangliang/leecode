import entity.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**二叉树的中序遍历
 * @author zhangliang
 * @date 2021/7/1.
 */
public class Test94 {
    public static void main(String[] args) {

    }
    public List<Integer> inorderTraversal(TreeNode root) {
           List<Integer> list = new ArrayList<>();
           inorderTraversal(root,list);
           return list;
    }
    public void inorderTraversal(TreeNode node,List<Integer> list) {
        if(node == null){
            return;
        }
        inorderTraversal(node.left,list);
        list.add(node.val);
        inorderTraversal(node.right,list);

    }
}
