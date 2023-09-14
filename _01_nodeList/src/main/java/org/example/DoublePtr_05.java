package org.example;

/**
 * @BelongsProject: algorithm-labuladong
 * @BelongsPackage: org.example
 * @Author: 岑然
 * @CreateTime: 2023-09-14  16:08
 * @Description: 力扣 876. 链表的中间结点 https://leetcode.cn/problems/middle-of-the-linked-list/description/
 * @Version: 1.0
 */
public class DoublePtr_05 {

    /***
     * @description 给定链表头结点 head 返回其中点
     * @author 岑然
     * @return org.example.DoublePtr_05.ListNode
     * @param head
     * @date 2023/9/14 16:10
     */
    public ListNode middleNode(ListNode head) {
        // 1. 定义快慢指针
        ListNode slow = head;
        ListNode fast = head;
        // 2. 当快指针走完，则慢指针指向链表中点
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // 3. 返回慢指针即可（如果链表长度为偶数，则慢指针指向的是靠右的中点）
        return slow;
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
