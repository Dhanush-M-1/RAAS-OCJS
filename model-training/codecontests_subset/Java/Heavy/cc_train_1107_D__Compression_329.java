import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.FilterInputStream;
import java.io.BufferedInputStream;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author Jenish
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        ScanReader in = new ScanReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        DCompression solver = new DCompression();
        solver.solve(1, in, out);
        out.close();
    }

    static class DCompression {
        int n;
        int[][] arr;
        int[][] sum;

        public void solve(int testNumber, ScanReader in, PrintWriter out) {
            n = in.scanInt();
            arr = new int[n + 1][n + 1];
            sum = new int[n + 5][n + 5];


            for (int i = 1; i <= n; i++) {
                String str = in.scanString();
                int k = 1;
                for (int j = 0; j < n / 4; j++) {
                    int t[] = HEXtobiary(str.charAt(j));
                    for (int kk = 0; kk < 4; kk++) arr[i][k++] = t[kk];
                }
            }
            for (int i = 1; i <= n; i++)
                for (int j = 1; j <= n; j++)
                    sum[i][j] = arr[i][j];

            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    sum[i][j] += sum[i][j - 1];
                }
            }


            for (int j = 1; j <= n; j++) {
                for (int i = 1; i <= n; i++) {
                    sum[i][j] += sum[i - 1][j];
                }
            }


            long ans = -1;
            for (int i = 1; i * i <= n; i++) {
                if (n % i == 0) {
                    if (check(i)) {
                        ans = Math.max(ans, i);
                    }
                    if (check(n / i)) {
                        ans = Math.max(n / i, ans);
                    }
                }
            }

            out.println(ans);


        }

        boolean check(int size) {
            for (int i = size; i <= n; i += size) {
                for (int j = size; j <= n; j += size) {
                    int x1 = i - size + 1, y1 = j - size + 1;
                    int x2 = i, y2 = j;
                    long value = sum[x2][y2] - sum[x1 - 1][y2] - sum[x2][y1 - 1] + sum[x1 - 1][y1 - 1];
                    if (value == 0) {
                        continue;
                    } else if (value == (long) size * (long) size) {
                        continue;
                    } else {
                        return false;
                    }
                }
            }
            return true;

        }

        int[] HEXtobiary(char c) {
            if (c == '0') return new int[]{0, 0, 0, 0};
            if (c == '1') return new int[]{0, 0, 0, 1};
            if (c == '2') return new int[]{0, 0, 1, 0};
            if (c == '3') return new int[]{0, 0, 1, 1};
            if (c == '4') return new int[]{0, 1, 0, 0};
            if (c == '5') return new int[]{0, 1, 0, 1};
            if (c == '6') return new int[]{0, 1, 1, 0};
            if (c == '7') return new int[]{0, 1, 1, 1};
            if (c == '8') return new int[]{1, 0, 0, 0};
            if (c == '9') return new int[]{1, 0, 0, 1};
            if (c == 'A') return new int[]{1, 0, 1, 0};
            if (c == 'B') return new int[]{1, 0, 1, 1};
            if (c == 'C') return new int[]{1, 1, 0, 0};
            if (c == 'D') return new int[]{1, 1, 0, 1};
            if (c == 'E') return new int[]{1, 1, 1, 0};
            if (c == 'F') return new int[]{1, 1, 1, 1};

            return null;

        }

    }

    static class ScanReader {
        private byte[] buf = new byte[4 * 1024];
        private int INDEX;
        private BufferedInputStream in;
        private int TOTAL;

        public ScanReader(InputStream inputStream) {
            in = new BufferedInputStream(inputStream);
        }

        private int scan() {
            if (INDEX >= TOTAL) {
                INDEX = 0;
                try {
                    TOTAL = in.read(buf);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (TOTAL <= 0) return -1;
            }
            return buf[INDEX++];
        }

        public int scanInt() {
            int I = 0;
            int n = scan();
            while (isWhiteSpace(n)) n = scan();
            int neg = 1;
            if (n == '-') {
                neg = -1;
                n = scan();
            }
            while (!isWhiteSpace(n)) {
                if (n >= '0' && n <= '9') {
                    I *= 10;
                    I += n - '0';
                    n = scan();
                }
            }
            return neg * I;
        }

        public String scanString() {
            int c = scan();
            while (isWhiteSpace(c)) c = scan();
            StringBuilder RESULT = new StringBuilder();
            do {
                RESULT.appendCodePoint(c);
                c = scan();
            } while (!isWhiteSpace(c));
            return RESULT.toString();
        }

        private boolean isWhiteSpace(int n) {
            if (n == ' ' || n == '\n' || n == '\r' || n == '\t' || n == -1) return true;
            else return false;
        }

    }
}

