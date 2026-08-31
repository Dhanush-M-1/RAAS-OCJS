import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.io.IOException;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        CWeaknessAndPoorness solver = new CWeaknessAndPoorness();
        solver.solve(1, in, out);
        out.close();
    }

    static class CWeaknessAndPoorness {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int n = in.nextInt();
            int a[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = in.nextInt();
            }
            double xl = -1e4, xu = 1e4;
            double mlx = 0, mux = 0, lc = 0, lmax = 0, lmin = 0, uc = 0, umax = 0, umin = 0, lans = 0, uans = 0;
            for (int it = 0; it < 100; it++) {
                mlx = (2.0 * xl + xu) / 3.0;
                mux = (xl + 2.0 * xu) / 3.0;
                lc = 0;
                lmax = 0;
                lmin = 0;
                uc = 0;
                umax = 0;
                umin = 0;
                lans = 0;
                uans = 0;
                for (int i = 0; i < n; i++) {
                    lc += a[i] - mlx;
                    lans = Math.max(lans, lc - lmin);
                    lans = Math.max(lans, -lc + lmax);
                    lmax = Math.max(lmax, lc);
                    lmin = Math.min(lmin, lc);
                    uc += a[i] - mux;
                    uans = Math.max(uans, uc - umin);
                    uans = Math.max(uans, -uc + umax);
                    umax = Math.max(umax, uc);
                    umin = Math.min(umin, uc);
                }
                //System.out.println(lans+" "+uans);
                if (lans < uans) {
                    xu = mux;
                } else {
                    xl = mlx;
                }
            }
            out.println(lans);
        }

    }

    static class InputReader {
        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;
        private InputReader.SpaceCharFilter filter;

        public InputReader(InputStream stream) {
            this.stream = stream;
        }

        public int read() {
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

        public int nextInt() {
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
            }
            while (!isSpaceChar(c));

            return res * sgn;
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

