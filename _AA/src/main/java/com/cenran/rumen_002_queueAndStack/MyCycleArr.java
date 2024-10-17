package main.java.com.cenran.rumen_002_queueAndStack;


/**
 * @className: MyCycleArr
 * @author: Docer
 * @date: 2024/10/15 22:19
 * @Version: 1.0
 * @description: 环形数组的实现
 */
public class MyCycleArr<T> {
    private T[] data;
    private Integer start;
    private Integer end;
    private Integer size;
    private Integer count;

    public void addFirst(T val) {
        // 容量满了，就扩容 2 倍
        if (isFull()) {
            resize(size << 1);
        }
        // 容量未满，直接添加即可
        start = (start - 1 + size) % size;
        data[start] = val;

        count++;
    }

    public void addLast(T val) {
        if (isFull()) {
            resize(size << 1);
        }
        data[end] = val;
        end = (end + 1) % size;
        count++;
    }

    public T removeFirst() {
        if (isEmpty()) {
            throw new IllegalStateException("Array is empty");
        }
        T res = data[start];
        data[start] = null;
        start = (start + 1) % size;
        count--;

        if (count > 0 && count == size / 4) {
            resize(size >> 1);
        }
        return res;
    }

    public T removeLast() {
        if (isEmpty()) {
            throw new IllegalStateException("Array is empty");
        }
        end = (end - 1 + size) % size;
        T res = data[end];
        data[end] = null;
        count--;

        if (count > 0 && count == size / 4) {
            resize(size >> 1);
        }

        return res;
    }


    public T getFirst() {
        if (isEmpty()) {
            throw new IllegalStateException("Array is empty");
        }
        return data[start];
    }

    public T getLast() {
        if (isEmpty()) {
            throw new IllegalStateException("Array is empty");
        }
        return data[(end - 1 + size) % size];
    }

    private void resize(int newSize) {
        T[] newArr = (T[]) new Object[newSize];
        for (int i = 0; i < count; i++) {
            newArr[i] = data[(start + i) % size];
        }
        data = newArr;
        start = 0;
        end = count;
        size = newSize;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public boolean isFull() {
        return count == size;
    }

    public Integer size() {
        return count;
    }

    public MyCycleArr() {
        this(1);
    }

    public MyCycleArr(int size) {
        this.data = (T[]) new Object[size];
        this.start = 0;
        this.end = 0;
        this.size = size;
        this.count = 0;
    }
}
