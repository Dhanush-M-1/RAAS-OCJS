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

    long[] min = new long[1234567];
    long[] add = new long[1234567];
    long[] s = new long[1234567];

    void push(int x) {
        if (add[x] != 0) {
            min[2*x] += add[x];
            add[2*x] += add[x];
            min[2*x+1] += add[x];
            add[2*x+1] += add[x];
            add[x] = 0;
        }
    }

    void pull(int x) {
        min[x] = Math.min(min[2*x], min[2*x+1]);
    }

    void build(int x, int ll, int rr) {
        if (ll == rr) {
            min[x] = s[ll];
            return;
        }
        int mid = (ll+rr)/2;
        build(2*x, ll, mid);
        build(2*x+1, mid+1, rr);
        pull(x);
    }

    void upd(int x, int ll, int rr, int i, int j, long d) {
        if (j < ll || rr < i) return;
        if (i <= ll && rr <= j) {
            add[x] += d;
            min[x] += d;
            return;
        }
        push(x);
        int mid = (ll + rr) / 2;
        upd(2*x, ll, mid, i, j, d);
        upd(2*x+1, mid+1, rr, i, j, d);
        pull(x);
    }

    int zero(int x, int ll, int rr) {
        if (rr < ll || min[x] > 0) return -1;
        if (ll == rr) return ll;
        push(x);
        int mid = (ll + rr) / 2;
        int ans = zero(2*x+1, mid + 1, rr);
        if (ans < 0) ans = zero(2*x, ll, mid);
        pull(x);
        return ans;
    }

    void start() {
        int n = readInt();
        for (int i = 1; i <= n; i++) {
            s[i] = readLong();
        }
        build(1, 1, n);
        int[] ans = new int[n+1];
        for (int i = 1; i <= n; i++) {
            int j = zero(1, 1, n);
            ans[j] = i;
            upd(1, 1, n, j,  j, Long.MAX_VALUE - s[j]);
            upd(1, 1, n, j+1, n, -i);
        }
        for (int i = 1; i <= n; i++) writer.print(ans[i] + " ");
    }

    public static void main(String[] args) {
        Test te = new Test();
        te.start();
        writer.flush();
    }
}