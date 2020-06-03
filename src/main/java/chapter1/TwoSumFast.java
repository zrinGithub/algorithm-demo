package chapter1;

import edu.princeton.cs.algs4.BinarySearch;

import java.util.Arrays;

/**
 * Description:
 * Arrays.sort(a); 使用归并排序 Nlog(N)
 * BinarySearch.indexOf使用二分法 log(N)
 * 循环调用indexOf次数：N
 * 因此总的运行时间和 N(logN)成正比
 *
 * @author zhangr
 * 2020/6/1 14:16
 * }
 */
public class TwoSumFast {
    public static void main(String[] args) {
        int[] a = {1, 2, 32, 11, -2, 3, -3};
        Arrays.sort(a);
        int count = 0;
        for (int i = 0; i < a.length; i++)
            if (BinarySearch.indexOf(a, -a[i]) > i)
                count++;
        System.out.println(count);
    }
}
