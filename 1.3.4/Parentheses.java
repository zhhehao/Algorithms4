/**
 * 习题 1.3.4
 */

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

 public class Parentheses
 {
    public static void main(String[] args) {
        Stack<Character> charStack = new Stack<Character>(); 
        boolean flag = true;     
        
        while (!StdIn.isEmpty()) {
            char ch = StdIn.readChar();
            if (ch == '(' || ch == '[' || ch == '{') {
                charStack.push(ch);
            }
            else {
                if (!charStack.isEmpty()) {
                    char chInStack = charStack.pop();
                    if ((ch=='(' && chInStack!=')') || (ch=='[' && chInStack!=']') || (ch=='{' && chInStack!='}')) {
                        flag = false;
                        break;
                    }
                }
                else {
                    flag = false;
                    break;
                }   
            }
        }

        StdOut.println(flag);
    }
 }