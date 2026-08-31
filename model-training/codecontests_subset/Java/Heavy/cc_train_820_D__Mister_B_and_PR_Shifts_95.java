import java.io.*;
import java.util.*;

/*
TASK: CFD
LANG: JAVA
 */
public class CFD {
    static int n , ac , bc, k , ind;
    static long min;
    static int[] p;
    static int[] inc;
    public static void main(String[] args) throws IOException {
        FastScanner in = new FastScanner(System.in);
        n = in.nextInt();
        p = new int[n];
        inc = new int[n];
        for(int i = 0;i < n; i++) {
            p[i] = in.nextInt()-1;
            if(p[i] > i){
                inc[i] = p[i] - i;
                ac++;
                min += p[i] - i;
            }
            else{
                inc[i] = n-i+p[i];
                bc++;
                min += i - p[i];
            }
        }
        Arrays.sort(inc);
        long cur = min;
        for(int i = 1;i < n; i++) {
            cur += bc-1;
            cur -= ac;
            cur += 2*p[n-i] - n+1;
            bc--;
            ac++;
            while (k < n && inc[k] == i) {
                k++;
                ac--;
                bc++;
            }
            if(cur < min){
                min = cur;
                ind = i;
            }
        }
        System.out.println(min + " " + ind);
    }

    private static class FastScanner {
        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;

        public FastScanner(InputStream stream) {
            this.stream = stream;
        }

        int read() {
            if (numChars == -1)
                throw new InputMismatchException();
            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = stream.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (numChars <= 0) return -1;
            }
            return buf[curChar++];
        }

        boolean isSpaceChar(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        boolean isEndline(int c) {
            return c == '\n' || c == '\r' || c == -1;
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

        public String next() {
            int c = read();
            while (isSpaceChar(c)) c = read();
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = read();
            } while (!isSpaceChar(c));
            return res.toString();
        }

        public String nextLine() {
            int c = read();
            while (isEndline(c))
                c = read();
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = read();
            } while (!isEndline(c));
            return res.toString();
        }
    }
}
