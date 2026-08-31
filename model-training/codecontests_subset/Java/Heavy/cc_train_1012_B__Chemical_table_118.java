import java.io.BufferedReader;
// import java.io.FileInputStream;
// import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;
import java.util.StringTokenizer;

public class Main {
    FastScanner in;
    PrintWriter out;

    int[] parent;
    Random random = new Random();

    void dsuInit(int n) {
        parent = new int[n];
        for (int i = 0; i < n; i++)
            parent[i] = i;
    }

    int dsuGet(int v) {
        return v == parent[v] ? v : (parent[v] = dsuGet(parent[v]));
    }

    void dsuUnite(int a, int b) {
        a = dsuGet(a);
        b = dsuGet(b);

        if (a != b)
            if (random.nextBoolean())
                parent[a] = b;
            else
                parent[b] = a;
    }

    private void solve() throws IOException {
        int n = in.nextInt(), m = in.nextInt();
        int q = in.nextInt();

        if (q == 0) {
            out.println(n + m - 1);
            return;
        }

        dsuInit(n + m);
        int cnt = n + m;

        for (int i = 0, v, u; i < q; i++) {
            v = in.nextInt() - 1;
            u = in.nextInt() - 1 + n;
            if (dsuGet(v) != dsuGet(u)) {
                cnt--;
                dsuUnite(v, u);
            }
        }

        out.println(cnt - 1);
    }

    class FastScanner {
        StringTokenizer st;
        BufferedReader br;

        FastScanner(InputStream s) {
            br = new BufferedReader(new InputStreamReader(s));
        }

        String next() throws IOException {
            while (st == null || !st.hasMoreTokens())
                st = new StringTokenizer(br.readLine());
            return st.nextToken();
        }

        boolean hasNext() throws IOException {
            return br.ready() || (st != null && st.hasMoreTokens());
        }

        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        long nextLong() throws IOException {
            return Long.parseLong(next());
        }

        double nextDouble() throws IOException {
            return Double.parseDouble(next().replace(',', '.'));
        }

        String nextLine() throws IOException {
            return br.readLine();
        }

        boolean hasNextLine() throws IOException {
            return br.ready();
        }
    }

    private void run() throws IOException {
        in = new FastScanner(System.in); // new FastScanner(new FileInputStream(".in"));
        out = new PrintWriter(System.out); // new PrintWriter(new FileOutputStream(".out"));

        solve();

        out.flush();
        out.close();
    }

    public static void main(String[] args) throws IOException {
        new Main().run();
    }
}