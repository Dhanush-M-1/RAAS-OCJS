import java.util.*;
import java.io.*;

public class C {
    FastScanner in;
    PrintWriter out;

    public void solve() throws IOException {
        int n = in.nextInt();
        int m = in.nextInt();
        long[] w = new long[n];
        for (int i = 0; i < n; i++) {
            w[i] = in.nextInt();
        }
        int[] a = new int[m];
        for (int i = 0; i < m; i++) {
            a[i] = in.nextInt() - 1;
        }

        long ans = 0;
        for (int i = 0; i < m; i++) {
            boolean[] used = new boolean[n];
            for (int j = i - 1; j >= 0 && a[j] != a[i]; j--) {
                if (!used[a[j]]) {
                    used[a[j]] = true;
                    ans += w[a[j]];
                }
            }
            //out.println(ans);
        }
        out.println(ans);
    }

    public void run() {
        try {
            in = new FastScanner(System.in);
            out = new PrintWriter(System.out);

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
            try {
                br = new BufferedReader(new InputStreamReader(f));
            } catch (Exception e) {
                e.printStackTrace();
            }
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
        new C().run();
    }
}