package a_rumen.rumen_002_queueAndStack.deque;

import a_rumen.rumen_001_dongtaishuzu_and_lianbiao.MyLinkedList;

/**
 * @className: MyListDeque
 * @author: Docer
 * @date: 2024/10/15 23:33
 * @Version: 1.0
 * @description: 使用链表实现的双端队列
 */
public class MyListDeque<T> implements MyDeque<T> {

    private MyLinkedList<T> data = new MyLinkedList();

    @Override
    public void addFirst(T t) {
        data.addFirst(t);
    }

    @Override
    public void addLast(T t) {
        data.addLast(t);
    }

    @Override
    public T removeFirst() {
        return data.removeFirst();
    }

    @Override
    public T removeLast() {
        return data.removeLast();
    }

    @Override
    public T peekFirst() {
        return data.getFirst();
    }

    @Override
    public T peekLast() {
        return data.getLast();
    }

    public static void main(String[] args) {
        MyListDeque<Integer> deque = new MyListDeque<>();
        deque.addFirst(1);
        deque.addFirst(2);
        deque.addLast(3);
        deque.addLast(4);

        System.out.println(deque.removeFirst()); // 2
        System.out.println(deque.removeLast()); // 4
        System.out.println(deque.peekFirst()); // 1
        System.out.println(deque.peekLast()); // 3
    }
}
