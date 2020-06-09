package chapter2;

import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Description:
 * 最大堆
 *
 * @author zhangr
 * 2020/6/9 14:15
 */
public class MaxPQ<T> implements Iterable<T> {
    private Object[] pq; //最大堆使用数组来实现
    private int n;  //元素个数
    private Comparator<T> comparator;   //可选参数：比较器

    //默认构造器
    public MaxPQ() {
        this(1);
    }

    //指定容量的构造器
    public MaxPQ(int initCapacity) {
        pq = new Object[initCapacity + 1];  //+1是因为计数是从1开始的
        n = 0;
    }

    //指定比较器
    public MaxPQ(int initCapacity, Comparator<T> comparator) {
        this(initCapacity);
        this.comparator = comparator;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    //获取最大值，因为二叉堆的特性，这里直接取第一个参数就行了
    @SuppressWarnings("unchecked")
    public T max() {
        if (isEmpty()) throw new NoSuchElementException("isEmpty");
        return (T) pq[1];
    }

    //插入
    public void insert(T v) {
        //这里需要有扩容函数
        //元素加到末尾进行上浮
        pq[++n] = v;
        swim(n);
    }

    //删除
    public T delete() {
        if (isEmpty()) throw new NoSuchElementException("empty");

        Object max = pq[1];
        //把末尾元素放到首位开始下沉
        exch(1, n--);
        sink(1);

        pq[n + 1] = null;//gc
        //删除完后可以考虑缩减容量
        return (T) max;
    }

    //上浮
    private void swim(int k) {
        //和跟节点进行比较，如果比根节点更大就上浮
        while (k > 1 && less(k / 2, k)) {
            exch(k, k / 2);
            k /= 2;
        }
    }

    //下沉
    private void sink(int k) {
        //同最大子节点进行比较，如果小于子节点就下城
        while (2 * k <= n) {
            int j = 2 * k;
            //获取较大的子节点
            if (j < n && less(j, j + 1)) j++;
            //和最大子节点比较
            if (!less(k, j)) {
                break;
            } else {
                exch(k, j);
                //继续下沉
                k = j;
            }
        }
    }

    @SuppressWarnings("unchecked")
    private boolean less(int i, int j) {
        if (comparator == null)
            return ((Comparable<T>) pq[i]).compareTo((T) pq[j]) < 0;
        return comparator.compare((T) pq[i], (T) pq[j]) < 0;
    }

    private void exch(int i, int j) {
        Object temp = pq[i];
        pq[i] = pq[j];
        pq[j] = temp;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }
}
