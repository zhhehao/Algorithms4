/**
 * 习题 1.3.45
 * 
 * 思路：线性模拟即可
 * 
 * 利用习题1.3.3来测试
 */

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class IsCorrectSeq 
{
    public static boolean isCorrectSeq(String seq) {
        String[] s = seq.split(" ");
        Queue<Integer> q1 = new Queue<Integer>();
        Queue<Integer> q2 = new Queue<Integer>();

        for (int i = 0; i < s.length; i++) {
            q1.enqueue(Integer.parseInt(s[i]));
            q2.enqueue(i);
        }

        Stack<Integer> stack = new Stack<Integer>();
        /*
         * 1，如果栈内有元素，先判断栈顶元素是否与q1序列相同
         * 2，若不同，则在q2中按顺序寻找，并把不相同的入栈
         * 3，若仍未找到，返回false
         * 4，若q2队列正常遍历，最后返回true
         */
        while (!q1.isEmpty()) {
            int item1 = q1.dequeue();
            boolean flag = false; // 标记为true表示找到，继续循环；否则，返回false
            if (!stack.isEmpty() && stack.peek() == item1) {
                stack.pop();
                continue;
            }
            while (!q2.isEmpty()) {
                int item2 = q2.dequeue();
                if (item2 == item1) {
                    flag = true;
                    break;
                }
                stack.push(item2);
            }
            if (!flag) // 未找到，返回false
                return false;
        }
        return true; // q2已经正常验证成功，返回true
    }

    public static void main(String[] args) {
        System.out.println(isCorrectSeq("4 3 2 1 0 9 8 7 6 5"));
        System.out.println(isCorrectSeq("4 6 8 7 5 3 2 9 0 1"));
        System.out.println(isCorrectSeq("2 5 6 7 4 8 9 3 1 0"));
        System.out.println(isCorrectSeq("4 3 2 1 0 5 6 7 8 9"));
        System.out.println(isCorrectSeq("1 2 3 4 5 6 9 8 7 0"));
        System.out.println(isCorrectSeq("0 4 6 5 3 8 1 7 2 9"));
        System.out.println(isCorrectSeq("1 4 7 9 8 6 5 3 0 2"));
        System.out.println(isCorrectSeq("2 1 4 3 6 5 8 7 9 0"));
    }
}