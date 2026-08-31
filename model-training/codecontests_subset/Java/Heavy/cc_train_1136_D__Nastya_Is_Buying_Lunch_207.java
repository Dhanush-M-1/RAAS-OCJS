import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;
import java.util.StringTokenizer;

import static java.lang.Math.min;
import static java.util.Arrays.fill;
import static java.util.Arrays.sort;
import static java.util.Collections.binarySearch;
import static java.util.Collections.sort;

public class Main {
    FastScanner in;
    PrintWriter out;

    private void solve() throws IOException {
        // solveA();
        // solveB();
        // solveC();
        solveD();
        // solveE();
    }

    private void solveA() throws IOException {
        int n = in.nextInt();
        long[] l = new long[n], r = new long[n];
        for (int i = 0; i < n; i++) {
            l[i] = in.nextLong();
            r[i] = in.nextLong();
        }
        long k = in.nextLong();
        for (int i = 0; i < n; i++) {
            if (r[i] >= k) {
                out.println(n - i);
                return;
            }
        }
    }

    private void solveB() throws IOException {
        long n = in.nextLong(), k = in.nextLong();
        out.println(n * 3 + min(n - k, k - 1));
    }

    private void solveC() throws IOException {
        int n = in.nextInt(), m = in.nextInt();
        int[][] a = new int[n][m], b = new int[n][m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                a[i][j] = in.nextInt();
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                b[i][j] = in.nextInt();

        ArrayList<Integer> A = new ArrayList<>(), B = new ArrayList<>();
        for (int v = 0; v < n + m; v++) {
            int i = 0, j = v;
            while (j >= 0) {
                if (i >= 0 && i < n && j >= 0 && j < m) {
                    A.add(a[i][j]);
                    B.add(b[i][j]);
                }
                i++;
                j--;
            }
            sort(A);
            sort(B);
            for (int k = 0; k < A.size(); k++) {
                if ((int) A.get(k) != B.get(k)) {
                    out.println("NO");
                    return;
                }
            }
            A.clear();
            B.clear();
        }


        out.println("YES");
    }

    private void solveD() throws IOException {
        int n = in.nextInt(), m = in.nextInt();
        int[] pos = new int[n];
        for (int i = 0; i < n; i++)
            pos[in.nextInt() - 1] = i;
        int x = n - 1;

        int[] v = new int[m], u = new int[m];
        int[] cnt = new int[n];
        for (int i = 0; i < m; i++) {
            v[i] = pos[in.nextInt() - 1];
            u[i] = pos[in.nextInt() - 1];
            cnt[v[i]]++;
            cnt[u[i]]++;
        }


        int[][] graph = new int[n][];
        for (int i = 0; i < n; i++)
            graph[i] = new int[cnt[i]];
        fill(cnt, 0);
        boolean[] good = new boolean[n];
        good[x] = true;
        for (int i = 0; i < m; i++) {
            graph[v[i]][cnt[v[i]]++] = u[i];
            if (u[i] == x)
                good[v[i]] = true;
        }

        int i = n - 1, ans = 0;
        boolean[] used = new boolean[n];
        while (i >= 0 && good[i]) {
            used[i--] = true;
            ans++;
        }

        int[] st = new int[n];
        int ss = 0;
        while (i >= 0) {
            if (good[i]) {
                shuffle(graph[i]);
                sort(graph[i]);
                int j = ss - 1;
                for (int w : graph[i])
                    if (w == st[j])
                        if (--j == -1)
                            break;

                if (j == -1)
                    ans++;
                else
                    st[ss++] = i;
            } else
                st[ss++] = i;
            i--;
        }

        out.println(ans - 1);
    }

    void shuffle(int[] a) {
        int b;
        Random r = new Random();
        for (int i = a.length - 1, j; i > 0; i--) {
            j = r.nextInt(i + 1);
            b = a[j];
            a[j] = a[i];
            a[i] = b;
        }
    }

    private void solveE() throws IOException {
        int n = in.nextInt();
        long[] a = new long[n];
        for (int i = 0; i < n; i++)
            a[i] = in.nextLong();
        long[] k = new long[n - 1];
        for (int i = 0; i < n - 1; i++)
            k[i] = in.nextLong();
        for (int q = in.nextInt(); q-- > 0; ) {
            if (in.next().charAt(0) == '+') {
                int i = in.nextInt() - 1;
                long x = in.nextLong();
                //
            } else {
                int l = in.nextInt() - 1, r = in.nextInt() - 1;
                //
            }
        }

    }

    private class FastScanner {
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
            return Double.parseDouble(next());
        }

        String nextLine() throws IOException {
            return br.readLine();
        }

        boolean hasNextLine() throws IOException {
            return br.ready();
        }

    }

    private void run() throws IOException {
        in = new FastScanner(System.in);
        out = new PrintWriter(System.out);

        solve();

        out.flush();
        out.close();
    }

    public static void main(String[] args) throws IOException {
        new Main().run();
    }
}