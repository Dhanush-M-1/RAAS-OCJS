import java.util.*;
import java.io.*;

public class B {
    FastScanner in;
    PrintWriter out;

    void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    public void solve() throws IOException {
        int n = in.nextInt();
        int k = in.nextInt();
        if (k < n + 1 || n == 4) {
            out.println(-1);
            return;
        }
        int a = in.nextInt() - 1;
        int b = in.nextInt() - 1;
        int c = in.nextInt() - 1;
        int d = in.nextInt() - 1;

        int[] p = new int[n];
        boolean[] was = new  boolean[n];
        p[0] = a;
        p[1] = c;
        p[n - 2] = d;
        p[n - 1] = b;
        was[a] = was[b] = was[c] = was[d] = true;
        int cur = 0;
        for (int i = 2; i < n - 2; i++) {
            while (was[cur]) cur++;
            p[i] = cur++;
        }
        Arrays.stream(p).forEach(i -> out.print((i + 1) + " "));
        out.println();

        swap(p, 0, 1);
        swap(p, n - 2, n - 1);
        Arrays.stream(p).forEach(i -> out.print((i + 1) + " "));
        out.println();
    }

    public void run() {
        try {
            in = new FastScanner(System.in);
            out = new PrintWriter(System.out);
            Locale.setDefault(Locale.US);

            solve();

            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream f) {
            br = new BufferedReader(new InputStreamReader(f));
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }

    public static void main(String[] arg) {
        new B().run();
    }
}