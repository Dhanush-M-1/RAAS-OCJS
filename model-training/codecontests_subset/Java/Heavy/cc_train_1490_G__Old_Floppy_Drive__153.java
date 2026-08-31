import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.util.Collections;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        FastReader in = new FastReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        GOldFloppyDrive solver = new GOldFloppyDrive();
        solver.solve(1, in, out);
        out.close();
    }

    static class GOldFloppyDrive {
        public void solve(int testNumber, FastReader in, PrintWriter out) {
            int t = in.nextInt();
            while (t-- > 0) {
                int n = in.nextInt();
                int m = in.nextInt();
                long[] a = new long[n];
                in.readArr(a);

                long[] sum = new long[n + 1];
                for (int i = 0; i < n; i++) {
                    sum[i + 1] = sum[i] + a[i];
                }

                List<Long> list = new ArrayList<>();
                List<Integer> indexList = new ArrayList<>();
                long max = 0;
                for (int i = 1; i <= n; i++) {
                    if (sum[i] > max) {
                        list.add(sum[i]);
                        indexList.add(i);
                        max = sum[i];
                    }
                }

                for (int i = 0; i < m; i++) {
                    long x = in.nextLong();
                    long ans = 0;
                    if (x > max) {
                        if (sum[n] <= 0) {
                            out.println(-1);
                            continue;
                        }
                        ans += n * (long) Math.ceil((x - max) / (1.0 * sum[n]));
                        x -= (long) Math.ceil((x - max) / (1.0 * sum[n])) * sum[n];
                    }
                    int p = Collections.binarySearch(list, x);
                    if (p >= 0) {
                        ans += indexList.get(p);
                    } else {
                        ans += indexList.get(-p - 1);
                    }
                    out.println(ans - 1);
                }


            }
        }

    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st = new StringTokenizer("");

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public FastReader(InputStream in) {
            br = new BufferedReader(new InputStreamReader(in));
        }

        public String next() {
            while (st == null || (!st.hasMoreElements())) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            return st.nextToken();
        }

        public void readArr(long[] a) {
            for (int i = 0; i < a.length; i++) {
                a[i] = nextLong();
            }
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

    }
}

