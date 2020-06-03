package chapter1;

import edu.princeton.cs.algs4.BinarySearch;

import java.util.Arrays;

/**
 * Description:
 * Arrays.sort(a); 使用归并排序 Nlog(N)
 * BinarySearch.indexOf使用二分法 log(N)
 * 循环调用indexOf次数：N(N-1)/2
 * <p>
 * 因此总的运行时间和 (N^2)(logN)成正比
 *
 * @author zhangr
 * 2020/6/1 14:22
 * }
 */
public class ThreeSumFast {
    public static void main(String[] args) {
        int[] a = {1, 2, 32, 11, -2, 3, -3, 1};
        Arrays.sort(a);
        int count = 0;
        for (int i = 0; i < a.length; i++)
            for (int j = i + 1; j < a.length; j++)
                if (BinarySearch.indexOf(a, -(a[i] + a[j])) > j)
                    count++;
        System.out.println(count);
    }
}
