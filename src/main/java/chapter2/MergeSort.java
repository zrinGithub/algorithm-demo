package chapter2;

import java.util.Arrays;
import java.util.UUID;

/**
 * Description:
 *
 * @author zhangr
 * 2020/6/3 11:02
 */
public class MergeSort {
    private static Comparable[] aux;

    public static void merge(Comparable[] a, int lo, int mid, int hi) {
        //i指向左边的一半
        //j指向右边的一半
        int i = lo, j = mid + 1;

        //复制数组
        for (int k = lo; k <= hi; k++)
            aux[k] = a[k];

        for (int k = lo; k <= hi; k++)
            //左边的数据取完了，剩下都取右边的数据
            if (i > mid)
                a[k] = aux[j++];
            else if (j > hi) {
                //右边的数据取完了，剩下都取左边的数据
                a[k] = aux[i++];
            } else if (less(aux[j], aux[i])) {
                //取最小的数据
                a[k] = aux[j++];
            } else {
                //取小的数据
                a[k] = aux[i++];
            }
    }

    public static void sort(Comparable[] a) {
        int N = a.length;
        aux = new Comparable[N];
        merge(a, 0, N / 2, N - 1);
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
