package chapter2;


import java.util.*;
import java.util.stream.Collectors;

/**
 * Description:
 *
 * @author zhangr
 * 2020/6/3 16:02
 */
public class TestArray {
    public static void main(String[] args) {
        int[] a = {1 ,1, 2, 2, 3, 3};
        int[] b = {1, 2, 2, 4};
        int M = a.length;
        int N = b.length;
//        Arrays.stream(a).
        List<String> list = new ArrayList<>();
        list.stream().collect(Collectors.toSet());


        Map<Integer, Integer> aCount = new HashMap<>();
        Map<Integer, Integer> bCount = new HashMap<>();
        for (int i = 0; i < M; i++) {
            Integer v = aCount.get(a[i]);
            if (v != null)
                aCount.put(a[i], ++v);
            else
                aCount.put(a[i], 1);
        }
        for (int i = 0; i < N; i++) {
            Integer v = bCount.get(b[i]);
            if (v != null)
                bCount.put(b[i], ++v);
            else
                bCount.put(b[i], 1);
        }

        //求交集
        List<Integer> jj = new ArrayList<>();
        for (Map.Entry<Integer, Integer> aEntry : aCount.entrySet()) {
            Integer akey = aEntry.getKey();
            Integer aVal = aEntry.getValue();
            Integer bVal = bCount.get(akey);
            if (bVal != null) {
                //计算元素个数
                int count = aVal + bVal;
                while (count-- > 0)
                    jj.add(akey);
            }
        }

        //并集
        Set<Integer> aKeys = aCount.keySet();
        Set<Integer> bKeys = bCount.keySet();
        aKeys.addAll(bKeys);
        for(Integer key:aKeys){

        }

        System.out.println(jj);
    }
}
