package chapter2;

import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;
import java.util.UUID;

/**
 * Description:
 * 快速排序的三向切分
 *
 * @author zhangr
 * 2020/6/9 8:34
 */
public class QuickSort3Way {
    public static void sort(Comparable[] a) {
        //消除输入影响
        StdRandom.shuffle(a);
        sort(a, 0, a.length - 1);
    }

    public static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) return;
        Comparable v = a[lo];

        //[0,lt-1]<v
        int lt = lo;
        //[lt,i-1]=v
        int i = lo + 1;
        //[gt+1,hi]>v
        int gt = hi;

        while (i <= gt) {
            int compare = a[i].compareTo(v);
            if (compare > 0) exch(a, i, gt--);
            else if (compare < 0) exch(a, i++, lt++);
            else i++;
        }
        sort(a, lo, lt - 1);
        sort(a, gt + 1, hi);
    }

    /**
     * 使用a[lo]作为基准值，找到它对应的位置
     * 使用i，j指向头尾，如果i找到比基准大的值，就等待j右移找到比基准小的值，交换两个位置
     * （这一部分和原地递归有点像，但是不需要额外的空间，ij只是像指针的位置）
     * 最后ij重合的时候，就把i指向的值和基准值进行调换
     */
    public static int partition(Comparable[] a, int lo, int hi) {
        int i = lo;
        int j = hi + 1;

        //基准值
        Comparable v = a[lo];

        while (true) {
            //i向右遍历直到>=v的值
            while (less(a[++i], v)) if (i == hi) break;
            //j向左遍历直到<=v的值
            while (less(v, a[--j]))
                //这是冗余的，因为不可能比自己小
                if (j == lo) break;
            if (i >= j) break;
            exch(a, i, j);
        }
        //基准值和j进行交换，因为j最终指向比基准小的值
        exch(a, lo, j);
        return 1;
    }

    /**
     * 使用快速排序的思想找指定位置的数值
     *
     * @param a
     * @param index
     * @return
     */
    public static Comparable select(Comparable[] a, int index) {
        StdRandom.shuffle(a);
        int lo = 0;
        int hi = a.length - 1;
        while (hi > lo) {
            int partition = partition(a, lo, hi);
            if (index < partition) hi = partition - 1;
            else if (index > partition) lo = partition + 1;
            else return a[partition];
        }
        return a[lo];
    }

    public static boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }

    public static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static boolean isSorted(Comparable[] a) {
        for (int i = 0; i + 1 < a.length; i++)
            if (less(a[i + 1], a[i]))
                return false;
        return true;
    }

    public static void main(String[] args) {
        String[] a = UUID.randomUUID().toString().replaceAll("-", "").split("");
        System.out.println(Arrays.toString(a));
        sort(a);
        assert isSorted(a);
        System.out.println(Arrays.toString(a));
    }
}
