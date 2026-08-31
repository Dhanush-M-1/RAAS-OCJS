import java.io.*;
import java.util.*;

/*
TASK: CFA
LANG: JAVA
 */
public class CFA {
    static String t;
    static String[] word;
    public static void main(String[] args) throws IOException {
        FastScanner in = new FastScanner(System.in);
        t = in.next();
        int n = in.nextInt();
        word = new String[n];
        for(int i = 0;i < n;i++)word[i] = in.next();
        for(int i = 0;i < n; i++){
            if(word[i].equals(t)){
                System.out.println("YES");
                return;
            }
        }
        for(int i = 0;i < n; i++){
            for(int j = 0;j < n; j++){
                if((word[i].charAt(1) + "" + word[j].charAt(0)).equals(t)){
                    System.out.println("YES");
                    return;
                }
            }
        }
        System.out.println("NO");
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
