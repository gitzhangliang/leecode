import entity.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**二叉树的锯齿形层序遍历
 * @author zhangliang
 * @date 2021/7/7.
 */
public class Test103 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        List<List<Integer>> listList = new Test103().zigzagLevelOrder(root);
        for (List<Integer> list : listList) {
            for (Integer integer : list) {
                System.out.print(integer);
            }
        }
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if(root == null){
            return list;
        }
        Stack<TreeNode> c = new Stack<>();
        List<Integer> rootV  = new ArrayList<>();
        rootV.add(root.val);
        c.push(root);
        list.add(rootV);
        levelOrder(c,list,false);
        return list;
    }
    public void levelOrder(Stack<TreeNode> c, List<List<Integer>> list, boolean leftStart){
        if(c.isEmpty()){
            return;
        }
        Stack<TreeNode> copy = new Stack<>();
        List<Integer> v  = new ArrayList<>();
        TreeNode treeNode;
        while (!c.isEmpty() && (treeNode = c.pop()) != null){
            if(leftStart){
                if(treeNode.left != null){
                    v.add(treeNode.left.val);
                    copy.push(treeNode.left);
                }
                if(treeNode.right != null){
                    v.add(treeNode.right.val);
                    copy.push(treeNode.right);
                }
            }else{
                if(treeNode.right != null){
                    v.add(treeNode.right.val);
                    copy.push(treeNode.right);
                }
                if(treeNode.left != null){
                    v.add(treeNode.left.val);
                    copy.push(treeNode.left);
                }

            }
        }
        if (!v.isEmpty()) {
            list.add(v);
        }
        levelOrder(copy,list,!leftStart);
    }
}
