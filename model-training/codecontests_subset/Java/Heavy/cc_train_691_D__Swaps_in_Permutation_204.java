import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        FastScanner in = new FastScanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        new Main().run(in, out);
        out.close();
    }


    int N, M;
    int[] a;
    void run(FastScanner in, PrintWriter out) {
        N = in.nextInt();
        M = in.nextInt();
        a = new int[N];
        UF uf = new UF(N);

        for (int i = 0; i < N; i++) a[i] = in.nextInt();

        while (M-- > 0) {
            uf.merge(in.nextInt()-1, in.nextInt()-1);
        }

        for (int i = 0; i < N; i++) {
            int px = uf.findParent(i);
            if (uf.ts[px] == null) {
                out.print(a[i] + " ");
            } else {
                out.print(uf.ts[px].pollFirst() + " ");
            }
        }
        out.println();
    }

    class UF {
        int[] parent;
        int[] rank;
        TreeSet<Integer>[] ts;

        UF(int N) {
            parent = new int[N];
            rank = new int[N];
            ts = new TreeSet[N];
            for (int i = 0; i < N; i++) parent[i] = i;
        }

        int findParent(int x) {
            int init = x;
            while (x != parent[x]) x = parent[x];
            return parent[init] = x;
        }

        void merge(int x, int y) {
            int px = findParent(x);
            int py = findParent(y);
            if (px == py) return;

            int rx = rank[px];
            int ry = rank[py];
            if (rx <= ry) {
                parent[px] = py;
                if (rx == ry) rank[py]++;
                if (ts[py] == null) {
                    ts[py] = new TreeSet<>((n1, n2) -> n2-n1);
                    ts[py].add(a[y]);
                }
                if (ts[px] != null) ts[py].addAll(ts[px]);
                else ts[py].add(a[x]);

            } else {
                parent[py] = px;
                if (ts[px] == null) {
                    ts[px] = new TreeSet<>((n1, n2) -> n2-n1);
                    ts[px].add(a[x]);
                }
                if (ts[py] != null) ts[px].addAll(ts[py]);
                else ts[px].add(a[y]);
            }
        }


    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        public FastScanner(InputStream in) {
            br = new BufferedReader(new InputStreamReader(in));
            st = null;
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }
    }
}
