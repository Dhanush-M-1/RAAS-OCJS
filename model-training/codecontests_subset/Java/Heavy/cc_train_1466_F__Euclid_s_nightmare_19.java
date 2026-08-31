import java.io.*;
import java.util.*;

/*
polyakoff
*/

public class Main {

    static FastReader in;
    static PrintWriter out;
    static Random rand = new Random();
    static final int oo = (int) 1e9 + 10;
    static final long OO = (long) 2e18 + 10;
    static final int MOD = (int) 1e9 + 7;
    static final int N = (int) 5e5 + 10;

    static int[] par;

    static int findSet(int v) {
        if (par[v] == v)
            return v;
        return par[v] = findSet(par[v]);
    }

    static void uniteSets(int v, int u) {
        v = findSet(v);
        u = findSet(u);
        if (v != u)
            par[u] = v;
    }

    static class Pair {
        int x1, x2;

        Pair(int x1, int x2) {
            this.x1 = x1;
            this.x2 = x2;
        }
    }

    static void solve() {
        int n = in.nextInt();
        int m = in.nextInt();

        int[][] a = new int[n][2];
        for (int i = 0; i < n; i++) {
            int k = in.nextInt();
            if (k == 1) {
                int x = in.nextInt();
                a[i][0] = x;
                a[i][1] = -1;
            } else {
                int x1 = in.nextInt();
                int x2 = in.nextInt();
                a[i][0] = x1;
                a[i][1] = x2;
            }
        }

        par = new int[m + 1];
        for (int v = 0; v < m + 1; v++) {
            par[v] = v;
        }

        TreeSet<Integer> s = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            if (a[i][1] == -1) {
                int x = a[i][0];
                if (findSet(x) != 0) {
                    uniteSets(0, x);
                    s.add(i);
                }
            } else {
                int x1 = a[i][0];
                int x2 = a[i][1];
                if (findSet(x1) != findSet(x2)) {
                    if (findSet(x1) == 0) {
                        uniteSets(0, x2);
                        s.add(i);
                    } else if (findSet(x2) == 0) {
                        uniteSets(0, x1);
                        s.add(i);
                    } else {
                        uniteSets(x1, x2);
                        s.add(i);
                    }
                }
            }
        }

        long ans = 1;
        for (int i = 0; i < s.size(); i++) {
            ans = (ans * 2) % MOD;
        }
        out.print(ans + " ");
        out.println(s.size());
        for (int i : s) {
            out.print((i + 1) + " ");
        }
        out.println();

    }


    public static void main(String[] args) {
        in = new FastReader();
        out = new PrintWriter(System.out);
//        fileInputOutput();

        int T = 1;
//        T = in.nextInt();
        while (T-- > 0)
            solve();

        out.flush();
        out.close();
    }

    static void fileInputOutput() {
        try {
            in = new FastReader("input.txt");
            out = new PrintWriter(new FileOutputStream("output.txt"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    static void runInThread() {
        Thread thread = new Thread(null, () -> {
            int T = 1;
//            T = in.nextInt();
            while (T-- > 0)
                solve();
        }, "thread1", 1 << 28);
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        FastReader() {
            this(System.in);
        }
        FastReader(String file) throws FileNotFoundException {
            this(new FileInputStream(file));
        }
        FastReader(InputStream is) {
            br = new BufferedReader(new InputStreamReader(is));
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
        String next() {
            while (st == null || !st.hasMoreTokens()) {
                st = new StringTokenizer(nextLine());
            }
            return st.nextToken();
        }
        String nextLine() {
            String line;
            try {
                line = br.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            return line;
        }
    }
}