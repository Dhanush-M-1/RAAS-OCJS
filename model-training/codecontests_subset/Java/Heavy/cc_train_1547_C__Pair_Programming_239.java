import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.PrintStream;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author Sherlock108
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        FastReader in = new FastReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        CPairProgramming solver = new CPairProgramming();
        int testCount = Integer.parseInt(in.next());
        for (int i = 1; i <= testCount; i++)
            solver.solve(i, in, out);
        out.close();
    }

    static class CPairProgramming {
        public void solve(int testNumber, FastReader in, PrintWriter out) {
            int i, j, k;

            int K = in.nextInt(), N = in.nextInt(), M = in.nextInt();
            int[] A = in.getIntArray(N), B = in.getIntArray(M);

            int p1 = 0, p2 = 0;
            StringBuilder sb = new StringBuilder();
            while (p1 < N && p2 < M) {
                if (A[p1] == 0) {
                    ++K;
                    sb.append(A[p1++] + " ");
                } else if (B[p2] == 0) {
                    ++K;
                    sb.append(B[p2++] + " ");
                } else if (A[p1] < B[p2]) {
                    if (K < A[p1]) {
                        out.println(-1);
                        return;
                    }
                    sb.append(A[p1++] + " ");
                } else {
                    if (K < B[p2]) {
                        out.println(-1);
                        return;
                    }
                    sb.append(B[p2++] + " ");
                }
            }
            while (p1 < N) {
                if (A[p1] == 0) {
                    ++K;
                    sb.append(A[p1++] + " ");
                } else if (K < A[p1]) {
                    out.println(-1);
                    return;
                } else {
                    sb.append(A[p1++] + " ");
                }
            }
            while (p2 < M) {
                if (B[p2] == 0) {
                    ++K;
                    sb.append(B[p2++] + " ");
                } else if (K < B[p2]) {
                    out.println(-1);
                    return;
                } else {
                    sb.append(B[p2++] + " ");
                }
            }
            out.println(sb);
        }

    }

    static class FastReader {
        static final int BUFSIZE = 1 << 20;
        static byte[] buf;
        static int index;
        static int total;
        static InputStream in;

        public FastReader(InputStream is) {
            try {
                in = is;
                buf = new byte[BUFSIZE];
            } catch (Exception e) {
            }
        }

        private int scan() {
            try {
                if (index >= total) {
                    index = 0;
                    total = in.read(buf);
                    if (total <= 0)
                        return -1;
                }
                return buf[index++];
            } catch (Exception | Error e) {
                System.err.println(e.getMessage());
                return 13 / 0;
            }
        }

        public String next() {
            int c;
            for (c = scan(); c <= 32; c = scan()) ;
            StringBuilder sb = new StringBuilder();
            for (; c > 32; c = scan())
                sb.append((char) c);
            return sb.toString();
        }

        public int nextInt() {
            int c, val = 0;
            for (c = scan(); c <= 32; c = scan()) ;
            boolean neg = c == '-';
            if (c == '-' || c == '+')
                c = scan();
            for (; c >= '0' && c <= '9'; c = scan())
                val = (val << 3) + (val << 1) + (c & 15);
            return neg ? -val : val;
        }

        public int[] getIntArray(int size) {
            int[] ar = new int[size];
            for (int i = 0; i < size; ++i) ar[i] = nextInt();
            return ar;
        }

    }
}

