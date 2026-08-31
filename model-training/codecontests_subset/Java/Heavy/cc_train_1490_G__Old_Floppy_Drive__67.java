import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
1
3 3
1 -3 4
1 5 2
 */
public class problemG {
    static class Solution {
        void solve() {
            int n = fs.nextInt();
            int m = fs.nextInt();
            int[] a = new int[2*n];
            for (int i = 0 ; i < n ; i ++ ) {
                a[i] = a[i+n] = fs.nextInt();
            }
            n = 2 * n;
            long[] cs = new long[n];
            long[] mx = new long[n];
            long total = 0;
            for (int i = 0 ; i < n ; i ++ ) {
                cs[i] = (i == 0 ? 0 : cs[i-1]) + a[i];
                mx[i] = Math.max(cs[i], i == 0 ? Integer.MIN_VALUE : mx[i-1]);
                total += a[i];
            }
            total /= 2;

            long best = mx[n-1];

            int[] queries = fs.readArray(m);
            for (int x : queries) {
                if (x <= best) {
                    out.print(binsearch(x, mx));
                } else if (total > 0) {
                    long need = x - best;
                    long rounds = (need + total-1) / total;
                    need = x - (rounds * total);
                    out.print(rounds*n/2+binsearch(need, mx));
                } else {
                    out.print(-1);
                }
                out.print(' ');
            }
            out.println();
        }

        int binsearch(long x, long[] a) {
            int ans = a.length;
            for (int low = 0, high = a.length-1; low <= high; ) {
                int mid = (low+high)/2;
                if (a[mid] >= x) {
                    ans = Math.min(ans, mid);
                    high = mid-1;
                } else {
                    low = mid+1;
                }
            }
            return ans;
        }
    }

    public static void main(String[] args) throws Exception {
        int T = 1;
        T = fs.nextInt();
        Solution solution = new Solution();
        for (int t = 0; t < T; t++) solution.solve();
        out.close();
    }

    static void debug(Object... O) {
        System.err.println("DEBUG: " + Arrays.deepToString(O));
    }

    private static FastScanner fs = new FastScanner();
    private static PrintWriter out = new PrintWriter(System.out);

    static class FastScanner { // Thanks SecondThread.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");

        String next() {
            while (!st.hasMoreTokens())
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        int[] readArray(int n) {
            int[] a = new int[n];
            for (int i = 0; i < n; i++) a[i] = nextInt();
            return a;
        }

        long[] readLongArray(int n) {
            long[] a = new long[n];
            for (int i = 0; i < n; i++) a[i] = nextLong();
            return a;
        }

        ArrayList<Integer> readArrayList(int n) {
            ArrayList<Integer> a = new ArrayList<>(n);
            for (int i = 0 ; i < n; i ++ ) a.add(fs.nextInt());
            return a;
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextString() {
            return next();
        }
    }
}
