package main.java.com.cenran.rumen_001_dongtaishuzu_and_lianbiao;

/**
 * @className: SingleList
 * @author: Docer
 * @date: 2024/10/15 13:30
 * @Version: 1.0
 * @description: 单链表实现
 */
public class SingleLinkedList {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        ListNode head = new SingleLinkedList().createLinkedList(arr);
        System.out.println("------------------------------------------------");
        System.out.print("链表： ");
        bianli(head);
        System.out.println("");
        System.out.println("------------------------------------------------");
        System.out.print("头部插入元素 0 后链表： ");
        ListNode newHead = insertAtHead(head, 0);
        bianli(newHead);
        System.out.println("");
        System.out.println("------------------------------------------------");
        System.out.print("尾部插入元素 11 后链表： ");
        bianli(insertAtTail(newHead, 11));
        System.out.println("");
        System.out.println("------------------------------------------------");
        System.out.print("在链表第 3 个节点之后插入元素 6 后链表： ");
        bianli(insert(newHead, 6, 3));
        System.out.println("");
        System.out.println("------------------------------------------------");
        System.out.print("删除链表第 5 个节点后链表： ");
        bianli(delete(newHead, 5));
        System.out.println("");
        System.out.println("------------------------------------------------");
        System.out.print("删除链表尾部元素后链表： ");
        bianli(delAtTail(newHead));
        System.out.println("");
        System.out.println("------------------------------------------------");
        System.out.print("删除头节点后链表： ");
        bianli(delAtFirst(newHead));
        System.out.println("");
        System.out.println("------------------------------------------------");
    }

    // 在单链表头部删除元素
    private static ListNode delAtFirst(ListNode head) {
        return head.next;
    }

    // 在单链表尾部删除元素
    private static ListNode delAtTail(ListNode head) {
        ListNode p = head;
        while (p.next.next != null) {
            p = p.next;
        }
        p.next = null;
        return head;
    }


    // 在单链表中删除一个节点
    private static ListNode delete(ListNode head, int index) {
        ListNode p = head;
        for (int i = 0; i < index - 2; i++) {
            p = p.next;
        }
        p.next = p.next.next;
        return head;
    }

    // 在单链表中间插入新元素
    private static ListNode insert(ListNode head, int newVal, int index) {
        ListNode p = head;
        for (int i = 0; i < index - 1; i++) {
            p = p.next;
        }
        ListNode newNode = new ListNode(newVal);
        newNode.next = p.next;
        p.next = newNode;
        return head;
    }

    // 在单链表尾部插入新元素
    private static ListNode insertAtTail(ListNode oldHead, int newVal) {
        ListNode newNode = new ListNode(newVal);
        ListNode p = oldHead;
        while (p.next != null) {
            p = p.next;
        }
        p.next = newNode;
        return oldHead;
    }


    // 在单链表头部插入新元素
    private static ListNode insertAtHead(ListNode oldHead, int newVal) {
        ListNode newHead = new ListNode(newVal);
        newHead.next = oldHead;
        return newHead;
    }


    // 遍历单链表所有节点
    private static void bianli(ListNode head) {
        for (ListNode p = head; p != null; p = p.next) {
            System.out.print(p.val);
            if (p.next != null) {
                System.out.print(" -> ");
            }
        }
    }


    // 工具类 createLinkedList ：将数组转换成单链表
    ListNode createLinkedList(int[] arr) {
        // 安全校验
        if (arr == null || arr.length == 0) {
            return null;
        }
        // 创建头节点
        ListNode head = new ListNode(arr[0]);
        // 创建指针
        ListNode cur = head;
        // 循环创建每个节点并接到上个节点后面
        for (int i = 1; i < arr.length; i++) {
            cur.next = new ListNode(arr[i]);
            cur = cur.next;
        }
        // 返回头节点
        return head;
    }

    // 单链表节点类 ListNode
    public static class ListNode {
        int val;
        ListNode next;

        public ListNode(int x) {
            val = x;
        }
    }
}
