package chapter2;

/**
 * Description:
 * 堆排序
 *
 * @author zhangr
 * 2020/6/12 9:04
 */
public class Heap {
    private Heap() {
    }

    public static void sort(Comparable[] pq) {
        int N = pq.length;

        //构建堆
        //从右到左，下沉根节点，这里直接从N/2开始，也就是倒数第二层
        for (int k = N / 2; k >= 1; k--)
            sink(pq, k, N);

        //排序
        //首先把最大元素取放到最右
        //然后最前面的元素堆有序（就是堆删除最大元素的操作：之前的末尾元素放在首位开始下沉）
        int k = N;
        while (k > 1) {
            exch(pq, 1, k--);
            sink(pq, 1, k);
        }
    }

    public static void sink(Comparable[] pq, int k, int n) {
        while (2 * k <= n) {
            //子节点索引
            int j = 2 * k;
            //查询子节点中最大的元素
            if (j < n && less(pq, j, j + 1)) j++;
            //比较父节点和最大子节点，小于则交换
            if (!less(pq, k, j)) break;
            exch(pq, k, j);
            k = j;
        }
    }

    private static boolean less(Comparable[] pq, int i, int j) {
        return pq[i - 1].compareTo(pq[j - 1]) < 0;
    }

    private static void exch(Object[] pq, int i, int j) {
        Object temp = pq[i - 1];
        pq[i - 1] = pq[j - 1];
        pq[j - 1] = temp;
    }
}
