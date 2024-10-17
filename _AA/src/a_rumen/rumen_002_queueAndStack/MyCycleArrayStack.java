package a_rumen.rumen_002_queueAndStack;

/**
 * @className: MyCycleArrayStack
 * @author: Docer
 * @date: 2024/10/15 23:12
 * @Version: 1.0
 * @description: 使用环形数组实现栈
 */
public class MyCycleArrayStack<E> {
    private MyCycleArr<E> data = new MyCycleArr<>();

    public void push(E e) {
        data.addLast(e);
    }

    public E pop() {
        return data.removeLast();
    }

    public E peek() {
        return data.getLast();
    }

    public Integer size() {
        return data.size();
    }
}
