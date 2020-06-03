package chapter2;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;

import java.util.Arrays;

/**
 * Description:
 *
 * @author zhangr
 * 2020/6/3 11:02
 */
public class Example {
    public static void sort(Comparable[] a) {
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
        String[] a = {"a", "x", "d"};
        sort(a);
        assert isSorted(a);
        System.out.println(Arrays.toString(a));
    }

}
