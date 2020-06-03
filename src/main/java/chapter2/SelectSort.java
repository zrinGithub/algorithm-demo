package chapter2;

import java.util.Arrays;
import java.util.UUID;

/**
 * Description:
 * 快速排序的思路：
 * 遍历数组，找到最小值放在首位
 * (N-1)+(N-2)+1 = N(N-1)/2 ~ N^2
 *
 * @author zhangr
 * 2020/6/3 11:02
 */
public class SelectSort {
    public static void sort(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            int min = i;
            for (int j = i + 1; j < a.length; j++) {
                if (less(a[j], a[min]))
                    min = j;
            }
            if (i != min)
                exch(a, i, min);
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
