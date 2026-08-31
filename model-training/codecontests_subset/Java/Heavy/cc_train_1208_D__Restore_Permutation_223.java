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

    int n;
    int S = 448;
    long[] blk = new long[S];
    long[] add = new long[S];
    long[] s = new long[234567];

    void init() {
        for (int i = 1; i <= n; i++) {
            int b = i/S;
            blk[b] = Math.min(blk[b], s[i]);
        }
    }

    void push(int b) {
        if (add[b] != 0) {
            for (int i = b*S; i < (b+1)*S; i++) s[i] += add[b];
            blk[b] += add[b];
            add[b] = 0;
        }
    }

    void add(int i, long v) {
        if (i > n) return;
        int b = i/S;
        int off = i % S;
        int bn = n/S;
        int noff = n % S;
        push(b);
        for (int j = b*S+off; j < b*S+S; j++) {
            s[j] += v;
            blk[b] = Math.min(blk[b], s[j]);
        }
        for (int j = b + 1; j < bn; j++) add[j] += v;
        if (b != bn) {
            push(bn);
            for (int j = bn*S; j <= bn*S+noff; j++) {
                s[j] += v;
                blk[bn] = Math.min(blk[bn], s[j]);
            }
        }
    }

    int zero() {
        int b = 1/S;
        int off = 1%S;
        int bn = n/S;
        int noff = n%S;
        push(bn);
        for (int i = bn*S+noff; i>= bn*S; i--)
            if (s[i] == 0) return i;
        for (int i = bn - 1; i > b; i--)
            if (blk[i] + add[i] == 0) {
                push(i);
                for (int j = i*S+S-1; j >= i*S; j--)
                    if (s[j] == 0) return j;
            }
        push(b);
        for (int i = b*S + S - 1; i >= b*S + off; i--)
            if (s[i] == 0) return i;
        return -1;
    }

    void clear(int i) {
        int b = i/S;
        push(b);
        s[i] = Long.MAX_VALUE;
        blk[b] = Long.MAX_VALUE;
        for (int j = b*S; j < b*S+S; j++) {
            blk[b] = Math.min(blk[b], s[j]);
        }
    }

    void start() {
        n  = readInt();
        Arrays.fill(blk, Long.MAX_VALUE);
        for (int i = 1; i <= n; i++) {
            long v = readLong();
            s[i] = v;
        }
        init();
        int[] ans = new int[n+1];
        for (int i = 1; i <= n; i++) {
            int j = zero();
            clear(j);
            ans[j] = i;
            add(j+1, -i);
        }
        for (int i = 1; i <= n; i++) writer.print(ans[i] + " ");
    }

    public static void main(String[] args) {
        Test te = new Test();
        te.start();
        writer.flush();
    }
}