/**
 * An array is bitonic if it is comprised of an increasing sequence of integers followed 
 * immediately by a decreasing sequence of integers. Write a program that, given 
 * a bitonic array of N distinct int values, determines whether a given integer is 
 * in the array. Your program should use ~ 3 lg N compares in the worst case.
 * 
 * 
 * Answer: Use a version of binary search, as in BitonicMax.java, 
 * to find the maximum (in ~ 1 lg N compares); then use binary search to 
 * search in each piece (in ~ 1 lg N compares per piece).
 */

import edu.princeton.cs.algs4.StdRandom;

 public class BitonicSearch
 {
    public static int findBorder(int[] a) {
        int lo = 1; 
        int hi = a.length - 2;
        // 二分法查找最大值 ~logN
        while (lo <= hi) {
            int mid = lo +(hi - lo) / 2;
            if (a[mid] > a[mid-1] && a[mid] > a[mid+1]) {
                return mid;
            }
            else if (a[mid] > a[mid-1] && a[mid] < a[mid+1]) {
                lo = mid+1;
            }
            else if (a[mid] < a[mid-1] && a[mid] > a[mid+1]) {
                hi = mid-1;
            }
        }

        return -2;
    }

    public static int isInSeq(int[]a, int key) {
        int border = findBorder(a);
        // System.out.println(border+" "+a[border-1]+" "+a[border]+" "+a[border+1]);
        if (border == -2) {
            return -2;
        }
        if (key == a[border]) {
            return border;
        }
        // 二分法查左半边 ~logN
        {
            int lo = 0; 
            int hi = border-1;
            while (lo < hi) {
                int mid = lo + (hi-lo) / 2;
                if (a[mid] == key) {
                    return mid;
                }
                else if (a[mid] > key) {
                    hi = mid - 1;
                    if (hi >= 0 && a[hi] < key) break;
                }
                else if (a[mid] < key) {
                    lo = mid + 1;
                    if (a[lo] > key) break;
                }
            }
        }
        // 二分法查右半边 ~logN
        {
            int lo = border + 1;
            int hi = a.length - 1;
            while (lo < hi) {
                int mid = lo + (hi-lo) / 2;
                if (a[mid] == key) {
                    return mid;
                }
                else if (a[mid] < key) {
                    hi = mid - 1;
                    if (a[hi] > key) break;
                }
                else if (a[mid] > key) {
                    lo = mid + 1;
                    if (lo < a.length && a[lo] < key) break;
                }
            }
        }


        return -1;
    }

    public static void main(String[] args) {
        int[] a = new int[1000];
        int border = StdRandom.uniform(101, 900);
        int number = 1;

        // 为简化代码，测试用例并未严格数字唯一
        for (int i = 0; i < border; i++) {
            number += StdRandom.uniform(1, 10);
            a[i] = number;
        }

        int max = a[border-1];

        for (int i = border; i < a.length; i++) {
            number -= StdRandom.uniform(1, 10);
            a[i] = number;
        }

        int min = 1 < a[a.length-1] ? 1 : a[a.length-1];

        int key = StdRandom.uniform(min, max);
        // System.out.println(min+"::"+max+"::"+key);
        int res = isInSeq(a, key);
        // for (int i = 0; i < a.length; i++) {
        //     System.out.print(a[i]+",");
        // }
        // int res = -1;
        if (res == -1) {
            System.out.println("key:" + key + ". Not found.");
        }
        else if (res == -2) {
            System.out.println("Some bugs in code, correct it now!");
        }
        else {
            System.out.println("Found it.");
            System.out.println("index is "+res+", value is "+a[res]+".");
        }
    }
 }