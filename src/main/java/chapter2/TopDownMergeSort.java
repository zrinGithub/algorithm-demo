package chapter2;

import java.util.Arrays;
import java.util.UUID;

/**
 * Description:
 *
 * @author zhangr
 * 2020/6/3 11:02
 */
public class TopDownMergeSort {
    public static void merge(Comparable[] a, int lo, int hi) {
        //递归的结束条件
//        if (hi<=lo) return;
//
//        int mid = (lo + hi) /2;
//        merge(a,lo,mid);
//        merge(a,mid——,mid);
    }

    public static void sort(Comparable[] a) {
        int N = a.length;
        merge(a, 0,  N - 1);
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
