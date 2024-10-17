package a_rumen.rumen_004_erchashu;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @className: TraverseTreeNode
 * @author: Docer
 * @date: 2024/10/17 11:33
 * @Version: 1.0
 * @description: 遍历二叉树
 */
public class TraverseTreeNode {

    // 二叉树 DFS 遍历的基本框架
    public void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        traverse(root.left);
        traverse(root.right);
    }

    /*
     * 层序遍历，也叫广度优先遍历，也叫 BFS。
     * 第一种：
     * 这种写法最大的优势就是简单。每次把队头元素拿出来，然后把它的左右子节点加入队列，就完事了。
     * 但是这种写法的缺点是，无法知道当前节点在第几层。
     * 知道节点的层数是个常见的需求，比方说让你收集每一层的节点，或者计算二叉树的最小深度等等。
     * 所以这种写法虽然简单，但用的不多，下面介绍的写法会更常见一些。
     */
    public void levelOrderTraverse(TreeNode root) {
        if (root == null) {
            return;
        }
        // BFS 需要有一个队列来辅助遍历
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            // 访问当前节点x
            TreeNode curr = q.poll();
            System.out.println(curr.val);
            // 当前节点的左右子节点入队
            if (curr.left != null) {
                q.offer(curr.left);
            }
            if (curr.right != null) {
                q.offer(curr.right);
            }
        }
    }


    /*
     * 第二种：增加了当前遍历的节点所在的层数
     */
    public void levelOrderTraverse2(TreeNode root) {
        if (root == null) {
            return;
        }
        // BFS 需要有一个队列来辅助遍历
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        // 使用一个常量记录当前遍历的层数
        int depth = 1;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                // 访问当前节点x ，同时知道他所在的层数
                TreeNode curr = q.poll();
                System.out.println("depth = " + depth + ", val = " + curr.val);
                // 当前节点的左右子节点入队
                if (curr.left != null) {
                    q.offer(curr.left);
                }
                if (curr.right != null) {
                    q.offer(curr.right);
                }
            }
            // 层数加一
            depth++;
        }
    }

    /*
     * 第三种：增加路径权重参数
     */
    public void levelOrderTraverse3(TreeNode root) {
        if (root == null) {
            return;
        }

        Queue<StateForTreeNode> q = new LinkedList<>();
        q.offer(new StateForTreeNode(root, 1));
        while (!q.isEmpty()) {

            StateForTreeNode cur = q.poll();
            System.out.println("depth = " + cur.depth + ", val = " + cur.node.val);

            if (cur.node.left != null) {
                q.offer(new StateForTreeNode(cur.node.left, cur.depth + 1));
            }
            if (cur.node.right != null) {
                q.offer(new StateForTreeNode(cur.node.right, cur.depth + 1));
            }

        }
    }
}
