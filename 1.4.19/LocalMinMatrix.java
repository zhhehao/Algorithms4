/**
 * Local minimum of a matrix. Given an N-by-N array a[] of N2 distinct integers, 
 * design an algorithm that runs in time proportional to N to find a local minimum: 
 * an pair of indices i and j such that a[i][j] < a[i+1][j], a[i][j] < a[i][j+1], 
 * a[i][j] < a[i-1][j], and a[i][j] < a[i][j-1] (assuming the neighboring entry is in bounds).
 * 
 * 
 * Hint: Find the minimum entry in row N/2, say a[N/2][j].
 * Check its two vertical neighbors a[N/2-1][j] and a[N/2+1][j].
 * Recur in the half with the smaller neighbor. In that half, find the minimum entry in column N/2.
 */

import edu.princeton.cs.algs4.StdRandom;

public class LocalMinMatrix
{
    static class Element
    {
        int i;
        int j;
        Element(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
    /**
     * 
     * @param a N*N Array
     * @param r1 row 1
     * @param r2 row 2
     * @param c1 col 1
     * @param c2 col 2
     * @param flag true: search from row; false: search from col.
     * 
     */

    public static void findMin(int[][] a, int r1, int r2, int c1, int c2, boolean flag, Element e_res) {
        if (r1 > r2 || c1 > c2) return;
        if (flag) {
            int row = r1 + (r2-r1)/2;
            int min = c1;
            for (int i = c1+1; i <= c2; i++) {
                if (a[row][i] < a[row][min]) {
                    min = i;
                }
            }
            if (a[row-1][min] > a[row][min] && a[row+1][min] > a[row][min]) {
                e_res.i = row;
                e_res.j = min;
                return;
            }
            else if (a[row-1][min] < a[row+1][min]) {
                findMin(a, r1, row-1, c1, c2, !flag, e_res);
                findMin(a, row+1, r2, c1, c2, !flag, e_res);
            }
            else {
                findMin(a, row+1, r2, c1, c2, !flag, e_res);
                findMin(a, r1, row-1, c1, c2, !flag, e_res); 
            }
        }
        else {
            int col = c1 + (c2-c1)/2;
            int min = r1;
            for (int i = r1+1; i <= r2; i++) {
                if (a[i][col] < a[min][col]) {
                    min = i;
                }
            }
            if (a[min][col-1] > a[min][col] && a[min][col+1] > a[min][col]) {
                e_res.i = min;
                e_res.j = col;
                return;
            }
            else if (a[min][col-1] < a[min][col+1]) {
                findMin(a, r1, r2, c1, col-1, !flag, e_res);
                findMin(a, r1, r2, col+1, c2, !flag, e_res);
            }
            else {
                findMin(a, r1, r2, col+1, c2, !flag, e_res);
                findMin(a, r1, r2, c1, col-1, !flag, e_res);
            }
        }
    }



    public static void main(String[] args) {
        int N = 1000;
        int[][] a = new int[N+2][N+2];
        
        for (int i = 0; i < N+2; i++) {
            for (int j = 0; j < N+2; j++) {
                a[i][j] = StdRandom.uniform(100);
            }
        }

        Element e_res = new Element(-1, -1);
        findMin(a, 1, N, 1, N, true, e_res);
        if (e_res.i == -1) {
            System.out.println("No match");
        }
        else {
            System.out.println("i: "+e_res.i+", j: "+e_res.j);
            System.out.println("Number is "+a[e_res.i][e_res.j]);
            System.out.println("Left number is "+a[e_res.i][e_res.j-1]);
            System.out.println("Right number is "+a[e_res.i][e_res.j+1]);
            System.out.println("Up number is "+a[e_res.i-1][e_res.j]);
            System.out.println("Down number is "+a[e_res.i+1][e_res.j]);

        }
    }
}

