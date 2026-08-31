import java.io.*;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.StringTokenizer;

public class E {
    String fileName = "E";

    public int n, m, k;
    public boolean[] blocked;
    public long[] cost;
    public int[] left;

    public static final long INF = (long) 1e13;

    public void solve() throws IOException {
        FastScanner sc = new FastScanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();
        blocked = new boolean[n];
        left = new int[n];
        for (int i = 0; i < m; i++) {
            int block = sc.nextInt();
            blocked[block] = true;
        }
        for (int i = 0; i < n; i++) {
            if (blocked[i]) {
                if (i - 1 >= 0)
                    left[i] = left[i - 1];
                else
                    left[i] = -1;
            } else {
                left[i] = i;
            }
        }
        cost = new long[k];
        for (int i = 0; i < k; i++) {
            cost[i] = sc.nextLong();
        }
        long ans = INF;
        for (int power = 1; power <= k; power++) {
            int curCord = 0;
            int closed = -1;
            int cnt = 0;
            while (closed < n) {
                int from = left[curCord];
                if (from == -1)
                    break;
                int to = from + power;
                if (to <= closed) {
                    break;
                }
                closed = to;
                curCord = to;
                cnt++;
            }
            if (closed >= n) {
                ans = Math.min(ans, cost[power - 1] * (long) cnt);
            }
        }
        if (ans != INF) {
            out.print(ans);
        } else {
            out.print(-1);
        }
    }

    static class FastScanner extends BufferedReader {
        public FastScanner(InputStream is) {
            super(new InputStreamReader(is));
        }


        public int read() {
            try {
                return super.read();
            } catch (IOException e) {
                throw new InputMismatchException();
            }
        }

        static boolean isWhiteSpace(int c) {
            return c >= 0 && c <= 32;
        }

        public long nextLong() {
            int c = read();
            while (isWhiteSpace(c)) {
                c = read();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            long ret = 0;
            while (c >= 0 && !isWhiteSpace(c)) {
                if (c < '0' || c > '9') {
                    throw new NumberFormatException("digit expected " + (char) c
                            + " found");
                }
                ret = ret * 10L + c - '0';
                c = read();
            }
            return ret * sgn;
        }


        public int nextInt() {
            int c = read();
            while (isWhiteSpace(c)) {
                c = read();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            int ret = 0;
            while (c >= 0 && !isWhiteSpace(c)) {
                if (c < '0' || c > '9') {
                    throw new NumberFormatException("digit expected " + (char) c
                            + " found");
                }
                ret = ret * 10 + c - '0';
                c = read();
            }
            return ret * sgn;
        }

        public String readLine() {
            try {
                return super.readLine();
            } catch (IOException e) {
                return null;
            }
        }

    }

    public void run() {
        try {
            br = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(System.out);

            solve();

            out.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    BufferedReader br;
    StringTokenizer in;
    PrintWriter out;

    public String nextToken() throws IOException {
        while (in == null || !in.hasMoreTokens()) {
            in = new StringTokenizer(br.readLine());
        }
        return in.nextToken();
    }

    public int nextInt() throws IOException {
        return Integer.parseInt(nextToken());
    }

    public double nextDouble() throws IOException {
        return Double.parseDouble(nextToken());
    }

    public long nextLong() throws IOException {
        return Long.parseLong(nextToken());
    }

    public static void main(String[] args) throws IOException {
        Locale.setDefault(Locale.US);
        new E().run();
    }
}