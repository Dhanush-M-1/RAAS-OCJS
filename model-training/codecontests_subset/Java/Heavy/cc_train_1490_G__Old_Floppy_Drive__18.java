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
 * @author Jaynil
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        GOldFloppyDrive solver = new GOldFloppyDrive();
        int testCount = Integer.parseInt(in.next());
        for (int i = 1; i <= testCount; i++)
            solver.solve(i, in, out);
        out.close();
    }

    static class GOldFloppyDrive {
        long[] st;
        long[] a;

        public void build(int l, int r, int sgt) {
            if (r - l < 0) return;
            if (r - l == 0) {
                st[sgt] = a[l];
                return;
            }
            int m = (l + r) / 2;
            build(l, m, sgt * 2 + 1);
            build(m + 1, r, sgt * 2 + 2);
            st[sgt] = Math.max(st[sgt * 2 + 1], st[sgt * 2 + 2]);
        }

        public int find(long x, int l, int r, int sgt) {
            if (r - l == 0) {
                return l;
            }
            int m = (l + r) / 2;
            if (st[sgt * 2 + 1] >= x) {
                return find(x, l, m, sgt * 2 + 1);
            } else {
                return find(x, m + 1, r, sgt * 2 + 2);
            }
        }

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int n = in.nextInt();
            int m = in.nextInt();
            a = new long[n];
            long max = Long.MIN_VALUE;
            long sum = 0;
            st = new long[Maths.stsize(n) + 10];
            for (int i = 0; i < n; i++) {
                a[i] = in.nextInt();
                if (i > 0) {
                    a[i] += a[i - 1];
                }
                max = Math.max(max, a[i]);
            }
            build(0, n - 1, 0);
            sum = a[n - 1];
            while (m-- > 0) {
                long x = in.nextInt();
                if (sum <= 0) {
                    if (x > max) {
                        out.print(-1 + " ");
                    } else {
                        out.print((find(x, 0, n - 1, 0)) + " ");
                    }
                } else {
                    long times = 0;
                    long l = 0;
                    long r = x / sum + 10;
                    while (l < r) {
                        long mm = (l + r) / 2;
                        if (mm * sum + max < x) {
                            l = mm + 1;
                        } else {
                            r = mm;
                        }
                    }
                    times = l;
                    out.print((n * times + find(x - times * sum, 0, n - 1, 0)) + " ");
                }
            }
            out.println();
        }

    }

    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

    }

    static class Maths {
        static int stsize(int n) {
            int x = (int) (Math.ceil(Math.log(n) / Math.log(2)));

            //Maximum size of segment tree
            int max_size = 2 * (int) Math.pow(2, x) - 1;
            return max_size;
        }

    }
}

