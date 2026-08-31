import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashSet;
import java.util.InputMismatchException;

public class D {
    public static void main(String[] args) throws Exception {
        FastReader in = new FastReader(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        int n = in.nextInt(), m = in.nextInt();
        HashSet<Integer> set[] = new HashSet[n];
        int a[] = new int[n];
        int pos[] = new int[n + 1];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
            pos[a[i]] = i;
            set[i] = new HashSet<>();
        }
        for (int i = 0; i < m; i++) {
            int u = in.nextInt(), v = in.nextInt();
            if (pos[v] > pos[u]) {
                set[pos[u]].add(v);
            }
        }
        int ans = 0;
        ArrayDeque<Integer> g = new ArrayDeque<>();
        g.addLast(a[n - 1]);
        for (int i = n - 2; i >= 0; i--) {
            boolean ok = true;
            if (g.size() > set[i].size() || !set[i].contains(a[n-1])) {
                ok = false;
            } else {
                for (int k : g) {
                    if (!set[i].contains(k)) {
                        ok = false;
                        break;
                    }
                }
            }
            if (ok) ans++;
            else g.addLast(a[i]);
        }
        pw.println(ans);
        pw.close();
    }


    static class FastReader {
        InputStream is;
        private byte[] inbuf = new byte[1024];
        private int lenbuf = 0, ptrbuf = 0;

        public FastReader(InputStream is) {
            this.is = is;
        }

        public int readByte() {
            if (lenbuf == -1) throw new InputMismatchException();
            if (ptrbuf >= lenbuf) {
                ptrbuf = 0;
                try {
                    lenbuf = is.read(inbuf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (lenbuf <= 0) return -1;
            }
            return inbuf[ptrbuf++];
        }

        public int nextInt() {
            int num = 0, b;
            boolean minus = false;
            while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-')) ;
            if (b == '-') {
                minus = true;
                b = readByte();
            }
            while (true) {
                if (b >= '0' && b <= '9') {
                    num = (num << 3) + (num << 1) + (b - '0');
                } else {
                    return minus ? -num : num;
                }
                b = readByte();
            }
        }
    }
}