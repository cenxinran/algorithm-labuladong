package _01_lianbiao;

/**
 * @className: Solution004RemoveNthFromEnd
 * @author: Docer
 * @date: 2024/10/17 7:05
 * @Version: 1.0
 * @description: 19. 删除链表的倒数第 N 个结点
 */
public class Solution004RemoveNthFromEnd {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        // 找到倒数第 N+1 个节点
        ListNode needNode = findNthFromEnd(dummy, n + 1);
        // 删除倒数第 N 个节点
        needNode.next = needNode.next.next;

        return dummy.next;
    }

    // 找到链表的倒数第 k 个节点
    private ListNode findNthFromEnd(ListNode head, int k) {
        // 初始化快慢指针 p1 p2
        ListNode p1 = head;
        ListNode p2 = head;
        // p1 先走 k 步
        for (int i = 0; i < k; i++) {
            p1 = p1.next;
        }
        // 然后快慢指针同时走
        while (p1 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        // 当p1 走完之后，p2 就走了 n - k + 1 步，指向了倒数第 k 个节点
        return p2;
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
