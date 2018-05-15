import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class WeightedQuickUnionByHeight
{
    private int[] id;
    private int[] th;
    private int count;

    public WeightedQuickUnionByHeight(int N) {
        count = N;
        id = new int[N];
        th = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
            th[i] = 1;
        }
    }

    public int count() { return count; }

    public boolean connected(int p, int q) { return find(p) == find(q); }

    public int find(int p) {
        while(p != id[p]) p = id[p];
        return p;
    }

    public void union(int p, int q) {
        int i = find(p);
        int j = find(q);
        if (i == j) return;
        if (th[i] < th[j]) { id[i] = j; }
        else if (th[i] == th[j]) { id[i] = j; th[j]++; }
        else { id[j] = i; }
        count--;
    }

    public static void main(String[] args) {
        int N = StdIn.readInt();
        WeightedQuickUnionByHeight uf = new WeightedQuickUnionByHeight(N);
        while (!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if (uf.connected(p, q)) continue;
            uf.union(p, q);
            StdOut.println(p + " " + q);
        }
        StdOut.println(uf.count() + " components");
    }
}