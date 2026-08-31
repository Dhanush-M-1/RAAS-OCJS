import java.io.*;
import java.util.*;
 
/**
 * A simple template for competitive programming problems.
 */
public class Solution {
    //final InputReader in = new InputReader("input.txt");
    final InputReader in = new InputReader(System.in);
 
    final PrintWriter out = new PrintWriter(System.out);
 
    static final int MOD = 1000000007;
    void solve() {
        int T = in.nextInt();
        while(T-->0) {
            int n = in.nextInt();
            long l = in.nextLong();
            long r = in.nextLong();

            long start = 1L;
            int i = 1;
            while(i<=n) {
                start += 2*(n-i);
                i++;
                if(start>l) {
                    i--;
                    start -= 2*(n-i);
                    break;
                }
            }

            long firstStart = start;
            List<Integer> ans = new ArrayList<>();
            while(start<=r) {
                for(int j=i; j<n; j++) {
                    for(int k=j+1; k<=n; k++) {
                        ans.add(j);
                        start++;
                        ans.add(k);
                        start++;
                    }
                    if(start>r)
                        break;
                }
                if(start>r)
                    break;
                ans.add(1);
                start++;
            }

            for(int j=(int)(l-firstStart); j<=r-firstStart; j++) {
                out.print(ans.get(j) + " ");
            }
            out.println();
        }
    }
 
    public static void main(String[] args) throws FileNotFoundException {
        Solution s = new Solution();
        Long t1 = System.currentTimeMillis();
        s.solve();
        System.err.println(System.currentTimeMillis() - t1 + " ms");
        s.out.close();
    }
 
    public Solution() throws FileNotFoundException {
    }
 
    private static class InputReader {
        private final InputStream stream;
        private final byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;
 
        InputReader(InputStream stream) {
            this.stream = stream;
        }
 
        InputReader(String fileName) {
            InputStream stream = null;
            try {
                stream = new FileInputStream(fileName);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            this.stream = stream;
        }
 
        int[] nextArray(int n) {
            int[] arr = new int[n];
            for (int i = 0; i < n; i++)
                arr[i] = nextInt();
            return arr;
        }
 
        int[][] nextMatrix(int n, int m) {
            int[][] matrix = new int[n][m];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < m; j++)
                    matrix[i][j] = nextInt();
            return matrix;
        }
 
        String nextLine() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = read();
            } while (!isEndOfLine(c));
            return res.toString();
        }
 
        String nextString() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = read();
            } while (!isSpaceChar(c));
            return res.toString();
        }
 
        long nextLong() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            long res = 0;
            do {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }
 
        int nextInt() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            int res = 0;
            do {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }
 
        double nextDouble() {
            return Double.parseDouble(nextString());
        }
 
        private int read() {
            if (numChars == -1)
                throw new InputMismatchException();
            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = stream.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (numChars <= 0)
                    return -1;
            }
            return buf[curChar++];
        }
 
        private boolean isSpaceChar(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }
 
        private boolean isEndOfLine(int c) {
            return c == '\n' || c == '\r' || c == -1;
        }
    }
 
}