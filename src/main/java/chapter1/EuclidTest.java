package chapter1;

/**
 * Description:
 *
 * @author zhangr
 * 2020/5/26 15:21
 * }
 */
public class EuclidTest {
    public static int gcd(int x, int y) {
        if (y == 0) return x;
        int z = x % y;
        return gcd(y, z);
    }

    public static void main(String[] args) {
        System.out.println(gcd(12,6));
    }
}
