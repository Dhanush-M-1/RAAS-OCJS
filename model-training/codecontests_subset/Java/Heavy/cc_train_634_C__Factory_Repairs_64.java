import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author ATailouloute
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        QuickScanner in = new QuickScanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskD solver = new TaskD();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskD {
        int a;
        int b;
        int[] st;
        int[] sta;
        int[] stb;

        public void solve(int testNumber, QuickScanner in, PrintWriter out) {
            int n = in.nextInt();
            int k = in.nextInt();
            a = in.nextInt();
            b = in.nextInt();
            int q = in.nextInt();
            st = new int[4 * n];
            sta = new int[4 * n];
            stb = new int[4 * n];

            for (int i = 0; i < q; i++) {
                int op = in.nextInt();
                if (op == 1) {
                    int di = in.nextInt() - 1;
                    int ai = in.nextInt();
                    update(1, 0, n - 1, di, di, ai);
                } else {
                    int pi = in.nextInt() - 1;
                    int before = 0, after = 0;
                    if (pi > 0) before = get_before(1, 0, n - 1, 0, pi - 1);
                    if (pi + k < n) after = get_after(1, 0, n - 1, pi + k, n - 1);
                    out.println(before + after);
                }
            }

        }

        int get_before(int node, int l, int r, int from, int to) {
            if (l > r || l > to || r < from) return 0;
            if (l >= from && r <= to) return stb[node];
            int mid = (l + r) >> 1;
            return get_before(node << 1, l, mid, from, to)
                    + get_before(node << 1 | 1, mid + 1, r, from, to);
        }

        int get_after(int node, int l, int r, int from, int to) {
            if (l > r || l > to || r < from) return 0;
            if (l >= from && r <= to) return sta[node];
            int mid = (l + r) >> 1;
            return get_after(node << 1, l, mid, from, to)
                    + get_after(node << 1 | 1, mid + 1, r, from, to);
        }

        void merge(int node) {
            sta[node] = sta[node << 1] + sta[node << 1 | 1];
            stb[node] = stb[node << 1] + stb[node << 1 | 1];
        }

        void update(int node, int l, int r, int from, int to, int ai) {
            if (l > r || l > to || r < from) return;
            if (l >= from && r <= to) {
                st[node] += ai;
                sta[node] = Math.min(a, st[node]);
                stb[node] = Math.min(b, st[node]);
                return;
            }
            int mid = (l + r) >> 1;
            update(node << 1, l, mid, from, to, ai);
            update(node << 1 | 1, mid + 1, r, from, to, ai);
            merge(node);
        }

    }

    static class QuickScanner {
        BufferedReader br;
        StringTokenizer st;
        InputStream is;

        public QuickScanner(InputStream stream) {
            is = stream;
            br = new BufferedReader(new InputStreamReader(stream), 32768);
        }

        public String nextToken() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return st.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(nextToken());
        }

    }
}

