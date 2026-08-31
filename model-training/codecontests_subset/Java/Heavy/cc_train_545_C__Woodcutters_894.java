import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Task545C {
    StringTokenizer st;
    BufferedReader in;
    PrintWriter out;

    public static void main(String[] args) throws IOException {
        Task545C task = new Task545C();
        task.open();
        task.solve();
        task.close();
    }

    private void close() {
        out.close();
    }

    private void solve() throws IOException {
        int n = nextInt();
        long[] x = new long[n];
        long[] h = new long[n];

        for (int i = 0; i < n; i++) {
            x[i] = nextLong();
            h[i] = nextLong();

        }

        int s = 2;
        if (n == 1)
            s--;
        for (int i = 1; i < n - 1; i++) {

            if (x[i] - h[i] > x[i - 1])
                s++;
            else if (x[i] + h[i] < x[i + 1]) {
                s++;
                x[i] += h[i];
            }


        }
        out.println(s);
    }


    private void open() {
        in = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(System.out);
    }

    private String nextToken() throws IOException {
        while (st == null || !st.hasMoreTokens()) {
            String line = in.readLine();
            if (line == null) return null;
            st = new StringTokenizer(line);
        }
        return st.nextToken();
    }

    private int nextInt() throws IOException {
        return Integer.parseInt(nextToken());
    }

    private double nextDouble() throws IOException {
        return Double.parseDouble(nextToken());
    }

    private long nextLong() throws IOException {
        return Long.parseLong(nextToken());
    }
}
