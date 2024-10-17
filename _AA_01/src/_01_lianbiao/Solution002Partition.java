package _01_lianbiao;


/**
 * @className: Solution002Partition
 * @author: Docer
 * @date: 2024/10/16 15:06
 * @Version: 1.0
 * @description: 86. 分隔链表
 */
public class Solution002Partition {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(4);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(2);
        Solution002Partition solution002Partition = new Solution002Partition();
        ListNode newHead = solution002Partition.partition(head, 3);
        System.out.println(newHead.val);
        System.out.println(newHead.next.val);
        System.out.println(newHead.next.next.val);
        System.out.println(newHead.next.next.next.val);
        System.out.println(newHead.next.next.next.next.val);
        System.out.println(newHead.next.next.next.next.next.val);
    }

    public ListNode partition(ListNode head, int x) {
        // 虚拟头节点
        ListNode dummy1 = new ListNode(-1);
        ListNode dummy2 = new ListNode(-1);
        // 指针 p
        ListNode p = head;

        ListNode p1 = dummy1;
        ListNode p2 = dummy2;

        while (p != null) {
            if (p.val < x) {
                p1.next = p;
                p1 = p1.next;
            } else {
                p2.next = p;
                p2 = p2.next;
            }
            ListNode temp = p.next;
            p.next = null;
            p = temp;
        }

        p1.next = dummy2.next;

        return dummy1.next;
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
