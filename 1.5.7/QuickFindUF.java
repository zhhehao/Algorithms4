public class QuickFindUF
{
    private int[] id;
    private int count;
    public QuickFindUF(int N) {
        count = N;
        id = new int[N];
        for (int i = 0; i < N; i++) id[i] = i;
    }

    public int count() { return count; }

    public void union(int p, int q) {
        int pID = find(p);
        int qID = find(q);
        if (pID == qID) return;
        for (int i = 0; i < id.length; i++) {
            if (id[i] == pID) id[i] = qID;
        }
        count--;
    }

    public int find(int p) { return id[p]; }

    boolean connected(int p, int q) { return find(p) == find(q); }
}