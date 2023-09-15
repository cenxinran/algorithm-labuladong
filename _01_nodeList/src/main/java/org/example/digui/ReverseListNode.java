package org.example.digui;

/**
 * @BelongsProject: algorithm-labuladong
 * @BelongsPackage: org.example.digui
 * @Author: 岑然
 * @CreateTime: 2023-09-15  11:28
 * @Description: 力扣 206 反转链表 https://leetcode.cn/problems/reverse-linked-list/description/
 * @Version: 1.0
 */
public class ReverseListNode {

    /***
     * @description 反转单链表的 m 到 n 元素
     * @author 岑然
     * @return org.example.digui.ReverseListNode.ListNode
     * @param head
     * @param m
     * @param n
     * @date 2023/9/15 15:46
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        // 1. base case
        if (m == 1) {
            return reverseN(head, n);
        }
        // 2. 递归往前，一致递归到 m = 1 ，也就是 bese case 的情况
        head.next = reverseBetween(head.next, m - 1, n - 1);
        // 3. 返回 head
        return head;
    }

    ListNode successor = null;

    /***
     * @description 反转链表的前 k 个节点
     * @author 岑然
     * @return org.example.digui.ReverseListNode.ListNode
     * @param head
     * @param k
     * @date 2023/9/15 12:26
     */
    public ListNode reverseN(ListNode head, int k) {
        // 1. base case
        if (k == 1) {
            // 需要记录后继结点，用于反转完了之后，接到后继结点上
            successor = head.next;
            return head;
        }
        // 2. 递归执行
        ListNode last = reverseN(head.next, k - 1);
        // 3. 递归处理完后，处理本次方法
        head.next.next = head; // 递归逻辑
        head.next = successor; // 递归完了后需要将处理好的链表，连接上后继结点
        // 4. 返回结果
        return last;
    }

    /***
     * @description 反转整个单链表
     * @author 岑然
     * @return org.example.digui.ReverseListNode.ListNode
     * @param head
     * @date 2023/9/15 12:16
     */
    public ListNode reverseList(ListNode head) {
        // 1. 递归的 base case
        if (head == null || head.next == null) {
            // 如果节点为空，或者是单节点，那么反转后就是自身
            return head;
        }
        // 2. 执行递归
        ListNode node = reverseList(head.next);
        // 3. 将递归好了的结果，接到 head 上
        head.next.next = head;
        head.next = null;
        // 4. 返回结果
        return node;
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
