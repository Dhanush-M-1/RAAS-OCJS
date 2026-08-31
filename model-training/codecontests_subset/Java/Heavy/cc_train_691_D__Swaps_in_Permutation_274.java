import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class CF691D {
    static class DSU {
        private int[] parent, size;
        private int setsCnt;

        DSU(int n) {
            parent = new int[n];
            Arrays.setAll(parent, i -> i);
            size = new int[n];
            Arrays.fill(size, 1);
            setsCnt = n;
        }

        void union(int i, int j) {
            i = find(i);
            j = find(j);
            if (i == j)
                return;
            if (size[i] < size[j]) {
                int tmp = j;
                j = i;
                i = tmp;
            }
            parent[j] = i;
            size[i] += size[j];
            setsCnt--;
        }

        int find(int i) {
            if (i != parent[i])
                parent[i] = find(parent[i]);
            return parent[i];
        }

        boolean sameSet(int i, int j) {
            return find(i) == find(j);
        }

        int setsCnt() {
            return setsCnt;
        }

        int setSize(int i) {
            return size[find(i)];
        }

        TreeSet<Integer>[] sets() {
            TreeSet<Integer>[] sets = new TreeSet[parent.length];
            Arrays.setAll(sets, s -> new TreeSet<Integer>());
            for (int i = 0; i < parent.length; i++) {
                sets[find(i)].add(i);
            }
            return sets;
        }
    }

    public static void main(String[] args) throws IOException {
        FastScanner sc = new FastScanner();
        PrintWriter pw = new PrintWriter(System.out);
        int n = sc.nextInt(), m = sc.nextInt();
        int[] pos = new int[n];
        for (int i = 0; i < pos.length; i++) {
            pos[sc.nextInt() - 1] = i;
        }
        DSU dsu = new DSU(n);
        while (m-- > 0) {
            dsu.union(sc.nextInt() - 1, sc.nextInt() - 1);
        }
        TreeSet<Integer>[] sets = dsu.sets();
        int[] res = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            res[sets[dsu.find(pos[i])].pollFirst()] = i;
        }
        for (int r : res) {
            pw.print(r + 1 + " ");
        }
        pw.println();
        pw.flush();
    }

    static void solve() {
    }

    static class FastScanner {
        BufferedReader in;
        StringTokenizer st;

        public FastScanner() {
            this.in = new BufferedReader(new InputStreamReader(System.in));
        }

        public String nextToken() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(in.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(nextToken());
        }

        public long nextLong() {
            return Long.parseLong(nextToken());
        }

        public double nextDouble() {
            return Double.parseDouble(nextToken());
        }

        public void close() throws IOException {
            in.close();
        }
    }
}