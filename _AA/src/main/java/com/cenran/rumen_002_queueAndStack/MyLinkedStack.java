package main.java.com.cenran.rumen_002_queueAndStack;

import main.java.com.cenran.rumen_001_dongtaishuzu_and_lianbiao.MyLinkedList;

/**
 * @className: MyQueue
 * @author: Docer
 * @date: 2024/10/15 21:40
 * @Version: 1.0
 * @description:
 */
public class MyLinkedStack<E> {
    private MyLinkedList<E> list = new MyLinkedList<>();

    public void push(E e) {
        list.addLast(e);
    }

    public E pop() {
        return list.removeLast();
    }

    public E peek() {
        return list.getLast();
    }

    public Integer size() {
        return list.size();
    }

    public static void main(String[] args) {
        MyLinkedStack<Integer> stack = new MyLinkedStack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
