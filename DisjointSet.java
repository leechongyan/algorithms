class DisjointSet {

    private int[] parent;
    private byte[] rank;

    public DisjointSet(int n) {
        if (n < 0) throw new IllegalArgumentException();
        parent = new int[n];
        Arrays.fill(parent, -1);
        rank = new byte[n];
    }

    public int find(int x) {
        if (parent[x] == -1) return x;
        return parent[x] = find(parent[x]); // Path compression by halving.
    }

    // Return false if x, y are connected.
    public boolean union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX == rootY) return false;

        // Make root of smaller rank point to root of larger rank.
        if (rank[rootX] < rank[rootY]) parent[rootX] = rootY;
        else if (rank[rootX] > rank[rootY]) parent[rootY] = rootX;
        else {
            parent[rootX] = rootY;
            rank[rootY]++;
        }

        return true;
    }
}
