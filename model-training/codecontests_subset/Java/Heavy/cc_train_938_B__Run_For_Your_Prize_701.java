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
        B_ED38 solver = new B_ED38();
        solver.solve(1, in, out);
        out.close();
    }

    static class B_ED38 {
        public void solve(int testNumber, ScanReader in, PrintWriter out) {
            int n = in.scanInt();
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = in.scanInt();
            }

            int point1 = 1;
            int point2 = 1000000;
            int j = 0;
            int k = n - 1;
            int ans = 0;


            for (int i = 0; i <= 1000000; i++) {
                if (point1 == arr[j]) {
                    j++;
                }
                if (point2 == arr[k]) {
                    k--;
                }
                if (j > k) {
                    break;
                }
                point1++;
                point2--;
                ans++;
            }


            out.println(ans);
        }

    }

    static class ScanReader {
        private byte[] buf = new byte[4 * 1024];
        private int index;
        private BufferedInputStream in;
        private int Total_Char;

        public ScanReader(InputStream inputStream) {
            in = new BufferedInputStream(inputStream);
        }

        private int scan() {
            if (index >= Total_Char) {
                index = 0;
                try {
                    Total_Char = in.read(buf);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (Total_Char <= 0) return -1;
            }
            return buf[index++];
        }

        public int scanInt() {
            int integer = 0;
            int n = scan();
            while (isWhiteSpace(n)) n = scan();
            int neg = 1;
            if (n == '-') {
                neg = -1;
                n = scan();
            }
            while (!isWhiteSpace(n)) {
                if (n >= '0' && n <= '9') {
                    integer *= 10;
                    integer += n - '0';
                    n = scan();
                }
            }
            return neg * integer;
        }

        private boolean isWhiteSpace(int n) {
            if (n == ' ' || n == '\n' || n == '\r' || n == '\t' || n == -1) return true;
            else return false;
        }

    }
}

