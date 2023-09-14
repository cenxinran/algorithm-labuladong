package org.example;

import java.util.PriorityQueue;

/**
 * @BelongsProject: algorithm-labuladong
 * @BelongsPackage: org.example
 * @Author: 岑然
 * @CreateTime: 2023-09-11  17:10
 * @Description: 力扣 23. 合并 K 个升序链表 https://leetcode.cn/problems/merge-k-sorted-lists/description/
 * @Version: 1.0
 */
public class DoublePtr_03 {

    public ListNode mergeKLists(ListNode[] lists) {
        // 1. 定义虚拟头节点 dummy，拉链指针 p
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        // 2. 定义优先级队列，最小堆，用来保存 k 个链表的头节点
        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>(lists.length, (a, b) -> (a.val - b.val));
        // 3. 将 k 个链表的头结点放入最小堆
        for (ListNode head : lists) {
            if (head != null) {
                priorityQueue.add(head);
            }
        }
        // 4. 从最小堆取出最小节点放入虚拟头结点上
        while (!priorityQueue.isEmpty()) {
            // 4.1 从最小堆取出最小值
            ListNode node = priorityQueue.poll();
            // 4.2 将最小值节点接到结果链表上
            p.next = node;
            // 4.3 将取出的头结点的下一个节点存入队列
            if (node.next != null) {
                priorityQueue.add(node.next);
            }
            // 4.4 p 指针前进
            p = p.next;
        }
        // 5. 返回虚拟头结点 dummy 的 next 节点
        return dummy.next;
    }

    /* 内部 ListNode 类 */
    public class ListNode {
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
