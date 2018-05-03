/**
 * Binary search with only addition and subtraction.[Mihai Patrascu] 
 * Write a program that, given an array of N distinct int values in ascending order, 
 * determines whether a given integer is in the array. 
 * You may use only additions and subtractions and a constant amount of extra memory. 
 * The running time of your program should be proportional to log N in the worst case.
 * 
 * Answer: Instead of searching based on powers of two (binary search), 
 * use Fibonacci numbers (which also grow exponentially). 
 * Maintain the current search range to be [i, i + F(k)] and keep F(k), F(k-1) in two variables.
 * At each step compute F(k-2) via subtraction, check element i + F(k-2), 
 * and update the range to either [i, i + F(k-2)] or [i + F(k-2), i + F(k-2) + F(k-1)].
 */

import edu.princeton.cs.algs4.StdRandom;

public class MiHaiPatrascu
{
    public static int search(int[] a, int key, int lo, int hi) {
        if (lo == hi && a[lo] == key) return lo;
        if (lo > hi) return -1;
        int f1 = 0;
        int f2 = 1;
        int sum = 0;
        int len = hi - lo;
        while (f2 < len) {
            sum = f1 + f2;
            f1 = f2;
            f2 = sum;
        }
        int ptr = lo + f1;
        System.out.println(a[ptr]);
        if (a[ptr] == key) return ptr;
        else if (a[ptr] > key) {
            int ret = search(a, key, lo, ptr-1);
            if (ret > 0) 
                return ret;
        }
        else {
            int ret = search(a, key, ptr+1, hi);
            if (ret > 0) 
                return ret;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] a = new int[10000];
        int num = 0;
        for (int i = 0; i < 10000; i++) {
            num += StdRandom.uniform(1, 10);
            a[i] = num;
        }
        int ret = search(a, 1000, 0, a.length-1);
        if (ret > 0) 
            System.out.println("Found it. a["+ret+"] = "+a[ret]);
        else
            System.out.println("No this number.");
    }
}