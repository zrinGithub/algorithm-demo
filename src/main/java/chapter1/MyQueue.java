package chapter1;

/**
 * Description:
 * 单向链表实现队列的功能，因为是单向的，所以队尾不能进行出队操作
 *
 * @author zhangr
 * 2020/6/1 9:20
 * }
 */
public class MyQueue<T> {
    private class Node {
        T item;
        Node next;
    }

    private Node first;
    private Node last;
    //数据大小
    private int N;

    //是否为空
    public boolean isEmpty() {
        return N <= 0;
    }

    //获取大小
    public int size() {
        return N;
    }

    //入队操作
    public void enqueue(T val) {
        Node l = last;
        last = new Node();
        last.item = val;
        last.next = null;

        if (isEmpty()) first = last;
        else l.next = last;

        N++;
    }

    //出队操作
    public T dequeue() {
        if (isEmpty())
            return null;

        T item = first.item;
        first = first.next;
        N--;
        //如果本来只剩一个元素，操作完成后应该为空
        if(isEmpty())
            last = null;
        return item;
    }

    public static void main(String[] args) {
        MyQueue<String> queue = new MyQueue<>();
        queue.enqueue("1");
        queue.enqueue("2");
        queue.enqueue("3");
        queue.enqueue("4");
        queue.enqueue("5");
        while (!queue.isEmpty()){
            System.out.println(queue.dequeue());
        }
    }
}
