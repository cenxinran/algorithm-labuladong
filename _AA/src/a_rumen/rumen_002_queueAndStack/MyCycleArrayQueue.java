package a_rumen.rumen_002_queueAndStack;

/**
 * @className: MyCycleArrayQueue
 * @author: Docer
 * @date: 2024/10/15 23:21
 * @Version: 1.0
 * @description: 使用环形数组实现的队列
 */
public class MyCycleArrayQueue<T> {
    private MyCycleArr<T> data;

    public MyCycleArrayQueue() {
        data = new MyCycleArr<>();
    }

    public void push(T t) {
        data.addLast(t);
    }

    public T pop() {
        return data.removeFirst();
    }

    public T peek() {
        return data.getFirst();
    }

    public Integer size() {
        return data.size();
    }
}
