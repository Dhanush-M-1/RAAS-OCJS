import java.io.*;
import java.util.*;

public class Test {

    static int readInt() {
        int ans = 0;
        boolean neg = false;
        try {
            boolean start = false;
            for (int c = 0; (c = System.in.read()) != -1; ) {
                if (c == '-') {
                    start = true;
                    neg = true;
                    continue;
                } else if (c >= '0' && c <= '9') {
                    start = true;
                    ans = ans * 10 + c - '0';
                } else if (start) break;
            }
        } catch (IOException e) {
        }
        return neg ? -ans : ans;
    }

    static long readLong() {
        long ans = 0;
        boolean neg = false;
        try {
            boolean start = false;
            for (int c = 0; (c = System.in.read()) != -1; ) {
                if (c == '-') {
                    start = true;
                    neg = true;
                    continue;
                } else if (c >= '0' && c <= '9') {
                    start = true;
                    ans = ans * 10 + c - '0';
                } else if (start) break;
            }
        } catch (IOException e) {
        }
        return neg ? -ans : ans;
    }

    static String readLine() {
        StringBuilder b = new StringBuilder();
        try {
            boolean start = false;
            for (int c = 0; (c = System.in.read()) != -1; ) {
                if (Character.isLetterOrDigit(c)) {
                    start = true;
                    b.append((char)c);
                } else if (start) break;
            }
        } catch (IOException e) {
        }
        return b.toString();
    }

    static PrintWriter writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    long[] f = new long[234567];
    long[] s = new long[234567];
    int n;

    void add(int i, long v) {
        while (i <= n) {
            f[i] += v;
            i += (i & (-i));
        }
    }

    long sum(int i) {
        long sum = 0;
        while (i > 0) {
            sum += f[i];
            i -= (i & (-i));
        }
        return sum;
    }

    void start() {
        n = readInt();
        for (int i = 1; i <= n; i++) s[i] = readLong();
        for (int i = 1; i <= n; i++) add(i, i-1);
        int[] ans = new int[n+1];
        for (int i = n; i >= 1; i--) {
            int ll = 0, rr = n + 1;
            while (rr - ll > 1) {
                int mid = (rr + ll) / 2;
                long a = sum(mid);
                if (a <= s[i]) ll = mid;
                else rr = mid;
            }
            ans[i] = ll;
            add(ll+1, -ll);
        }
        for (int i = 1; i <= n; i++) writer.print(ans[i] + " ");
    }

    public static void main(String[] args) {
        Test te = new Test();
        te.start();
        writer.flush();
    }
}