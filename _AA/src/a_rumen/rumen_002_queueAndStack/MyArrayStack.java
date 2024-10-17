package a_rumen.rumen_002_queueAndStack;

import a_rumen.rumen_001_dongtaishuzu_and_lianbiao.MyArrayList;

/**
 * @className: MyArrayStack
 * @author: Docer
 * @date: 2024/10/15 23:06
 * @Version: 1.0
 * @description: 用动态数组实现栈
 */
public class MyArrayStack<E> {
    MyArrayList<E> data = new MyArrayList<>();

    public void push(E e) {
        data.addLast(e);
    }

    public E pop() {
        return data.removeLast();
    }

    public E peek() {
        return data.get(data.size() - 1);
    }

    public Integer size() {
        return data.size();
    }
}
