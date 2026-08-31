import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.NoSuchElementException;

public class E {

    int N,M,K;
    int[] s,a;

    private void solve() {
        N = nextInt();
        M = nextInt();
        K = nextInt();

        s = new int[M];
        for(int i = 0;i < M;i++) {
            s[i] = nextInt();
        }
        a = new int[K + 1];
        for(int i = 1;i <= K;i++) {
            a[i] = nextInt();
        }

        boolean[] blocked = new boolean[N + 1];
        for(int i = 0;i < M;i++) {
            blocked[s[i]] = true;
        }

        int[] notBlockIndex = new int[N + 1];
        notBlockIndex[N] = N;
        int index = 0;
        for(int i = 0;i < N;i++) {
            if (!blocked[i]) {
                index = i;
            }
            notBlockIndex[i] = index;
        }

        long ans = Long.MAX_VALUE;
        for(int i = 1;i <= K;i++) {
            int now = 0;
            long count = 0;

            if (blocked[now]) {
                continue;
            }

            while(now < N) {
                int next = Math.min(N, now + i);
                int nextnext = notBlockIndex[next];

                if (now == nextnext) {
                    break;
                }
                now = nextnext;
                count++;
            }

            if (!blocked[now] && now >= N) {
                ans = Math.min(ans, count * a[i]);
            }
        }

        if (ans == Long.MAX_VALUE) {
            ans = -1;
        }
        out.println(ans);
    }

    public static void main(String[] args) {
        out.flush();
        new E().solve();
        out.close();
    }

    /* Input */
    private static final InputStream in = System.in;
    private static final PrintWriter out = new PrintWriter(System.out);
    private final byte[] buffer = new byte[2048];
    private int p = 0;
    private int buflen = 0;

    private boolean hasNextByte() {
        if (p < buflen)
            return true;
        p = 0;
        try {
            buflen = in.read(buffer);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (buflen <= 0)
            return false;
        return true;
    }

    public boolean hasNext() {
        while (hasNextByte() && !isPrint(buffer[p])) {
            p++;
        }
        return hasNextByte();
    }

    private boolean isPrint(int ch) {
        if (ch >= '!' && ch <= '~')
            return true;
        return false;
    }

    private int nextByte() {
        if (!hasNextByte())
            return -1;
        return buffer[p++];
    }

    public String next() {
        if (!hasNext())
            throw new NoSuchElementException();
        StringBuilder sb = new StringBuilder();
        int b = -1;
        while (isPrint((b = nextByte()))) {
            sb.appendCodePoint(b);
        }
        return sb.toString();
    }

    public int nextInt() {
        return Integer.parseInt(next());
    }

    public long nextLong() {
        return Long.parseLong(next());
    }

    public double nextDouble() {
        return Double.parseDouble(next());
    }
}