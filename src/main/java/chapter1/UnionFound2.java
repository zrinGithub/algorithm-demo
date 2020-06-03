package chapter1;

import edu.princeton.cs.algs4.StdIn;

/**
 * Description:
 *
 * @author zhangr
 * 2020/6/2 14:50
 * }
 */
public class UnionFound2 {
    //id维护的是触电的值，也就是处在同一个连通分量的触点返回相同的整数值
    private int[] id;
    private int count;

    public UnionFound2(int N) {
        count = N;
        //初始化数组
        id = new int[N];
        //这样初始化保证开始都不相同，也就是都是独立的触点
        for (int i = 0; i < N; i++)
            id[i] = i;
    }

    public int count() {
        return count;
    }

    public int find(int p) {
        while (p != id[p]) p = id[p];
        return p;
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    //将p和q归并到相同的分量之中
    public void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);

        if (pRoot == qRoot) return;

        id[pRoot] = qRoot;

        count--;
    }

    public static void main(String[] args) {
        UnionFound2 unionFound = new UnionFound2(12);
        while (!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if (unionFound.connected(p, q)) continue;
            unionFound.union(p, q);
            System.out.println(p + " " + q);
        }
        System.out.println(unionFound.count + " components.");
    }
}
