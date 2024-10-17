package a_rumen.rumen_001_dongtaishuzu_and_lianbiao;

import java.util.NoSuchElementException;

/**
 * @className: MyArrayList
 * @author: Docer
 * @date: 2024/10/15 11:20
 * @Version: 1.0
 * @description: 动态数组实现
 */
public class MyArrayList<E> {
    // 默认容量
    private static final int DEFAULT_CAPACITY = 10;
    // 当前元素个数
    private int size;
    // 容器
    private E[] elementData;

    // 空参构造：无参构造的时候调用默认容量 DEFAULT_CAPACITY 初始化
    public MyArrayList() {
        this(DEFAULT_CAPACITY);
    }

    public MyArrayList(int defaultCapacity) {
        elementData = (E[]) new Object[defaultCapacity];
        size = 0;
    }

    // 1. 增加元素
    // 1.1 从头部插入
    public void addFirst(E e) {
        add(0, e);
    }

    // 1.2 从尾部插入
    public void addLast(E e) {
        // 判断容量
        if (size == elementData.length) {
            // 扩容
            resize(elementData.length << 1);
        }
        // 插入，并更新 size
        elementData[size++] = e;
    }

    // 重设 size 为 newCapacity
    private void resize(int newCapacity) {
        E[] temp = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            temp[i] = elementData[i];
        }
        elementData = temp;
    }

    // 1.3 从指定位置插入
    public void add(int index, E e) {
        // 判断 index
        checkPositionIndex(index);
        // 判断容量
        if (size == elementData.length) {
            resize(elementData.length << 1);
        }
        // 移动元素
        for (int i = size - 1; i >= index; i--) {
            elementData[i + 1] = elementData[i];
        }
        // 插入，并更新 size
        elementData[index] = e;
        size++;
    }


    // 2. 删除元素
    // 2.1 从头部删除
    public E removeFirst() {
        return remove(0);
    }

    // 2.2 从尾部删除
    public E removeLast() {
        // 判断是否为空
        if (size == 0) {
            throw new NoSuchElementException();
        }
        // 判断是否需要缩容
        if (size == elementData.length / 4) {
            resize(elementData.length >> 1);
        }
        // 删除对应元素，并更新 size
        E deletedElement = elementData[size - 1];
        elementData[size - 1] = null; // 置空，避免内存泄漏
        size--;
        return deletedElement;
    }

    // 2.3 从指定位置删除
    public E remove(int index) {
        // 检查 index
        checkElementIndex(index);
        // 判断容量
        if (size == elementData.length / 4) {
            resize(elementData.length >> 1);
        }
        E deletedElement = elementData[index];
        // 移动元素
        for (int i = index; i < size - 1; i++) {
            elementData[i] = elementData[i + 1];
        }
        // 最后位置上的元素置空，更新 size
        elementData[size - 1] = null;
        size--;
        return deletedElement;
    }


    // 3. 修改元素
    public E set(int index, E e) {
        checkElementIndex(index);
        E oldElement = elementData[index];
        elementData[index] = e;
        return oldElement;
    }

    // 4. 查询元素
    public E get(int index) {
        checkElementIndex(index);
        return elementData[index];
    }

    // 5. 工具方法
    // 5.1 获取 size
    public int size() {
        return size;
    }

    // 5.2 判断是否为空
    public boolean isEmpty() {
        return size == 0;
    }

    // 判断索引越界，指定「元素索引」是否合法
    private void checkElementIndex(int index) {
        if (!(index >= 0 && index < size)) {
            throw new IndexOutOfBoundsException("Index: " + index + ",Size: " + size);
        }
    }

    // 判断索引越界，指定「位置」是否合法
    private void checkPositionIndex(int index) {
        if (!(index >= 0 && index <= size)) {
            throw new IndexOutOfBoundsException("Index: " + index + ",Size: " + size);
        }
    }

    public static void main(String[] args) {
        MyArrayList<Integer> list = new MyArrayList<>(20);
        System.out.println("list.isEmpty() : " + list.isEmpty());
        list.addFirst(1);
        list.add(1, 4);
        System.out.println("list: " + String.valueOf(list));
    }
}
