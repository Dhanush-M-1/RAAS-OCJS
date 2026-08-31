import java.io.*;
import java.util.*;

public class tmp1 {

    public static InputReader in;
    public static PrintWriter out;
    public static final int MOD = (int) (1e9 + 7);
    public static void main(String[] args) {
        in = new InputReader(System.in);
        out = new PrintWriter(System.out);
        
        int n = in.nextInt(),
                k = in.nextInt();
        int a = in.nextInt(),
                b = in.nextInt(),
                c = in.nextInt(),
                d = in.nextInt();
        int[] graph = new int[n];
        graph[0] = a;
        graph[1] = c;
        graph[n-2] = b;
        graph[n-1] = d;
        int idx = 0;
        int i = 2;
        while (i < n-2) {
            idx++;
            if(idx == a || idx == b || idx == c || idx == d)
                continue;
            graph[i] = idx;
            i++;
        }
        //out.println(Arrays.toString(graph));
        if(n == 4) {
            out.println(-1);
        } else if(k == n-1) {
            //if(((a == c && b == d) || (a == d && b == c))) {
                
            //} else
                out.println(-1);
        } else if(k == n) {
            //if(a == c || b == d || a == d || b == c) {
                
            //} else
                out.println(-1);
        } else if(k > n && n >= 5) {
            for (int j = 0; j < n-2; j++)
                out.print(graph[j] + " ");
            out.println(graph[n-1]+ " " + graph[n-2]);
            out.print(graph[1]+ " " + graph[0] + " ");
            for (int j = 2; j < n; j++)
                out.print(graph[j] + " ");
            out.println();
        } else 
            out.println(-1);
        out.close();
    }
    
    static class Node implements Comparable<Node>{
        int num, freq, idx;
        
        public Node (int u, int v, int idx) {
            this.num = u;
            this.freq = v;
            this.idx = idx;
        }
        
        public void print() {
            out.println(num + " " + freq + " " + idx);
        }
        
        public int compareTo(Node n) {
            if(this.freq == n.freq)
                return Integer.compare(this.num, n.num);
            return Integer.compare(-this.freq, -n.freq);
        }
    }
    
    static class InputReader {

        private InputStream stream;
        private byte[] buf = new byte[8192];
        private int curChar, snumChars;
        private SpaceCharFilter filter;

        public InputReader(InputStream stream) {
            this.stream = stream;
        }

        public int snext() {
            if (snumChars == -1)
                throw new InputMismatchException();
            if (curChar >= snumChars) {
                curChar = 0;
                try {
                    snumChars = stream.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (snumChars <= 0)
                    return -1;
            }
            return buf[curChar++];
        }

        public int nextInt() {
            int c = snext();
            while (isSpaceChar(c))
                c = snext();
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = snext();
            }
            int res = 0;
            do {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = snext();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public long nextLong() {
            int c = snext();
            while (isSpaceChar(c))
                c = snext();
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = snext();
            }
            long res = 0;
            do {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = snext();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public int[] nextIntArray(int n) {
            int a[] = new int[n];
            for (int i = 0; i < n; i++)
                a[i] = nextInt();
            return a;
        }

        public String readString() {
            int c = snext();
            while (isSpaceChar(c))
                c = snext();
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = snext();
            } while (!isSpaceChar(c));
            return res.toString();
        }

        public boolean isSpaceChar(int c) {
            if (filter != null)
                return filter.isSpaceChar(c);
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        public interface SpaceCharFilter {
            public boolean isSpaceChar(int ch);
        }
    }
}