package chapter1;


/**
 * Description:
 *
 * @author zhangr
 * 2020/5/26 15:24
 * }
 */
public class ArrayOperTest {
    public static double findMax(double[] array) {
        double max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (max < array[i])
                max = array[i];
        }
        return max;
    }

    public static double avg(double[] array) {
        double sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        return sum / array.length;
    }

    public static double[] copyArray(double[] array) {
        double[] result = new double[array.length];
        for (int i = 0; i < array.length; i++) {
            result[i] = array[i];
        }
        return result;
    }

    public static void revert(double[] array) {
        int len = array.length;
        for (int i = 0; i < len; i++) {
            double temp = array[i];
            array[i] = array[len - 1 - i];
            array[len - 1 - i] = temp;
        }
    }

    public static void main(String[] args) {
        System.out.println(findMax(new double[]{12.3, 12.6, 1.03}));
    }
}
