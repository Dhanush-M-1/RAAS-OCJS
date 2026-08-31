import java.io.*;
import java.util.*;

import static java.lang.Math.*;
import static java.util.Arrays.fill;
import static java.util.Arrays.sort;

public class Main {
    FastScanner in;
    PrintWriter out;

    private void solve() throws IOException {
        long n = in.nextLong(), k, c, d, max11, max12, max13, max2, max3, add, max;
        long[] dp = new long[10], next = new long[10];

        fill(next, -1);
        next[0] = 0;
        System.arraycopy(next, 0, dp, 0, 10);

        while (n-- > 0) {
            max11 = max12 = max13 = max2 = max3 = -1;

            k = in.nextLong();
            while (k-- > 0) {
                c = in.nextLong();
                d = in.nextLong();
                if (c == 1) {
                    if (d > max11) {
                        max13 = max12;
                        max12 = max11;
                        max11 = d;
                    } else if (d > max12) {
                        max13 = max12;
                        max12 = d;
                    } else
                        max13 = max(max13, d);
                } else if (c == 2) {
                    max2 = max(max2, d);
                } else if (c == 3) {
                    max3 = max(max3, d);
                } else
                    n = 1 / 0;
            }

            add = max = max(max11, max(max2, max3));
            for (int j = 0; j < 10; j++) {
                if (dp[j] != -1) {
                    if (j + 1 > 9) {
                        next[(j + 1) % 10] = max(next[(j + 1) % 10], dp[j] + add + max);
                    } else {
                        next[(j + 1) % 10] = max(next[(j + 1) % 10], dp[j] + add);
                    }
                }
            }

            if (max11 > 0 && max(max12, max2) > 0) {
                max = max(max11, max2);
                add = max11 + max(max12, max2);
                for (int j = 0; j < 10; j++) {
                    if (dp[j] != -1) {
                        if (j + 2 > 9) {
                            next[(j + 2) % 10] = max(next[(j + 2) % 10], dp[j] + add + max);
                        } else {
                            next[(j + 2) % 10] = max(next[(j + 2) % 10], dp[j] + add);
                        }
                    }
                }
            }

            if (max13 > 0) {
                for (int j = 0; j < 10; j++) {
                    if (dp[j] != -1) {
                        if (j + 3 > 9) {
                            next[(j + 3) % 10] = max(next[(j + 3) % 10], dp[j] + max11 * 2 + max12 + max13);
                        } else {
                            next[(j + 3) % 10] = max(next[(j + 3) % 10], dp[j] + max11 + max12 + max13);
                        }
                    }
                }
            }

            System.arraycopy(next, 0, dp, 0, 10);
        }

        long ans = -1;
        for (int i = 0; i < 10; i++)
            ans = max(ans, dp[i]);
        out.println(ans);
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
        in = new FastScanner(System.in); // new FastScanner(new FileInputStream(".in"));
        out = new PrintWriter(System.out); // new PrintWriter(new FileOutputStream(".out"));

        for (int t = 1; t-- > 0; )
            solve();

        out.flush();
        out.close();
    }

    public static void main(String[] args) throws IOException {
        new Main().run();
    }
}