/*******************************************************************************
 * author  : dante1
 * created : 16/02/2021 20:05
 *******************************************************************************/
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
// import java.math.BigInteger;
import java.util.*;

public class g {
    public static void main(String[] args) {
        int T = in.nextInt();
    TEST:
        while (T-- > 0) {
            int n = in.nextInt(), m = in.nextInt();
            long sum = 0, max = Long.MIN_VALUE;
            long[] a = new long[n];
            for (int i = 0; i < n; i++) {
                sum += in.nextInt();
                max = Math.max(sum, max);
                a[i] = max;
            }
            while (m-- > 0) {
                long x = in.nextInt(), t = -1;
                if (max >= x || sum > 0) {
                    long jump = 0;
                    if (max < x) {
                        jump = (x-max+sum-1)/sum;
                        x -= jump * sum;
                    }
                    t = jump * n + search(a, x);
                }
                out.print(t + " ");
            }
            out.println();
        }
        out.flush();
    }
    
    static int search(long[] arr, long target) {
        int lo = 0, hi = arr.length - 1;
        while (lo <= hi) {
            int mid = (lo + hi) >> 1;
            if (arr[mid] >= target) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }

    // Handle I/O
    static FastScanner in = new FastScanner();
    static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;
        public FastScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
            st = null;
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
}
