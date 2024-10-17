package main.java.com.cenran.rumen_002_queueAndStack.deque;

import main.java.com.cenran.rumen_002_queueAndStack.MyCycleArr;

/**
 * @className: MyCycleArrayDeque
 * @author: Docer
 * @date: 2024/10/15 23:39
 * @Version: 1.0
 * @description: 使用环形数组实现双端队列
 */
public class MyCycleArrayDeque<T> implements MyDeque<T> {
    private MyCycleArr<T> data = new MyCycleArr<>();

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
}
