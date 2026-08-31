import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.InputMismatchException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 * @author alex
 */
public class Main {
	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader in = new InputReader(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		TaskA solver = new TaskA();
		solver.solve(1, in, out);
		out.close();
	}
}

class TaskA {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int r1 = in.readInt();
        int r2 = in.readInt();
        int c1 = in.readInt();
        int c2 = in.readInt();
        int d1 = in.readInt();
        int d2 = in.readInt();

        for (int i1 = 1; i1 <= 9; ++i1)
            for (int i2 = 1; i2 <= 9; ++i2)
                for (int i3 = 1; i3 <= 9; ++i3)
                    for (int i4 = 1; i4 <= 9; ++i4) {
                        if (i1 == i2 || i1 == i3 || i1 == i4) continue;
                        if (i2 == i3 || i2 == i4) continue;
                        if (i3 == i4) continue;
                        if (i1 + i2 != r1) continue;
                        if (i3 + i4 != r2) continue;
                        if (i1 + i3 != c1) continue;
                        if (i2 + i4 != c2) continue;
                        if (i1 + i4 != d1) continue;
                        if (i3 + i2 != d2) continue;

                        out.println(i1 + " " + i2 + "\n" + i3 + " " + i4);
                        return;
                    }

        out.println(-1);
    }
}

class InputReader {

    private InputStream stream;
    private byte[] buf = new byte[1024];
    private int curChar;
    private int numChars;

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

    public int readInt() {
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

    public static boolean isSpaceChar(int c) {
        return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
    }

    }

