package main.java.com.cenran.rumen_004_erchashu;

/**
 * @className: StateForNode
 * @author: Docer
 * @date: 2024/10/17 15:04
 * @Version: 1.0
 * @description: bfs 遍历的节点的状态：其中维护了当前节点的路径权重和-----多叉树
 */
public class StateForNode {
    Node node;
    int depth;

    public StateForNode(Node node, int depth) {
        this.node = node;
        this.depth = depth;
    }
}
