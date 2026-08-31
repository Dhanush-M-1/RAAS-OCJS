import java.io.*;
import java.math.BigInteger;
import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args) throws IOException {
//        FastScanner in = new FastScanner(new FileInputStream("input.txt"));
//        FastPrinter out = new FastPrinter(new FileOutputStream("output.txt"));
        FastScanner in = new FastScanner(System.in);
        FastPrinter out = new FastPrinter(System.out);

        Task solver = new Task();
        solver.solve(in, out);

        out.close();
    }
}

class Task {
    boolean good(String s, int pos, int len) {
        for (int i = 0; i <= 4; i++) {
            if (s.charAt(pos + i * len) == '.') {
                return false;
            }
        }
        return true;
    }

    public void solve(FastScanner in, FastPrinter out) {
        int n = in.nextInt();
        String s = in.next();

        for (int i = 0; i < n; i++) {
            for (int len = 1; i + 4 * len < n; len++) {
                if (good(s, i, len)) {
                    out.println("yes");
                    return;
                }
            }
        }

        out.println("no");
    }
}

class FastScanner extends BufferedReader {

    boolean isEOF;

    public FastScanner(InputStream is) {
        super(new InputStreamReader(is));
    }

    @Override
    public int read() {
        try {
            int ret = super.read();
            return ret;
        } catch (IOException e) {
            throw new InputMismatchException();
        }
    }

    public String next() {
        StringBuilder sb = new StringBuilder();
        int c = read();
        while (isWhiteSpace(c)) {
            c = read();
        }
        if (c < 0) {
            return null;
        }
        while (c >= 0 && !isWhiteSpace(c)) {
            sb.appendCodePoint(c);
            c = read();
        }
        return sb.toString();
    }

    static boolean isWhiteSpace(int c) {
        return c >= 0 && c <= 32;
    }

    public String nextToken() {
        return next();
    }

    public int nextInt() {
        int c = read();
        while (isWhiteSpace(c)) {
            c = read();
        }
        int sgn = 1;
        if (c == '-') {
            sgn = -1;
            c = read();
        }
        int ret = 0;
        while (c >= 0 && !isWhiteSpace(c)) {
            if (c < '0' || c > '9') {
                throw new NumberFormatException("digit expected " + (char) c
                        + " found");
            }
            ret = ret * 10 + c - '0';
            c = read();
        }
        return ret * sgn;
    }

    public char nextChar() {
        int c = read();
        while (isWhiteSpace(c)) {
            c = read();
        }
        return (char) c;
    }

    public long nextLong() {
        return Long.parseLong(next());
    }

    public double nextDouble() {
        return Double.parseDouble(next());
    }

    public String nextLine() {
        int c = read();
        String ret = readLine();
        if (ret == null) {
            return ret;
        }
        if (c != 13) {
            return (char) c + ret;
        }
        return ret;
    }

    public String readLine() {
        try {
            return super.readLine();
        } catch (IOException e) {
            return null;
        }
    }

    public int[] readIntArray(int n) {
        int[] ret = new int[n];
        for (int i = 0; i < n; i++) {
            ret[i] = nextInt();
        }
        return ret;
    }

    public int[][] readInt2DArray(int n, int m) {
        int[][] ret = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                ret[i][j] = nextInt();
            }
        }
        return ret;
    }

    public long[] readLongArray(int n) {
        long[] ret = new long[n];
        for (int i = 0; i < n; i++) {
            ret[i] = nextLong();
        }
        return ret;
    }

    public double[] readDoubleArray(int n) {
        double[] ret = new double[n];
        for (int i = 0; i < n; i++) {
            ret[i] = nextDouble();
        }
        return ret;
    }

    public String[] readTokenArray(int n) {
        String[] ret = new String[n];
        for (int i = 0; i < n; i++) {
            ret[i] = next();
        }
        return ret;
    }

    public char[][] readCharacterFieldTokens(int n, int m) {
        char[][] ret = new char[n][];
        for (int i = 0; i < n; i++) {
            ret[i] = next().toCharArray();
            if (ret[i].length != m) {
                throw new AssertionError("length expected " + m + ", found " + ret[i].length);
            }
        }
        return ret;
    }

}

class FastPrinter extends PrintWriter {
    public FastPrinter(OutputStream out) {
        super(out);
    }
}
