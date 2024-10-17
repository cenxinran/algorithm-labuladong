package _01_lianbiao;

/**
 * @className: Solution007GetIntersectionNode
 * @author: Docer
 * @date: 2024/10/17 8:19
 * @Version: 1.0
 * @description:160. 相交链表  两种方案实现
 */
public class Solution007GetIntersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // 思路：双指针，分别遍历两个链表，当两个链表相交时，返回相交节点
        ListNode p1 = headA;
        ListNode p2 = headB;
        while (p1 != p2) {
            if (p1 == null) {
                p1 = headB;
            } else {
                p1 = p1.next;
            }
            if (p2 == null) {
                p2 = headA;
            } else {
                p2 = p2.next;
            }
        }
        return p1;
    }

    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        // 方案二：将其中一个链表首尾相连，问题就变成了链表找环的问题了
        ListNode p = headA;
        while (p != null) {
            if (p.next == null) {
                p.next = headA;
                break;
            }
            p = p.next;
        }

        ListNode rukou = detectCycle(headB);

        // 记得找到焦点后，还需要将之前收尾相接的链表首尾解开
        p.next = null;

        return rukou;
    }

    private ListNode detectCycle(ListNode head) {
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



