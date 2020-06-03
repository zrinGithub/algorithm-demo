package chapter2;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Description:
 *
 * @author zhangr
 * 2020/6/3 16:57
 */
public class TestConvert {
    public static void main(String[] args) {
        String[] arrays = new String[]{"a", "b", "c"};
        List<String> listStrings = Stream.of(arrays).collect(Collectors.toList());
        System.out.println(listStrings);
    }
}
