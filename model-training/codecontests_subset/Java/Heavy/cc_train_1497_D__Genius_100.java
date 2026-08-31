/**
 * author: derrick20
 * created: 3/20/21 4:40 PM
 */
import java.io.*;
import java.util.*;
import static java.lang.Math.*;

public class D_Genius {
    static FastScanner sc = new FastScanner();
    static PrintWriter out = new PrintWriter(System.out);
    
    public static void main(String[] args) {
        int T = sc.nextInt();
        cases: while (T-->0) {
            int N = sc.nextInt();
            int[] tags = new int[N];
            Arrays.setAll(tags, i -> sc.nextInt());
            long[] scores = new long[N];
            Arrays.setAll(scores, i -> sc.nextLong());
            long[] spiralDP = new long[N];
            for (int r = 1; r < N; r++) {
                long suffixToR = 0;
                for (int l = r - 1; l >= 0; l--) {
                    if (tags[l] != tags[r]) {
                        long prevToL = spiralDP[l];
                        long transition = abs(scores[r] - scores[l]);
                        spiralDP[l] = max(spiralDP[l], suffixToR + transition);
                        suffixToR = max(suffixToR, prevToL + transition);
                    }
                }
                spiralDP[r] = suffixToR;
            }
            long ans = 0;
            for (int end = 0; end < N; end++) {
                ans = max(ans, spiralDP[end]);
            }
            out.println(ans);
        }
        out.close();
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