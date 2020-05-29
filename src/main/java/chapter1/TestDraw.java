package chapter1;

import edu.princeton.cs.algs4.StdDraw;

/**
 * Description:
 *
 * @author zhangr
 * 2020/5/26 17:00
 * }
 */
public class TestDraw {
    public static void main(String[] args) {
        int N = 100;
        StdDraw.setXscale(0, N);
        StdDraw.setYscale(0, N * N);
        StdDraw.setPenRadius(.01);
        for (int i = 1; i <= N; i++) {
            StdDraw.point(i, i);
            StdDraw.point(i, i * i);
            StdDraw.point(i, i * Math.log(i));
        }
    }
}
