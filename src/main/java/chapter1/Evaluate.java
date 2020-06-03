package chapter1;

import edu.princeton.cs.algs4.StdIn;

import java.util.Stack;

/**
 * Description:
 * 实际上。这个只适合于(1+(2*3))这种每次只有两个运算数，每次运算都有括号包裹的
 * 如果想要计算(1*32+3)*4这样的运算式，
 * 需要遇到运算的时候，比较和之前入栈的优先级，当前优先级低则计算之前的运算，最后运算符入栈
 * 需要把左括号也入栈，每次遇到右括号的时候，循环执行括号里面的内容直到peek到了左括号，最后移除左边括号
 * @author zhangr
 * 2020/5/29 10:12
 * }
 */
public class Evaluate {
    public static void main(String[] args) {
        //操作数栈
        Stack<Double> vals = new Stack<>();
        //运算符栈
        Stack<String> ops = new Stack<>();

        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();
            if ("+".equals(s) || "-".equals(s) || "*".equals(s) || "/".equals(s) || "sqrt".equals(s)) {
                ops.push(s);
            } else if ("(".equals(s)) {
            } else if (")".equals(s)) {
                String op = ops.pop();
                Double val = vals.pop();
                if ("+".equals(op)) val = vals.pop() + val;
                if ("-".equals(op)) val = vals.pop() - val;
                if ("*".equals(op)) val = vals.pop() * val;
                if ("/".equals(op)) val = vals.pop() / val;
                if ("sqrt".equals(op)) val = Math.sqrt(val);
                vals.push(val);
            } else if ("END".equals(s)) {
                System.out.println("result = " + vals.pop());
                break;
            } else {
                vals.push(Double.valueOf(s));
            }
        }
    }
}
