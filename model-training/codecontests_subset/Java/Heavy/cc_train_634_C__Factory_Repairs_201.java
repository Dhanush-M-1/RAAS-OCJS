import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.io.IOException;
import java.util.InputMismatchException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskB solver = new TaskB();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskB {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int n = in.nextInt();
            int k = in.nextInt();
            int a = in.nextInt();
            int b = in.nextInt();
            int q = in.nextInt();
            Sum ga = new Sum(n, a);
            Sum gb = new Sum(n, b);
            for (int i = 0; i < q; ++i) {
                int cmd = in.nextInt();
                if (cmd == 1) {
                    int di = in.nextInt();
                    int ai = in.nextInt();
                    ga.add(di, ai);
                    gb.add(di, ai);
                } else {
                    int pi = in.nextInt();
                    long res = gb.get(1, pi - 1) + ga.get(pi + k, n);
                    out.println(res);
                }
            }
        }

        class Sum {
            int n;
            int x;
            long[] a;

            public Sum(int n, int x) {
                this.n = n;
                this.x = x;
                int N = 1;
                while (N < n) {
                    N *= 2;
                }
                a = new long[2 * N];
            }

            public void add(int x, int y) {
                int i = x + a.length / 2 - 1;
                a[i] += y;
                if (a[i] > this.x) {
                    a[i] = this.x;
                }
                while (i > 1) {
                    i /= 2;
                    a[i] = a[2 * i] + a[2 * i + 1];
                }
            }

            long get(int x, int y) {
                x += a.length / 2 - 1;
                y += a.length / 2 - 1;
                long res = 0;
                while (x < y) {
                    if (x % 2 == 1) {
                        res += a[x];
                        ++x;
                    }
                    if (y % 2 == 0) {
                        res += a[y];
                        --y;
                    }
                    x /= 2;
                    y /= 2;
                }
                if (x == y) {
                    res += a[x];
                }
                return res;
            }

        }

    }

    static class InputReader {
        BufferedReader bufReader;
        StringTokenizer stringTokenizer;
        boolean isEof = false;

        public InputReader(InputStream stream) {
            bufReader = new BufferedReader(new InputStreamReader(stream));
        }

        public String next() {
            while (stringTokenizer == null || !stringTokenizer.hasMoreTokens()) {
                try {
                    String line = bufReader.readLine();
                    if (line == null) {
                        isEof = true;
                        return null;
                    }
                    stringTokenizer = new StringTokenizer(line);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
            }
            return stringTokenizer.nextToken();
        }

        public int nextInt() {
            String s = next();
            if (s == null) {
                return 0;
            }
            return Integer.parseInt(s);
        }

    }
}

