import entity.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**广度优先搜索
 *
 * 当我们找到一个叶子节点时，直接返回这个叶子节点的深度。广度优先搜索的性质保证了最先搜索到的叶子节点的深度一定最小。
 * @author zhangliang
 * @date 2021/7/8.
 */
public class Test111A {
    class QueueNode {
        TreeNode node;
        int depth;

        public QueueNode(TreeNode node, int depth) {
            this.node = node;
            this.depth = depth;
        }
    }

    public int minDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        Queue<QueueNode> queue = new LinkedList<>();
        queue.offer(new QueueNode(root,1));
        while (!queue.isEmpty()){
            QueueNode poll = queue.poll();
            TreeNode left = poll.node.left;
            TreeNode right = poll.node.right;
            if(left == null && right == null){
                return poll.depth;
            }
            if (poll.node.left != null) {
                queue.offer(new QueueNode(poll.node.left, poll.depth + 1));
            }
            if (poll.node.right != null) {
                queue.offer(new QueueNode(poll.node.right, poll.depth + 1));
            }
        }
        return 0;
    }
}
