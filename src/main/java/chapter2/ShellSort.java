package chapter2;

import java.util.Arrays;
import java.util.UUID;

/**
 * Description:
 *
 * @author zhangr
 * 2020/6/3 11:02
 */
public class ShellSort {
    public static void sort(Comparable[] a) {
        int N = a.length;
        int h = 1;
        //h -> 1    4   13  40  121
        while (h < N / 3) h = 3 * h + 1;
        while (h >= 1) {
            //和插入排序相同
            for (int i = h; i < N; i++) {
                for (int j = i; j >= h && less(a[j], a[j - h]); j -= h)
                    exch(a, j, j - h);
            }
            h = h / 3;
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
        sort(a);
        assert isSorted(a);
        System.out.println(Arrays.toString(a));
    }

}
