package a_rumen.rumen_004_erchashu;

/**
 * @className: State
 * @author: Docer
 * @date: 2024/10/17 14:20
 * @Version: 1.0
 * @description: bfs 遍历的节点的状态：其中维护了当前节点的路径权重和-----二叉树
 */
public class StateForTreeNode {
    TreeNode node;
    int depth;

    public StateForTreeNode(TreeNode node, int depth) {
        this.node = node;
        this.depth = depth;
    }
}
