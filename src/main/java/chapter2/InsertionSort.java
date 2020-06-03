package chapter2;

import java.util.Arrays;
import java.util.UUID;

/**
 * Description:
 * 插入排序：
 * 向有序的数组中插入元素
 *
 * @author zhangr
 * 2020/6/3 11:02
 */
public class InsertionSort {
    public static void sort(Comparable[] a) {
        int N = a.length;
        for (int i = 1; i < N; i++)
            for (int j = i; j > 0 && (less(a[j], a[j - 1])); j--)
                exch(a, j, j - 1);
    }

    public static void sort2(Comparable[] a) {
        int N = a.length;
        for (int i = 1; i < N; i++) {
            Comparable in = a[i];
            int j = i;
            for (; j > 0 && (less(in, a[j - 1])); j--)
                a[j] = a[j - 1];
            a[j] = in;
        }
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
        sort2(a);
        assert isSorted(a);
        System.out.println(Arrays.toString(a));
    }

}
