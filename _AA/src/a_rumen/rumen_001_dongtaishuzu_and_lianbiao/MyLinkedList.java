package a_rumen.rumen_001_dongtaishuzu_and_lianbiao;


import java.util.NoSuchElementException;

/**
 * @className: MyLinkedList
 * @author: Docer
 * @date: 2024/10/15 19:31
 * @Version: 1.0
 * @description: 双链表实现
 */
public class MyLinkedList<E> {
    // ******** 成员变量 ********
    private int size;
    // 虚拟首尾节点
    final private Node<E> head, tail;

    // ******** 增加元素 ********
    public void addFirst(E e) {
        Node<E> newNode = new Node<>(e);
        // temp 接管 head 后面的节点
        Node<E> temp = head.next;
        // 关联 newNode 和 temp
        newNode.next = temp;
        temp.prev = newNode;
        // 关联 head 和newNode
        head.next = newNode;
        newNode.prev = head;
        // size++
        size++;
    }

    public void addLast(E e) {
        Node<E> newNode = new Node<>(e);
        Node<E> temp = tail.prev;
        temp.next = newNode;
        newNode.prev = temp;
        tail.prev = newNode;
        newNode.next = tail;
        size++;
    }

    public void add(int index, E e) {
        // 判断 index 是否合法
        checkPositionIndex(index);
        // 判断 index 是否是尾部
        if (index == size) {
            addLast(e);
        }
        // 不是尾部：指针节点p接管index处节点，temp接管前面一个节点
        Node<E> newNode = new Node<>(e);
        Node<E> p = getNode(index);
        Node<E> temp = p.prev;
        // 按照 temp - newNode - p 链接起来
        p.prev = newNode;
        temp.next = newNode;
        newNode.prev = temp;
        newNode.next = p;
        // size++
        size++;
    }

    // ******** 删除元素 ********
    public E removeFirst() {
        if (size < 1) {
            throw new NoSuchElementException();
        }
        Node<E> delNode = head.next;
        Node<E> temp = delNode.next;
        temp.prev = head;
        head.next = temp;

        delNode.next = null;
        delNode.prev = null;

        size--;
        return delNode.val;
    }

    public E removeLast() {
        if (size < 1) {
            throw new NoSuchElementException();
        }
        Node<E> delNode = tail.prev;
        Node<E> temp = delNode.prev;

        tail.prev = temp;
        temp.next = tail;

        delNode.prev = null;
        delNode.next = null;

        size--;
        return delNode.val;
    }

    public E remove(int index) {
        checkElementIndex(index);
        Node<E> delNode = getNode(index);

        Node<E> prevNode = delNode.prev;
        Node<E> nextNode = delNode.next;

        nextNode.prev = prevNode;
        prevNode.next = nextNode;

        delNode.next = null;
        delNode.prev = null;

        size--;
        return delNode.val;
    }

    // ******** 查询元素 ********
    public E get(int index) {
        checkElementIndex(index);
        return getNode(index).val;
    }

    public E getFirst() {
        if (size < 1) {
            throw new NoSuchElementException();
        }
        return head.next.val;
    }

    public E getLast() {
        if (size < 1) {
            throw new NoSuchElementException();
        }
        return tail.prev.val;
    }

    // ******** 修改元素 ********
    public E set(int index, E e) {
        checkElementIndex(index);
        Node<E> oldNode = getNode(index);
        E oldVal = oldNode.val;
        oldNode.val = e;
        return oldVal;
    }


    // ******** 其他操作 ********
    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    // ******** 抽取方法 ********
    private void checkPositionIndex(int index) {
        if (!(index >= 0 && index <= size)) {
            throw new IndexOutOfBoundsException("Index: " + index + ",Size: " + size);
        }
    }
    private void checkElementIndex(int index) {
        if (!(index >= 0 && index < size)) {
            throw new IndexOutOfBoundsException("Index: " + index + ",Size: " + size);
        }
    }

    // 根据索引获取节点
    private Node<E> getNode(int index) {
        checkElementIndex(index);
        if (index < size / 2) {
            Node<E> p = head;
            for (int i = 0; i < index; i++) {
                p = p.next;
            }
            return p;
        } else {
            Node<E> p = tail;
            for (int i = size; i > index; i--) {
                p = p.prev;
            }
            return p;
        }
    }

    private void display() {
        System.out.println("size: " + size);
        for (Node<E> p = head.next; p != tail; p = p.next) {
            System.out.print(p.val + " <-> ");
        }
        System.out.println("null");
        System.out.println("--------------------------");
    }

    // ******** 构造函数 ********
    public MyLinkedList() {
        this.head = new Node<>(null);
        this.tail = new Node<>(null);
        head.next = tail;
        tail.prev = head;
        this.size = 0;
    }

    // 双链表节点内部类
    private static class Node<E> {
        E val;
        Node<E> prev, next;

        Node(E val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        list.addFirst(1);
        list.addLast(2);
        list.add(1, 3);
        list.display();
    }
}
