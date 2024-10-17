package a_rumen.rumen_004_erchashu;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @className: TraverseNode
 * @author: Docer
 * @date: 2024/10/17 14:32
 * @Version: 1.0
 * @description: 多叉树的遍历
 */
public class TraverseNode {
    /*
     * DFS 深度优先遍历
     */
    void traverse(Node root) {
        if (root == null) {
            return;
        }
        // 前序
        for (Node child : root.children) {
            traverse(child);
        }
        // 后序
    }

    /*
     * BFS 广度优先遍历：第一种
     */
    void levelOrderTraverse(Node root) {

        if (root == null) {
            return;
        }

        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            // 访问当前节点
            Node curr = q.poll();
            System.out.println(curr.val);
            // 将子节点全部放入队列中
            for (Node child : curr.children) {
                q.offer(child);
            }
        }

    }

    /*
     * BFS 广度优先遍历：第二种（增加深度信息）
     */
    void levelOrderTraverse2(Node root) {

        if (root == null) {
            return;
        }

        Queue<Node> q = new LinkedList<>();
        q.offer(root);

        int depth = 1;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                // 访问当前节点
                Node curr = q.poll();
                System.out.println("depth: " + depth + ", val: " + curr.val);
                // 将子节点全部放入队列中
                for (Node child : curr.children) {
                    q.offer(child);
                }
            }
            depth++;
        }

    }

    /*
     * BFS 广度优先遍历：第三种（适配不同权重边）
     */
    void levelOrderTraverse3(Node root) {
        if (root == null) {
            return;
        }
        Queue<StateForNode> q = new LinkedList<>();
        q.offer(new StateForNode(root, 1));
        while (!q.isEmpty()) {
            // 访问当前节点
            StateForNode curr = q.poll();
            System.out.println("depth : " + curr.depth + " val : " + curr.node.val);
            // 将子节点全部放入队列中
            curr.node.children.forEach(
                    child -> q.offer(new StateForNode(child, curr.depth + 1))
            );
        }
    }

}
