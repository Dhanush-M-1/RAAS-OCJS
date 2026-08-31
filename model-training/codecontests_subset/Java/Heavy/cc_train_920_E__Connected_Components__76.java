import java.io.*;
import java.util.*;

public class E3_Leo {
    /**********************************************************************************************
     *                                            DEBUG                                           *
     **********************************************************************************************/
    private final static boolean DEBUG = false;
    private final static String[] DEBUG_INPUT = {
            "5 5\n" +
                    "1 2\n" +
                    "3 4\n" +
                    "3 2\n" +
                    "4 2\n" +
                    "2 5",
            "2 0"
    };



    /**********************************************************************************************
     *                                             MAIN                                           *
     **********************************************************************************************/
    private static class Solver {

        public void solve(Reader in, PrintWriter out) throws IOException {
            int n = in.nextInt();
            int m = in.nextInt();
            int[] from = new int[m];
            int[] to = new int[m];
            int[] edgeCount = new int[n];
            for (int i = 0; i < m; i++) {
                from[i] = in.nextInt() - 1;
                to[i] = in.nextInt() - 1;
                edgeCount[from[i]]++;
                edgeCount[to[i]]++;
            }
            int[][] g = new int[n][];
            for (int i = 0; i < n; i++) g[i] = new int[edgeCount[i]];
            for (int i = 0; i < m; i++) {
                g[from[i]][--edgeCount[from[i]]] = to[i];
                g[to[i]][--edgeCount[to[i]]] = from[i];
            }
            for (int[] i : g) Arrays.sort(i);

            UF uf = new UF(n);
            int prev = -1;
            for (int i = 0; i < n; i++) {
                int[] set = g[i];
                if (set.length < n/2) {
                    if (prev == -1) prev = i;
                    uf.connect(prev, i);
                    prev = i;
                } else {
                    for (int j = 0; j < n; j++) {
                        if (Arrays.binarySearch(set, j) < 0) uf.connect(i, j);
                    }
                }
            }

            List<Integer> res = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                int parent = uf.parent[i];
                if (parent == i) res.add(uf.weight[i]);
            }
            Collections.sort(res);
            out.println(res.size());
            for (int i : res) out.print(i + " ");
        }
    }

    private static class UF {
        private int[] parent;
        private int[] weight; // weight optimization

        public UF(int n) {
            parent = new int[n];
            weight = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                weight[i] = 1;
            }
        }

        private int parent(int i) {
            int old = i;
            while (i != parent[i]) {
                parent[i] = parent[parent[i]];
                i = parent[i];
            }
            parent[old] = i; // path compression
            return i;
        }

        public void connect(int i, int j) {
            int pi = parent(i);
            int pj = parent(j);
            if (pi == pj) return;
            if (weight[pi] > weight[pj]) {
                parent[pj] = pi;
                weight[pi] += weight[pj];
            } else {
                parent[pi] = pj;
                weight[pj] += weight[pi];
            }
        }

        public boolean isConnected(int i, int j) {
            return parent(i) == parent(j);
        }
    }


    /**********************************************************************************************
     *                                           TEMPLATE                                         *
     **********************************************************************************************/
    public static void main(String[] args) throws IOException {
        PrintWriter out;
        Reader in;
        if (DEBUG) {
            for (String s : DEBUG_INPUT) {
                in = new Reader(new ByteArrayInputStream(s.getBytes()));
                out = new PrintWriter(System.out);
                out.println("===>>> INPUT");
                out.println(s + "\n");
                out.println("===>>> OUTPUT");
                long start = System.currentTimeMillis();
                new Solver().solve(in, out);
                long end = System.currentTimeMillis();
                out.println("\n");
                out.println("===========");
                out.println("Took: " + (end - start) + "ms");
                out.println("====================================================================");
                out.println();
                out.println();
                out.flush();
            }
        } else {
            in = new Reader(System.in);
            out = new PrintWriter(System.out);
            new Solver().solve(in, out);
            out.flush();
        }
    }

    /** Reader **/
    private static class Reader {
        private BufferedReader reader;
        private StringTokenizer tokenizer;

        public Reader(InputStream input) {
            reader = new BufferedReader(
                    new InputStreamReader(input));
            tokenizer = new StringTokenizer("");
        }

        private String nextWord() throws IOException {
            while (!tokenizer.hasMoreTokens()) {
                tokenizer = new StringTokenizer(reader.readLine());
            }
            return tokenizer.nextToken();
        }

        private int nextInt() throws IOException {
            return Integer.parseInt(nextWord());
        }

        private long nextLong() throws IOException {
            return Long.parseLong(nextWord());
        }

        private double nextDouble() throws IOException {
            return Double.parseDouble(nextWord());
        }
    }
}
