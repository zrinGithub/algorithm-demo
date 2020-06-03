package chapter1;

import edu.princeton.cs.algs4.StdIn;

/**
 * Description:
 *
 * @author zhangr
 * 2020/6/2 14:50
 */
public class UnionFound3 {
    //id维护的是触电的值，也就是处在同一个连通分量的触点返回相同的整数值
    private int[] id;
    //记录深度
    private int[] height;
    private int count;

    public UnionFound3(int N) {
        count = N;
        //初始化数组
        id = new int[N];
        //这样初始化保证开始都不相同，也就是都是独立的触点
        for (int i = 0; i < N; i++)
            id[i] = i;

        //初始化每个点的深度
        height = new int[N];
        for (int i = 0; i < N; i++)
            height[i] = 1;
    }

    public int count() {
        return count;
    }

    public int find(int p) {
        //找到根节点
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

        //寻找高度比较低的，把低的树指向高的树
        if (height[pRoot] > height[qRoot]) {
            id[qRoot] = pRoot;
            height[pRoot] += height[qRoot];
        } else {
            id[pRoot] = qRoot;
            height[qRoot] += height[pRoot];
        }
        count--;
    }

    public static void main(String[] args) {
        UnionFound3 unionFound = new UnionFound3(12);
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
