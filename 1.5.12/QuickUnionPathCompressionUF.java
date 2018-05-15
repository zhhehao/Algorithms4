public class QuickUnionPathCompressionUF
{
    private int[] id;
    private int count;
    public QuickUnionPathCompressionUF(int N) {
        count = N;
        id = new int[N];
        for (int i = 0; i < N; i++) id[i] = i;
    }

    public int count() { return count; }

    public void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot == qRoot) return;
        id[pRoot] = qRoot;
        count--;
    }

    public int find(int p) {
        int tmp = p;
        while (p != id[p]) p = id[p];
        int root = p;
        p = tmp;
        while (p != root) {
            int next = id[p];
            id[p] = root;
            p = next;
        }
        return root;
    }

    boolean connected(int p, int q) { return find(p) == find(q); }
}