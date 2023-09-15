package org.example.doublePtr;

/**
 * @BelongsProject: algorithm-labuladong
 * @BelongsPackage: org.example
 * @Author: 岑然
 * @CreateTime: 2023-09-14  15:40
 * @Description: 力扣 19. 删除链表的倒数第 N 个结点 https://leetcode.cn/problems/remove-nth-node-from-end-of-list/description/
 * @Version: 1.0
 */
public class DoublePtr_04 {

    public static void main(String[] args) {
        // 创建数据方便测试
        ListNode head = new ListNode(-1);
        int k = 0;
        // 执行
        ListNode res = removeNthFromEnd(head, k);
    }

    /***
     * @description 删除链表的第倒数 k 个节点
     * @author 岑然
     * @return org.example.doublePtr.DoublePtr_04.ListNode
     * @param head
     * @param k
     * @date 2023/9/14 15:54
     */
    private static ListNode removeNthFromEnd(ListNode head, int k) {
        // 1. 定义虚拟头结点
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        // 2. 找到倒数第 k + 1 个节点
        ListNode node = findFromEnd(dummy, k + 1);
        // 3. 删除第倒数 k 个节点
        node.next = node.next.next;
        // 4. 返回虚拟头结点的 next
        return dummy.next;
    }

    /***
     * @description 找到链表的倒数第 k 个节点，并返回该节点
     * @author 岑然
     * @return org.example.doublePtr.DoublePtr_04.ListNode
     * @param head
     * @param k
     * @date 2023/9/14 15:55
     */
    private static ListNode findFromEnd(ListNode head, int k) {
        // 1. 定义双指针
        ListNode p1 = head;
        ListNode p2 = head;
        // 2. 指针 p1 往前走 k 步，停住等待指针 p2
        for (int i = 0; i < k; i++) {
            p1 = p1.next;
        }
        // 3. 指针 p2 跟 p1 一起往前走，直到 p1 跑完才停止
        while (p1 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        // 4. 返回停止时的 p2 ，他就是倒数第 k 个节点
        return p2;
    }


    /* 内部 ListNode 类 */
    public static class ListNode {
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
