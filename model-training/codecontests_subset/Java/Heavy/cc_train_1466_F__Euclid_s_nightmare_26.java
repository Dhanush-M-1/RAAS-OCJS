/**
 * author: derrick20
 * created: 12/30/20 11:14 AM
 */
import java.io.*;
import java.util.*;
import static java.lang.Math.*;

public class EuclidNightmare {
    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        PrintWriter out = new PrintWriter(System.out);
        
        int N = sc.nextInt();
        int M = sc.nextInt();
        id = new int[M + 1];
        hasPivot = new boolean[M + 1];
        Arrays.setAll(id, i -> i);
        long ans = 1;
        int size = 0;
        StringBuilder set = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            int k = sc.nextInt();
            if (k == 1) {
                int u = sc.nextInt();
                int ux = find(u);
                if (!hasPivot[ux]) {
                    hasPivot[ux] = true;
                    ans = 2 * ans % mod;
                    size++;
                    set.append(i).append(" ");
                }
            } else {
                int u = sc.nextInt();
                int v = sc.nextInt();
                int ux = find(u);
                int vx = find(v);
                if (ux != vx && !(hasPivot[ux] && hasPivot[vx])) {
                    unite(ux, vx);
                    ans = 2 * ans % mod;
                    size++;
                    set.append(i).append(" ");
                }
            }
        }
        out.println(ans + " " + size);
        out.println(set);
        out.close();
    }

    static int[] id;
    static boolean[] hasPivot;
    static long mod = (long) 1e9 + 7;

    static int find(int u) {
        return id[u] == u ? id[u] : (id[u] = find(id[u]));
    }

    static void unite(int u, int v) {
        if ((u = find(u)) != (v = find(v))) {
            id[v] = u;
            hasPivot[u] |= hasPivot[v];
        }
    }

    static class FastScanner {
        private int BS = 1 << 16;
        private char NC = (char) 0;
        private byte[] buf = new byte[BS];
        private int bId = 0, size = 0;
        private char c = NC;
        private double cnt = 1;
        private BufferedInputStream in;
    
        public FastScanner() {
            in = new BufferedInputStream(System.in, BS);
        }
    
        public FastScanner(String s) {
            try {
                in = new BufferedInputStream(new FileInputStream(new File(s)), BS);
            } catch (Exception e) {
                in = new BufferedInputStream(System.in, BS);
            }
        }
    
        char getChar() {
            while (bId == size) {
                try {
                    size = in.read(buf);
                } catch (Exception e) {
                    return NC;
                }
                if (size == -1) return NC;
                bId = 0;
            }
            return (char) buf[bId++];
        }
    
        int nextInt() {
            return (int) nextLong();
        }
    
        long nextLong() {
            cnt = 1;
            boolean neg = false;
            if (c == NC) c = getChar();
            for (; (c < '0' || c > '9'); c = getChar()) {
                if (c == '-') neg = true;
            }
            long res = 0;
            for (; c >= '0' && c <= '9'; c = getChar()) {
                res = (res << 3) + (res << 1) + c - '0';
                cnt *= 10;
            }
            return neg ? -res : res;
        }
    
        double nextDouble() {
            boolean neg = false;
            if (c == NC) c = getChar();
            for (; (c < '0' || c > '9'); c = getChar()) {
                if (c == '-') neg = true;
            }
            double cur = nextLong();
            if (c != '.') {
                return neg ? -cur : cur;
            } else {
                double frac = nextLong() / cnt;
                return neg ? -cur - frac : cur + frac;
            }
        }
    
        String next() {
            StringBuilder res = new StringBuilder();
            while (c <= 32) c = getChar();
            while (c > 32) {
                res.append(c);
                c = getChar();
            }
            return res.toString();
        }
    
        String nextLine() {
            StringBuilder res = new StringBuilder();
            while (c <= 32) c = getChar();
            while (c != '\n') {
                res.append(c);
                c = getChar();
            }
            return res.toString();
        }
    
        boolean hasNext() {
            if (c > 32) return true;
            while (true) {
                c = getChar();
                if (c == NC) return false;
                else if (c > 32) return true;
            }
        }
    }
    static void ASSERT(boolean assertion, String message) {
        if (!assertion) throw new AssertionError(message);
    }
    static void ASSERT(boolean assertion) {
        if (!assertion) throw new AssertionError();
    }
}