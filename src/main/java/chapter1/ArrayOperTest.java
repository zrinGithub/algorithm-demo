package chapter1;


import java.util.Arrays;

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

    //这里没有验证参数
    public static double[][] matrixMultiplication(double[][] a, double[][] b) {
        int row = a.length;
        int col = b[0].length;
        int inner = b.length;
        double[][] result = new double[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                for (int k = 0; k < inner; k++) {
                    result[i][j] += a[i][k] * b[k][j];
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
//        System.out.println(findMax(new double[]{12.3, 12.6, 1.03}));
        double[][] a = {{1, 0, 2}, {-1, 3, 1}};
        double[][] b = {{3, 1}, {2, 1}, {1, 0}};
        final double[][] doubles = matrixMultiplication(a, b);
        for (int i = 0; i < doubles.length; i++) {
            final double[] inner = doubles[i];
            for (int j = 0; j < inner.length; j++)
                System.out.print(doubles[i][j]+"\t");
            System.out.println();
        }
    }
}
