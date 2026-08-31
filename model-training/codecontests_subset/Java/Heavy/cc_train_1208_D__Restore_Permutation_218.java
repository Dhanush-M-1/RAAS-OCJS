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
    int[] idx = new int[1234567];

    void push(int x) {
        if (add[x] != 0) {
            add[2*x] += add[x];
            add[2*x+1] += add[x];
            add[x] = 0;
        }
    }

    void pull(int x) {
        if (min[2*x] + add[2*x] < min[2*x+1] + add[2*x+1]) {
            min[x] = min[2*x] + add[2*x];
            idx[x] = idx[2*x];
        } else {
            min[x] = min[2*x+1] + add[2*x+1];
            idx[x] = idx[2*x+1];
        }
    }

    void set(int x, int ll, int rr, int i, long v) {
        if (i < ll || i > rr) return;
        if (ll == rr) {
            add[x] = 0;
            min[x] = v;
            idx[x] = x;
            return;
        }
        int mid = (ll+rr)/2;
        push(x);
        set(2*x, ll, mid, i, v);
        set(2*x+1, mid+1, rr, i, v);
        pull(x);
    }

    void upd(int x, int ll, int rr, int i, int j, long d) {
        if (j < ll || rr < i) return;
        if (i <= ll && rr <= j) {
            add[x] += d;
            return;
        }
        push(x);
        int mid = (ll + rr) / 2;
        upd(2*x, ll, mid, i, j, d);
        upd(2*x+1, mid+1, rr, i, j, d);
        pull(x);
    }

    int zero(int x, int ll, int rr) {
        if (rr < ll || min[x] + add[x] > 0) return -1;
        if (ll == rr) return ll;
        push(x);
        int mid = (ll + rr) / 2;
        int ans = zero(2*x+1, mid + 1, rr);
        if (ans >= 0) return ans;
        return zero(2*x, ll, mid);
    }

    void start() {
        Arrays.fill(min, Long.MAX_VALUE);
        int n = readInt();
        for (int i = 1; i <= n; i++) {
            long v = readLong();
            set(1, 1, n, i, v);
        }

        int[] ans = new int[n+1];
        for (int i = 1; i <= n; i++) {
            int j = zero(1, 1, n);
            ans[j] = i;
            set(1, 1, n, j, Long.MAX_VALUE);
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