package _01_lianbiao;

/**
 * @className: Solution006DetectCycle
 * @author: Docer
 * @date: 2024/10/17 8:09
 * @Version: 1.0
 * @description: 142. 环形链表 II
 */
public class Solution006DetectCycle {
    public ListNode detectCycle(ListNode head) {
        // 初始化快慢指针指向头节点
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }
        // 判断是否为环形链表，快慢指针不相遇，则不是环形链表
        if (fast == null || fast.next == null) {
            return null;
        }
        // 快慢指针相遇了，说明有环
        // 快指针回到头节点，慢指针继续走，相遇的点就是环形链表的入环点
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    private class ListNode {
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
