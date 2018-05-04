/**
 * Binary search with duplicates. 
 * Modify binary search so that it always returns the smallest (largest) 
 * index of a key of an item matching the search key.
 */
import edu.princeton.cs.algs4.StdRandom;
import java.util.Arrays;

public class BinarySearchWithDuplicates
{
    public static int binarySearch(int[] a, int key) {
        int lo = 0;
        int hi = a.length;

        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (a[mid] == key) {
                return findSmallestKey(a, mid);
            }
            else if (a[mid] > key) {
                hi = mid;
            }
            else {
                lo = mid;
            }
        }
        return -1;
    }

    public static int findSmallestKey(int[] a, int index) {
        while (index - 1 >= 0) {
            if (a[index] == a[index-1]) {
                index--;
            }
            else {
                break;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        int[] a = new int[100000];
        for (int i = 0; i < a.length; i++)
            a[i] = StdRandom.uniform(-10000, 10000);
        Arrays.sort(a);
        
        int index = binarySearch(a, 1234);
        if (index == -1) {
            System.out.println("Not found.");
        }
        else {
            int ptr = index;
            while (a[ptr] == a[index]) {
                System.out.println("a["+ptr+"] = "+a[ptr]);
                ptr++;
            }
        }    
    }
}