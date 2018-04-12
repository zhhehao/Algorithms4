/**
 * 习题1.3.10
 * 1，一个栈负责存储运算符，遇见运算符就进栈，遇见右括号就出栈
 * 2，注意：本题不考虑括号的输出
 * 
 * 输入：( 2 + ( ( 3 + 4 ) * ( 5 * 6 ) ) )
 * 输出：2 3 4 + 5 6 * * + 
 * 输入：( ( 1 + 2 ) * ( ( 3 - 4 ) * ( 5 - 6 ) * ) )
 * 输出：1 2 + 3 4 - 5 6 - * *
 */

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class InfixToPostfix{
    public static void main(String[] args) {
        transOrder();
    }

    static void transOrder() {
        String strOps = "+-*/";
        Stack<String> ops = new Stack<String>();    

        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();
            if (s.equals("(")) {
                continue;
            }
            else if (strOps.contains(s)) {
                ops.push(s);
                continue;
            }
            else if (s.equals(")")) {
                StdOut.print(ops.pop() + " ");
                continue;
            }
            StdOut.print(s + " ");
        }
        StdOut.println();
    }
}

