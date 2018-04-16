/**
 * 习题 1.3.45
 * 
 * 思路：根据输入计算栈中元素的数目，如果小于0，则会溢出。数字代表入栈，'-'代表出栈
 * 
 * 
 * Case 1: 0 1 2 3 4 - - - - 5 6 7 8 - - - - 
 * 此序列不会溢出。
 * Case 2: 0 1 2 3 4 - - - - 5 6 7 8 - - - - - - 
 * 此序列会溢出。
 */

import edu.princeton.cs.algs4.StdIn;

public class IsOutOfStack
{
    public static void main(String[] args) {
        boolean flag = true;
        int count = 0;

        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();
            if (s.equals("-")) {
                count--;
            }
            else {
                count++;
            }
            if (count < 0 ) {
                flag = false;
                break;
            }
        }
        if (flag) {
            System.out.println("此序列不会溢出。");
        }
        else {
            System.out.println("此序列会溢出。");
        }
        
    }
}