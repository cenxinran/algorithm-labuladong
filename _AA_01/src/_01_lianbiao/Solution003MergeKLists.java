package _01_lianbiao;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @className: Solution003MergeKLists
 * @author: Docer
 * @date: 2024/10/16 15:36
 * @Version: 1.0
 * @description: 23. 合并 K 个升序链表
 */
public class Solution003MergeKLists {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        node1.next = new ListNode(4);
        node1.next.next = new ListNode(5);
        ListNode node2 = new ListNode(1);
        node2.next = new ListNode(3);
        node2.next.next = new ListNode(4);
        ListNode node3 = new ListNode(2);
        node3.next = new ListNode(6);
        ListNode[] nodes = new ListNode[]{node1, node2, node3};
        System.out.println(new Solution003MergeKLists().mergeKLists(nodes));
    }
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;

        //PriorityQueue<ListNode> pq = new PriorityQueue<>();

        // 使用自定义比较器
        PriorityQueue<ListNode> pq = new PriorityQueue<>(Comparator.comparingInt(node -> node.val));


        for (ListNode head : lists) {
            if (head != null) {
                pq.add(head);
            }
        }

        while (!pq.isEmpty()) {
            ListNode node = pq.poll();
            p.next = node;
            if (node.next != null) {
                pq.add(node.next);
            }
            p = p.next;
        }

        return dummy.next;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
