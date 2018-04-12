/**
 * 习题1.3.11
 * 
 * 1，一个栈负责存储结果，如果遇到一个运算符，弹出两个数进行运算，并结果进栈。
 * 2，最后剩余的一个数就是结果。
 * 
 * 原表达式：( 2 + ( ( 3 + 4 ) * ( 5 * 6 ) ) )
 * 后序输入：2 3 4 + 5 6 * * + 
 * 输出：212
 */

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class EvaluatePostfix
{
    public static void main(String[] args) {
        Stack<Integer> s = new Stack<Integer>();

        while (!StdIn.isEmpty()) {
            String str = StdIn.readString();

            if (str.equals("+")) {
                int numBack = s.pop();
                int numFront = s.pop();
                s.push(numFront + numBack);
            }
            else if (str.equals("*")) {
                int numBack = s.pop();
                int numFront = s.pop();
                s.push(numFront * numBack);
            }
            else {
                s.push(Integer.parseInt(str));
            }
        }

        StdOut.println(s.pop());
    }
}
