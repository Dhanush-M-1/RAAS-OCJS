import java.io.*;
import java.math.BigInteger;
import java.util.*;

/*
Прокрастинирую
*/

public class Main {

    static FastReader in;
    static PrintWriter out;
    static Random rand = new Random();
    static final int INF = (int) (1e9 + 10), MOD = (int) (1e9 + 7), LOGN = 20;
    static final long IINF = (long) (2e18 + 10);
    static final int N = (int) (1e5 + 5);

    static int find(long[] arr, long x) {
        int l = 0, r = N - 5;
        while (l < r) {
            int m = (l + r) / 2;
            if (arr[m] < x) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return l;
    }

    static void solve() {
        int t = in.nextInt();

        long[] pre = new long[N];
        pre[0] = 1;
        for (int i = 1; i < N; i++) {
            pre[i] = pre[i - 1] + i * 2;
        }

        for (int tt = 0; tt < t; tt++) {
            int n = in.nextInt();
            long l = in.nextLong();
            long r = in.nextLong();
            long nn = (long) n * (n - 1) + 1;
            long l1 = nn + 1 - l;

            int bl = find(pre, l1);
            int lol1 = n - bl;
            int lol2 = lol1 + 1 + (int) ((pre[bl] - l1) / 2);
            int turn = 1;
            if ((pre[bl] - l1) % 2 == 1) {
                turn ^= 3;
            }

            for (long i = l; i <= Math.min(nn - 1, r); i++) {
                if (turn == 1) {
                    out.print(lol1 + " ");
                } else {
                    out.print(lol2 + " ");
                    lol2++;
                    if (lol2 > n) {
                        lol1++;
                        lol2 = lol1 + 1;
                    }
                }
                turn ^= 3;
            }
            if (r == nn) {
                out.print(1 + " ");
            }
            out.println();
        }

    }

    public static void main(String[] args) throws FileNotFoundException, InterruptedException {
        in = new FastReader(System.in);
//        in = new FastReader(new FileInputStream("input.txt"));
        out = new PrintWriter(System.out);
//        out = new PrintWriter(new FileOutputStream("output.txt"));

        Thread thread = new Thread(null, () -> {
            int tests = 1;
//            tests = in.nextInt();

            while (tests-- > 0) {
                solve();
            }
        }, "Go", 1 << 28);
        thread.start();
        thread.join();

//        out.flush();
        out.close();
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        FastReader(InputStream is) {
            br = new BufferedReader(new InputStreamReader(is));
        }

        Integer nextInt() {
            return Integer.parseInt(next());
        }

        Long nextLong() {
            return Long.parseLong(next());
        }

        Double nextDouble() {
            return Double.parseDouble(next());
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                st = new StringTokenizer(nextLine());
            }
            return st.nextToken();
        }

        String nextLine() {
            String s = "";
            try {
                s = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return s;
        }
    }
}