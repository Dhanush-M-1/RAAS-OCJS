import java.io.*;
import java.util.*;
import static java.lang.System.out;

public class Main {
    static MyReader in = new MyReader();

    public static void main(String[] args) {
        char[] N = new char[100];
        int D = in.read(N, 0, 100);
        int K = in.i();
        int[][][] dp = new int[D + 1][K + 1][10];
        dp[0][0][0] = 1;

        for (int d = 1; d <= D; d++) {
            for (int k = 0; k <= K; k++) {
                for (int j = 0; j < 10; j++) {
                    dp[d][k][0] += dp[d - 1][k][j];
                }
                if (k > 0) {
                    for (int i = 1; i < 10; i++) {
                        for (int j = 0; j < 10; j++) {
                            dp[d][k][i] += dp[d - 1][k - 1][j];
                        }
                    }
                }
            }
        }

        int ans = 0;

        for (int d = D; d > 0; d--) {
            int n = N[D - d] - '0';
            for (int i = 0; i < n; i++) {
                ans += dp[d][K][i];
            }
            if (n != 0 && --K == -1) {
                break;
            }
        }
        if (K == 0) {
            ans++;
        }

        out.println(ans);
    }
}

class MyReader extends BufferedReader {
    char[] cbuf = new char[1024];
    int head = 0;
    int tail = 0;

    MyReader() {
        super(new InputStreamReader(System.in));
    }

    char next() {
        if (head == tail) {
            try {
                tail = super.read(cbuf, 0, cbuf.length);
            } catch (IOException e) {
                e.printStackTrace();
            }
            head = 0;
        }
        return cbuf[head++];
    }

    void back() {
        head--;
    }

    boolean minus() {
        boolean minus;
        while (true) {
            char c = next();
            if (!isDelimiter(c)) {
                if (!(minus = c == '-')) back();
                return minus;
            }
        }
    }

    void skip() {
        while (isDelimiter(next()));
        back();
    }

    char[] s(int N) {
        char[] cbuf = new char[N];
        read(cbuf, 0, N);
        return cbuf;
    }

    public int read(char[] cbuf, int off, int len) {
        skip();
        int i;
        for (i = 0; i < cbuf.length; i++) {
            char c = next();
            if (isDelimiter(c)) {
                break;
            }
            cbuf[i] = c;
        }
        return i;
    }

    boolean isDelimiter(char c) {
        return c == ' ' || c == '\n' || c == '\r';
    }

    int i() {
        boolean minus = minus();
        int n = 0;
        while (true) {
            int k = next() - '0';
            if (k < 0 || 9 < k) break;
            n = 10 * n + k;
        }
        return minus ? -n : n;
    }

    int[] ii(final int N) {
        int[] a = new int[N];
        for (int j = 0; j < a.length; j++) a[j] = i();
        return a;
    }

    long l() {
        boolean minus = minus();
        long n = 0;
        while (true) {
            int k = next() - '0';
            if (k < 0 || 9 < k) break;
            n = 10 * n + k;
        }
        return minus ? -n : n;
    }
}
