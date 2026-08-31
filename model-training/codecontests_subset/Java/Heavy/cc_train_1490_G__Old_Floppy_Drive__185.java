import java.io.*;
import java.util.*;
 
/**
 * A simple template for competitive programming problems.
 */
public class Solution {
    //InputReader in = new InputReader("input.txt");
    final InputReader in = new InputReader(System.in);
 
    final PrintWriter out = new PrintWriter(System.out);
    final static char NULL = '\u0000';
    long[] preSum;
    void solve() {
        int t = in.nextInt();
        while(t-->0) {
            int n = in.nextInt();
            int m = in.nextInt();
            int[] arr = in.nextArray(n);
            int[] xarr = in.nextArray(m);
            List<Integer> stack = new ArrayList<>();
            preSum = new long[n]; preSum[0] = arr[0];
            for(int i=1; i<n; i++) {
                preSum[i] = preSum[i-1] + arr[i];
            }
            stack.add(0);
            for(int i=1; i<n; i++) {
                if(preSum[stack.get(stack.size()-1)]<preSum[i]) {
                    stack.add(i);
                }
            }
            for(int i=0; i<m; i++) {
                int x = xarr[i];
                int k = findFirstIndexGreaterOrEqual(stack, x);
                if(k!=stack.size()) {
                    out.print(stack.get(k) + " "); continue;
                }
                if(k==stack.size() && preSum[n-1]<=0) {
                    out.print(-1 + " "); continue;
                }
                int div = (int) ((x-preSum[stack.get(stack.size()-1)]+preSum[n-1]-1)/preSum[n-1]);
                int rem = (int) (x-(div*preSum[n-1]));
                k = findFirstIndexGreaterOrEqual(stack, rem);

                out.print((long) div*n + stack.get(k) + " ");
            }
            out.println();
         }
    }

    private int findFirstIndexGreaterOrEqual(List<Integer> stack, int x) {
        int lo = 0;
        int hi = stack.size();
        while(lo<hi) {
            int mid = lo + (hi-lo)/2;
            if(preSum[stack.get(mid)]<x) {
                lo = mid+1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }

    public static void main(final String[] args) throws FileNotFoundException {
        final Solution s = new Solution();
        final Long t1 = System.currentTimeMillis();
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

        InputReader(final InputStream stream) {
            this.stream = stream;
        }

        InputReader(final String fileName) {
            InputStream stream = null;
            try {
                stream = new FileInputStream(fileName);
            } catch (final FileNotFoundException e) {
                e.printStackTrace();
            }
            this.stream = stream;
        }

        int[] nextArray(final int n) {
            final int[] arr = new int[n];
            for (int i = 0; i < n; i++)
                arr[i] = nextInt();
            return arr;
        }

        int[][] nextMatrix(final int n, final int m) {
            final int[][] matrix = new int[n][m];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < m; j++)
                    matrix[i][j] = nextInt();
            return matrix;
        }

        String nextLine() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            final StringBuilder res = new StringBuilder();
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
            final StringBuilder res = new StringBuilder();
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
                } catch (final IOException e) {
                    throw new InputMismatchException();
                }
                if (numChars <= 0)
                    return -1;
            }
            return buf[curChar++];
        }

        private boolean isSpaceChar(final int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        private boolean isEndOfLine(final int c) {
            return c == '\n' || c == '\r' || c == -1;
        }
    }
 
}