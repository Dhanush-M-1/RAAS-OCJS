import java.io.*;
import java.util.*;

public class Task {

    public static void main(String[] args) throws IOException {

        new Task().go();
    }

    PrintWriter out;
    Reader in;
    BufferedReader br;

    Task() throws IOException {

        try {

            //br = new BufferedReader( new FileReader("input.txt") );
            in = new Reader("input.txt");
            out = new PrintWriter( new BufferedWriter(new FileWriter("output.txt")) );
        }
        catch (Exception e) {

            //br = new BufferedReader( new InputStreamReader( System.in ) );
            in = new Reader();
            out = new PrintWriter( new BufferedWriter(new OutputStreamWriter(System.out)) );
        }
    }

    void go() throws IOException {

        int t = 1;
        while (t > 0) {
            solve();
            //out.println();
            t--;
        }

        out.flush();
        out.close();
    }

    int inf = 2000000000;
    int mod = 1000000007;
    double eps = 0.000000001;

    int n;
    int m;
    ArrayList<Integer>[] g;
    void solve() throws IOException {
        int n = in.nextInt();
        long[] dp = new long[10];
        Arrays.fill(dp, Long.MIN_VALUE);
        dp[0] = 0;

        for (int i = 0; i < n; i++) {
            int k = in.nextInt();

            long[][] f = new long[4][4];
            int[][] mx = new int[4][4];
            Pair[] best = new Pair[4];
            for (int x = 0; x < 4; x++) {
                Arrays.fill(f[x], Long.MIN_VALUE);
                Arrays.fill(mx[x], Integer.MIN_VALUE);
            }
            f[0][0] = 0;

            for (int j = 0; j < k; j++) {
                int c = in.nextInt();
                int d = in.nextInt();

                for (int x = 3; x > 0; x--)
                    for (int y = 3; y - c >= 0; y--) {
                        if (f[x][y] < f[x - 1][y - c] + d && f[x - 1][y - c] != Long.MIN_VALUE) {
                            f[x][y] = f[x - 1][y - c] + d;
                            mx[x][y] = Math.max(d, mx[x - 1][y - c]);
                        } else if (f[x][y] == f[x - 1][y - c] + d) {
                            mx[x][y] = Math.max(mx[x][y], Math.max(d, mx[x - 1][y - c]));
                        }
                    }
            }

            for (int x = 1; x < 4; x++)
                for (int y = 1; y < 4; y++)
                    if (best[x] == null || best[x].a < f[x][y])
                        best[x] = new Pair(f[x][y], mx[x][y]);

//            for (int x = 1; x < 4; x++)
//                System.err.println(best[x].a + " " + best[x].b);

            long[] tmp = new long[10];
            Arrays.fill(tmp, Long.MIN_VALUE);
            for (int x = 0; x < 10; x++) {
                for (int y = 1; y < 4; y++) {
                    long add = best[y].a;
                    if (dp[x] == Long.MIN_VALUE || add == Long.MIN_VALUE) continue;
                    if (x + y >= 10) add += best[y].b;
                    tmp[(x + y) % 10] = Math.max(tmp[(x + y) % 10], dp[x] + add);
                }
            }

            for (int x = 9; x >= 0; x--) {
                dp[x] = Math.max(dp[x], tmp[x]);
            }

            //System.err.println(dp[2][1]);

        }

        long ans = 0;
        for (int i = 0; i < 10; i++)
            ans = Math.max(ans, dp[i]);
        out.println(ans);
    }

    class Pair implements Comparable<Pair> {
        long a;
        int b;

        Pair(long a, int b) {
            this.a = a;
            this.b = b;
        }

        public int compareTo(Pair p) {
            if (a != p.a)
                return Long.compare(a, p.a);
            else
                return Integer.compare(b, p.b);
        }
    }

    class Item {

        int a;
        int b;
        int c;

        Item(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }

    }

    class Reader {

        BufferedReader  br;
        StringTokenizer tok;

        Reader(String file) throws IOException {
            br = new BufferedReader( new FileReader(file) );
        }

        Reader() throws IOException {
            br = new BufferedReader( new InputStreamReader(System.in) );
        }

        String next() throws IOException {

            while (tok == null || !tok.hasMoreElements())
                tok = new StringTokenizer(br.readLine());
            return tok.nextToken();
        }

        int nextInt() throws NumberFormatException, IOException {
            return Integer.valueOf(next());
        }

        long nextLong() throws NumberFormatException, IOException {
            return Long.valueOf(next());
        }

        double nextDouble() throws NumberFormatException, IOException {
            return Double.valueOf(next());
        }


        String nextLine() throws IOException {
            return br.readLine();
        }

        int[] nextIntArray(int n) throws IOException {
            int[] a = new int[n];
            for (int i = 0; i < n; i++)
                a[i] = nextInt();
            return a;
        }

        ArrayList<Integer>[] nextGraph(int n, int m) throws IOException {
            ArrayList<Integer>[] g = new ArrayList[n];
            for (int i = 0; i < n; i++)
                g[i] = new ArrayList<>();
            for (int i = 0; i < m; i++) {
                int x = nextInt() - 1;
                int y = nextInt() - 1;
                g[x].add(y);
                g[y].add(x);
            }

            return g;
        }

    }

}