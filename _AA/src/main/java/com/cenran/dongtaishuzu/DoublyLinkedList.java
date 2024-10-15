package main.java.com.cenran.dongtaishuzu;

import javax.lang.model.element.VariableElement;
import java.sql.Array;
import java.util.Calendar;

/**
 * @className: DoublyLinkedList
 * @author: Docer
 * @date: 2024/10/15 14:45
 * @Version: 1.0
 * @description:
 */
public class DoublyLinkedList {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        DoublyListNode head = new DoublyLinkedList().createDoublyLinkedList(arr);
        DoublyListNode tail = bianli0(head);
        bianli1(tail);
        //DoublyListNode newHead = insertAtHead(head, 0);
        //bianli0(newHead);
        //DoublyListNode newHead1 = insertAtTail(newHead, 100);
        //bianli0(newHead1);
        //DoublyListNode newHead11 = insert(newHead1, 300, 4);
        //bianli0(newHead11);
        //bianli0(insert(insertAtTail(insertAtHead(head, 0), 100), 300, 4));
        //bianli0(remove(head, 2));
        //bianli0(removeAtHead(head));
        bianli0(removeAtTail(head));
    }

    // 在双链表尾部删除元素
    private static DoublyListNode removeAtTail(DoublyListNode head) {
        DoublyListNode p = head;
        while (p.next.next != null) {
            p = p.next;
        }
        p.next.prev = null;
        p.next = null;
        return head;
    }

    // 在双链表头部删除元素
    private static DoublyListNode removeAtHead(DoublyListNode head) {
        DoublyListNode newHead = head.next;
        newHead.prev = null;
        return newHead;
    }

    // 在双链表中删除一个节点
    private static DoublyListNode remove(DoublyListNode head, int index) {
        DoublyListNode p = head;
        for (int i = 0; i < index - 2; i++) {
            p = p.next;
        }
        p.next.next.prev = p;
        p.next = p.next.next;
        return head;
    }

    // 在双链表中间插入新元素 10 第index=5个，p应该是4，索引就是4-1
    private static DoublyListNode insert(DoublyListNode head, int val, int index) {
        DoublyListNode p = head;
        DoublyListNode newNode = new DoublyListNode(val);
        for (int i = 0; i < index - 2; i++) {
            p = p.next;
        }
        p.next.prev = newNode;
        newNode.next = p.next;
        p.next = newNode;
        newNode.prev = p;
        return head;
    }

    // 在双链表尾部插入新元素
    private static DoublyListNode insertAtTail(DoublyListNode head, int val) {
        DoublyListNode newNode = new DoublyListNode(val);
        DoublyListNode p = head;
        while (p.next != null) {
            p = p.next;
        }
        p.next = newNode;
        newNode.prev = p;
        return head;
    }

    // 在双链表头部插入新元素
    private static DoublyListNode insertAtHead(DoublyListNode head, int val) {
        DoublyListNode newHead = new DoublyListNode(val);
        newHead.next = head;
        head.prev = newHead;
        return newHead;
    }

    // 正向遍历双向链表所有节点
    private static DoublyListNode bianli0(DoublyListNode head) {
        DoublyListNode tail = null;
        for (DoublyListNode p = head; p != null; p = p.next) {
            System.out.print(p.val);
            if (p.next != null) {
                System.out.print(" - ");
            } else {
                tail = p;
                System.out.println("");
            }
        }
        return tail;
    }

    // 反向遍历双向链表所有节点
    private static void bianli1(DoublyListNode tail) {
        for (DoublyListNode p = tail; p != null; p = p.prev) {
            System.out.print(p.val);
            if (p.prev != null) {
                System.out.print(" - ");
            } else {
                System.out.println("");
            }
        }
    }

    // 工具方法，根据数组创建双向链表
    public DoublyListNode createDoublyLinkedList(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        DoublyListNode head = new DoublyListNode(arr[0]);
        DoublyListNode cur = head;
        for (int i = 1; i < arr.length; i++) {
            DoublyListNode newNode = new DoublyListNode(arr[i]);
            cur.next = newNode;
            newNode.prev = cur;
            cur = cur.next;
        }
        return head;
    }

    // 双向链表节点类 DoublyListNode
    public static class DoublyListNode {
        int val;
        DoublyListNode prev, next;

        public DoublyListNode(int x) {
            val = x;
        }
    }
}
