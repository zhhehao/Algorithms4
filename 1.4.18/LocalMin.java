/**
 * Local minimum of an array. Write a program that, given an array a[] of N distinct integers,
 * finds a local minimum: an index i such that botha[i] < a[i-1] and a[i] < a[i+1] 
 * (assuming the neighboring entry is in bounds). 
 * Your program should use ~2 lg N compares in the worst case.
 */

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class LocalMin
{
    public static int getLocalMin(int[] a, int left, int right) {
        if (right-left < 2) return -1;
        int mid = left + (right - left) / 2;
        if (mid >= a.length-1 || mid <= 0) {
            return -1;
        }
        if (a[mid] < a[mid-1] && a[mid] < a[mid+1]) {
            return mid;
        }
        int ret = getLocalMin(a, left, mid-1);
        if (ret > 0) return ret;
        ret = getLocalMin(a, mid+1, right);
        if (ret > 0) return ret;
        return -1;
    }
    public static void printArray(int[] a) {
        for (int i = 0; i < a.length; i++) {
            StdOut.print(a[i] + ",");
        }
        StdOut.println();
    }
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        int MAX = 1000;
        int[] a = new int[N];
        for(int i = 0; i < N; i++) {
            a[i] = StdRandom.uniform(0, MAX);
        }
        StdOut.println(getLocalMin(a, 0, N-1));
        printArray(a);
    }
}