/**
 * Created by watson on 24.12.14.
 */
import java.util.*;
import java.io.*;

public class C {
    FastScanner in;
    PrintWriter out;



    public void solve() throws IOException {
        int n = in.nextInt();
        int m = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }

        int[] b = new int[m];
        int ans = 0;
        for (int i = 0; i < m; i++) {
            b[i] = in.nextInt();
            int j = i - 1;
            boolean[] f = new boolean[n];
            while ((j >= 0) && (b[j] != b[i])) {
                if (!f[b[j] - 1]) {
                    ans += a[b[j] - 1];
                    f[b[j] - 1] = true;
                }
                j--;
            }
        }
        System.out.println(ans);
    }



    public int nod(int a, int b) {
        if (b == 0) {
            return a;
        }
        return nod (b, a % b);
    }


    public boolean isIntersect(long x1, long y1, long x2, long y2, long a, long b, long c) {
        boolean t1 = (a * x1 + b * y1 + c) > 0;
        boolean t2 = (a * x2 + b * y2 + c) > 0;
        return t1 != t2;
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

        FastScanner(File f) {
            try {
                br = new BufferedReader(new FileReader(f));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

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

        String nextLine() {
            try {
                return br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
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
    }

    public static void main(String[] arg) {
        new C().run();
    }
}