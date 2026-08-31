import java.io.*;
import java.util.*;

public class B {
    String fileName = "";

    public void solve() throws IOException {
        int n = nextInt();
        int s = nextInt();
        Integer[] a = new Integer[n];
        for (int i = 0; i < n; i++) {
            a[i] = nextInt();
        }
        Arrays.sort(a);
        int pos = n / 2;
        long ans = 0;
        if (a[pos] < s) {
            for (int i = pos; i < n; i++) {
                if (s - a[i] > 0)
                    ans += s - a[i];
            }
        } else {
            for (int i = pos; i >= 0; i--) {
                if (a[i] - s > 0)
                    ans += a[i] - s;
            }
        }
        out.print(ans);
    }

    public void run() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(System.out);
        solve();
        br.close();
        out.close();
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

    public static void main(String... args) throws IOException {
        new B().run();
    }
}
