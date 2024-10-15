package main.java.com.cenran.queueAndStack;

import main.java.com.cenran.dongtaishuzu.MyLinkedList;

/**
 * @className: MyQueue
 * @author: Docer
 * @date: 2024/10/15 21:40
 * @Version: 1.0
 * @description:
 */
public class MyLinkedQueue<E> {
    private final MyLinkedList<E> linkedList = new MyLinkedList<>();

    public void push(E e) {
        linkedList.addFirst(e);
    }

    public E pop() {
        return linkedList.removeLast();
    }

    public E peek() {
        return linkedList.getLast();
    }

    public Integer size() {
        return linkedList.size();
    }

    public static void main(String[] args) {
        MyLinkedQueue<Integer> queue = new MyLinkedQueue<>();
        queue.push(1);
        queue.push(2);
        queue.push(3);
        System.out.println(queue.peek());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.peek());
    }
}
