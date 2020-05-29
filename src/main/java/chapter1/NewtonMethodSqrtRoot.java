package chapter1;

/**
 * Description:
 *
 * @author zhangr
 * 2020/5/26 16:12
 * }
 */
public class NewtonMethodSqrtRoot {
    public static double sqrt(double c) {
        //误差范围
        double err = 1e-10;
        double t = c;
        while (Math.abs(t - c / t) > err * t)
            t = (c / t + t) / 2.0;
        return t;
    }

    public static void main(String[] args) {
        System.out.println(sqrt(2));
    }
}
