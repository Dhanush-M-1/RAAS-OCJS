import java.io.IOException;
import java.io.InputStream;
import java.util.*;


public class Main {

    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);

        final int n = in.readInt();

        String str = in.readString();
        int ALL = 0;
        int FOLDED = 0;
        int count = 0;

        for (int i = 0; i < n; i++) {
            char ch = str.charAt(i);

            if (ch == 'A') ALL++;
            else if (ch == 'F') FOLDED++;
        }

        for (int i = 0; i < n; i++) {
            char ch = str.charAt(i);

            if (ch == 'F') continue;

            if (ch == 'A') {
                if (ALL - 1 + FOLDED == n - 1) count++;
            } else {
                if (ALL + FOLDED == n - 1) count++;
            }
        }
        System.out.println(count);
    }
}


class InputReader {
    private InputStream stream;
    private byte[] buf = new byte[102400];
    private int curChar;
    private int numChars;

    public InputReader(InputStream stream) {
        this.stream = stream;
    }

    public final int read() {
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

    public final int readInt() {
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

    public final long readLong() {
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

    public final String readString() {
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

    public static boolean isSpaceChar(int c) {
        return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
    }

    public final String next() {
        return readString();
    }
}
