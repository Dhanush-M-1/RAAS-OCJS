
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class D {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine().trim(), buffer[];
        buffer = line.split("\\s+");
        int N, M, Q;
        N = Integer.parseInt(buffer[0]);
        M = Integer.parseInt(buffer[1]);
        Q = Integer.parseInt(buffer[2]);
        UnionFind uf = new UnionFind(N + M);
        for (int i = 0; i < Q; i++) {
            line = br.readLine().trim();
            buffer = line.split("\\s+");
            int a = Integer.parseInt(buffer[0]) - 1;
            int b = Integer.parseInt(buffer[1]) - 1;
            uf.unite(a, b + N);
        }
        System.out.println(uf.getNumSets() - 1);
    }
}

class UnionFind {

    private int p[];
    private int size[];
    private int numSets;

    public UnionFind(int N) {
        size = new int[N];
        p = new int[N];
        numSets = N;
        for (int i = 0; i < N; i++) {
            p[i] = i;
            size[i] = 1;
        }
    }

    public int getNumSets() {
        return numSets;
    }

    public int find(int u) {
        return p[u] == u ? u : (p[u] = find(p[u]));
    }

    public boolean isSameSet(int u, int v) {
        return find(u) == find(v);
    }

    public void unite(int u, int v) {
        if (!isSameSet(u, v)) {
            int a = find(u), b = find(v);
            if (size[a] < size[b]) {
                int aux = a;
                a = b;
                b = aux;
            }
            numSets--;
            size[a] += size[b];
            p[b] = a;
        }
    }
}
