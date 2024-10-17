package _01_lianbiao;

/**
 * @className: Solution005MiddleNode
 * @author: Docer
 * @date: 2024/10/17 7:27
 * @Version: 1.0
 * @description: 876. 链表的中间结点
 */
public class Solution005MiddleNode {
    public ListNode middleNode(ListNode head) {
        // 配置快慢指针 slow fast
        ListNode slow = head;
        ListNode fast = head;
        // 快指针每次走两步，慢指针每次走一步，当快指针走完的时候，慢指针正好到中间节点
        while (fast != null && fast.next != null) { // 注意：停止条件为 fast == null 或者 fast.next == null ，所以对于偶数个节点的链表，找打的是靠右边的中间节点，而不是靠左边的中间节点。
            slow = slow.next;
            fast = fast.next.next;
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
