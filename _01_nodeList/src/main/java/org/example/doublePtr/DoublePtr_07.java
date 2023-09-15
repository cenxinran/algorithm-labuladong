package org.example.doublePtr;

/**
 * @BelongsProject: algorithm-labuladong
 * @BelongsPackage: org.example
 * @Author: 岑然
 * @CreateTime: 2023-09-14  16:36
 * @Description: 力扣 160. 相交链表 https://leetcode.cn/problems/intersection-of-two-linked-lists/description/
 * @Version: 1.0
 */
public class DoublePtr_07 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // 1. 定义两个指针 p1 和 p2，用来双遍历
        ListNode p1 = headA;
        ListNode p2 = headB;

        while (p1 != p2) {
            // 2. p1 遍历 headA 之后就遍历 headB
            if (p1 == null) {
                p1 = headB;
            } else {
                p1 = p1.next;
            }
            // 3. p2 遍历 headB 之后就遍历 headA
            if (p2 == null) {
                p2 = headA;
            } else {
                p2 = p2.next;
            }
        }

        // 4. 当 p1 和 p2 相遇，相遇点就是 headA 和 headB 的相交节点
        // 5. 可以直接返回相交点，因为就算他俩没有相交，那指针走完后就会指向 null ，那么就算返回 p1(p2) 也会是 null ，符合题意
        return p1;
    }


    /* 内部 ListNode 类 */
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

}
