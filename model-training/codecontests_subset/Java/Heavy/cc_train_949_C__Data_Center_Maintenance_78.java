import java.io.*;
import java.lang.annotation.Retention;
import java.util.*;
import java.math.BigInteger;
import java.util.Map.Entry;

import static java.lang.Math.*;

public class C extends PrintWriter {

    int dfsOrder(int u, List<Integer>[] g, boolean[] color, int k, int[] order) {
        if (color[u]) {
            return k;
        }
        color[u] = true;

        for (int v : g[u]) {
            k = dfsOrder(v, g, color, k, order);
        }

        order[k++] = u;
        return k;
    }

    boolean dfsComp(int u, List<Integer>[] g, int c, int[] comp) {
        if (comp[u] != -1) {
            return false;
        }
        comp[u] = c;

        for (int v : g[u]) {
            dfsComp(v, g, c, comp);
        }

        return true;
    }

    void run() {

        int n = nextInt(), m = nextInt(), h = nextInt();
        int[] t = nextArray(n);

        List<Integer>[] g = new List[n];
        List<Integer>[] r = new List[n];

        for (int i = 0; i < n; i++) {
            g[i] = new ArrayList<>();
            r[i] = new ArrayList<>();
        }

        for (int e = 0; e < m; e++) {
            int u = nextInt() - 1;
            int v = nextInt() - 1;

            if ((t[u] + 1) % h == t[v]) {
                g[u].add(v);
                r[v].add(u);
            }

            if ((t[v] + 1) % h == t[u]) {
                g[v].add(u);
                r[u].add(v);
            }
        }

        int[] order = new int[n];
        boolean[] color = new boolean[n];

        int k = 0;

        for (int v = 0; v < n; v++) {
            k = dfsOrder(v, g, color, k, order);
        }

        int[] comp = new int[n];
        Arrays.fill(comp, -1);
        k = 0;

        for (int i = n - 1; i >= 0; i--) {
            int v = order[i];
            if (dfsComp(v, r, k, comp)) {
                ++k;
            }
        }

        int[] cs = new int[k];

        for (int i = 0; i < n; i++) {
            ++cs[comp[i]];
        }

        for (int u = 0; u < n; u++) {
            int x = comp[u];
            for (int v : g[u]) {
                int y = comp[v];
                if (x != y) {
                    cs[x] = n + 1;
                }
            }
        }

        int min = n + 1;
        int id = 0;

        for (int i = 0; i < k; i++) {
            int cur = cs[i];
            if (cur < min) {
                min = cur;
                id = i;
            }
        }

        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {

            if (id == (comp[i])) {
                ans.add(i);
            }
        }

        println(ans.size());
        for (int v : ans) {
            print((v + 1) + " ");
        }

    }

    boolean skip() {
        while (hasNext()) {
            next();
        }
        return true;
    }

    int[][] nextMatrix(int n, int m) {
        int[][] matrix = new int[n][m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                matrix[i][j] = nextInt();
        return matrix;
    }

    String next() {
        while (!tokenizer.hasMoreTokens())
            tokenizer = new StringTokenizer(nextLine());
        return tokenizer.nextToken();
    }

    boolean hasNext() {
        while (!tokenizer.hasMoreTokens()) {
            String line = nextLine();
            if (line == null) {
                return false;
            }
            tokenizer = new StringTokenizer(line);
        }
        return true;
    }

    int[] nextArray(int n) {
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = nextInt();
        }
        return array;
    }

    long[] nextLongArray(int n) {
        long[] array = new long[n];
        for (int i = 0; i < n; i++) {
            array[i] = nextLong();
        }
        return array;
    }

    int nextInt() {
        return Integer.parseInt(next());
    }

    long nextLong() {
        return Long.parseLong(next());
    }

    double nextDouble() {
        return Double.parseDouble(next());
    }

    String nextLine() {
        try {
            return reader.readLine();
        } catch (IOException err) {
            return null;
        }
    }

    public C(OutputStream outputStream) {
        super(outputStream);
    }

    static BufferedReader reader;
    static StringTokenizer tokenizer = new StringTokenizer("");
    static Random rnd = new Random();
    static boolean OJ;

    public static void main(String[] args) throws IOException {
        OJ = System.getProperty("ONLINE_JUDGE") != null;
        C solution = new C(System.out);
        if (OJ) {
            reader = new BufferedReader(new InputStreamReader(System.in));
            solution.run();
        } else {
            reader = new BufferedReader(new FileReader(new File(C.class.getName() + ".txt")));
            long timeout = System.currentTimeMillis();
            while (solution.hasNext()) {
                solution.run();
                solution.println();
                solution.println("----------------------------------");
            }
            solution.println("time: " + (System.currentTimeMillis() - timeout));
        }
        solution.close();
        reader.close();
    }
}