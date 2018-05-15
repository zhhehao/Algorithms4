import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class ErdosRenyi
{
    public static int count(int N) {
        WeightedQuickUnionByHeight uf = new WeightedQuickUnionByHeight(N);
        int cnt = 0;

        while (uf.count() > 1) {
            int p = StdRandom.uniform(N);
            int q = StdRandom.uniform(N);
            uf.union(p, q);
            cnt++;
        }
        return cnt;
    }

    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        int cnt = count(N);
        StdOut.println(cnt + " counts.");
    }
}