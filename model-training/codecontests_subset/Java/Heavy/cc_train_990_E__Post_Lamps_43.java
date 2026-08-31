import java.io.*;
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
        n = nextInt();
        m = nextInt();
        k = nextInt();
        blocked = new boolean[n];
        left = new int[n];
        for (int i = 0; i < m; i++) {
            int block = nextInt();
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
            cost[i] = nextLong();
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