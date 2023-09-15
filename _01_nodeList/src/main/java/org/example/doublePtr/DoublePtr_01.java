package org.example.doublePtr;

import org.w3c.dom.NodeList;

/**
 * @BelongsProject: algorithm-labuladong
 * @BelongsPackage: org.example
 * @Author: 岑然
 * @CreateTime: 2023-09-11  15:38
 * @Description: 力扣 21 ：合并两个有序链表 https://leetcode.cn/problems/merge-two-sorted-lists/
 * @Version: 1.0
 */
public class DoublePtr_01 {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // 1. 定义一个头结点 p ，用来将待合并节点接上去，完成后只需要返回该节点的 next 就可以了
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        // 2. 定义双指针 p1 p2 ，用来遍历这俩链表
        ListNode p1 = list1;
        ListNode p2 = list2;
        // 3. 俩指针都不为空时，需要判断他俩节点内容大小，小的挂到 p 上面去，同时指针往后走
        while (p1 != null && p2 != null) {
            // 3.1 比较 p1 和 p2 的内容，小的挂到 p 上面去，然后指针后移
            if (p1.val > p2.val) {
                p.next = p2;
                p2 = p2.next;
            } else {
                p.next = p1;
                p1 = p1.next;
            }
            // 3.2 不管 p1 p2 是谁挂上来了， p 都要后移
            p = p.next;
        }
        // 4. 有一方链表结束了，另外一跟链表需要继续接上去
        if (p1 != null) {
            p.next = p1;
        }
        if (p2 != null) {
            p.next = p2;
        }
        // 5. 返回 p 的 next
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
