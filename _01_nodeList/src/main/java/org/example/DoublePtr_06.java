package org.example;

/**
 * @BelongsProject: algorithm-labuladong
 * @BelongsPackage: org.example
 * @Author: 岑然
 * @CreateTime: 2023-09-14  16:19
 * @Description: 力扣 142. 环形链表 II https://leetcode.cn/problems/linked-list-cycle-ii/description/
 * @Version: 1.0
 */
public class DoublePtr_06 {

    public ListNode detectCycle(ListNode head) {
        // 1. 定义快慢指针
        ListNode slow = head;
        ListNode fast = head;
        // 2. 双指针一直往前走，每次走动都需要判断一次是否相遇了，相遇说明有环
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }
        // 3. 在找环入口之前，我们需要判断下，代码执行到这里，到底是因为快慢指针走完了链表，还是因为他们相遇了 break 出来的
        if (fast == null || fast.next == null) {
            return null;
        }
        // 4. 相遇后就停止循环，让 slow 从头重新走，再次跟 fast（此时 fast 速度变成跟 slow 一致） 相遇的点就是环的入口
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        // 5. 能走到这里说明一定是有环的，而环的入口就是此时再次相遇的地方，直接返回即可
        return slow;
    }

    /* 内部 ListNode 类 */
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

}
