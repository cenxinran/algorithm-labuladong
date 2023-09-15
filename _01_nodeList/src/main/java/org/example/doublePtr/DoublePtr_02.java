package org.example.doublePtr;

/**
 * @BelongsProject: algorithm-labuladong
 * @BelongsPackage: org.example
 * @Author: 岑然
 * @CreateTime: 2023-09-11  16:10
 * @Description: 力扣 86. 分隔链表 https://leetcode.cn/problems/partition-list/
 * @Version: 1.0
 */
public class DoublePtr_02 {

    public ListNode partition(ListNode head, int x) {
        // 1. 定义两个虚拟头结点 dummy1 和 dummy2 ，目的是我们要新建 2 哥链表，分表保存大于 x 和小于 x 的节点
        ListNode dummy1 = new ListNode(-1);
        ListNode dummy2 = new ListNode(-1);
        // 2. 定义拉链指针 p ，拉链边子指针 p1 和 p2
        ListNode p = head;
        ListNode p1 = dummy1;
        ListNode p2 = dummy2;
        // 3. 对 p 往后遍历，大于小于 x 的节点存储到对应的链表上
        while (p != null) {
            if (p.val >= x) {
                p2.next = p;
                p2 = p2.next;
            } else {
                p1.next = p;
                p1 = p1.next;
            }
            // 4. 存储完一个节点，需要将 p 指针往后移动（但是注意，千万不能直接 p = p.next; 因为这样会产生环，而是需要将 p 后面的每个节点全部解开）
            ListNode temp = p.next;
            p.next = null;
            p = temp;
        }
        // 5. 分隔完毕，将新链表 p2 接到新链表 p1 的后面
        p1.next = dummy2.next;
        // 6. 返回最终结果 dummy1.next
        return dummy1.next;
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
