import java.util.function.BiFunction;
import java.io.BufferedWriter;
import java.util.InputMismatchException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.NoSuchElementException;
import java.util.Map;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Writer;
import java.io.IOException;
import java.util.Set;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 * @author PloadyFree
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        OutputWriter out = new OutputWriter(outputStream);
        TaskB solver = new TaskB();
        solver.solve(1, in, out);
        out.close();
    }
}

class TaskB {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.readInt();

        Map<Integer, Integer> m1 = new HashMap<>();
        Map<Integer, Integer> m2 = new HashMap<>();
        
        for (int i = 0; i < n; i++) {
            int k = in.readInt();
            m1.merge(k, 1, (a,b) -> a+b);
            m2.merge(k, 1, (a,b) -> a+b);
        }

        for (int i = 0; i < n-1; i++) {
            int k = in.readInt();
            m2.merge(k, -1, (a,b) -> a+b);
        }

        int first = 0;
        for (Map.Entry e : m2.entrySet()) {
            if (e.getValue().equals(1)) {
                first = (int)e.getKey();
                m1.merge(first, -1, (a,b) -> a+b);
                break;
            }
        }
        
        for (int i = 0; i < n-2; i++) {
            int k = in.readInt();
            m1.merge(k, -1, (a,b) -> a+b);
        }
        
        int second = 0;
        for (Map.Entry e : m1.entrySet()) {
            if (e.getValue().equals(1)) {
                second = (int)e.getKey();
                m1.merge(first, -1, (a,b) -> a+b);
                break;
            }
        }
        
        out.print(first + " " + second);


    }
}

class InputReader {

    private InputStream stream;
    private byte[] buf = new byte[1024];
    private int curChar;
    private int numChars;
    private SpaceCharFilter filter;

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

    public boolean isSpaceChar(int c) {
        if (filter != null)
            return filter.isSpaceChar(c);
        return isWhitespace(c);
    }

    public static boolean isWhitespace(int c) {
        return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
    }

    public interface SpaceCharFilter {
        public boolean isSpaceChar(int ch);
    }
}

class OutputWriter {
    private final PrintWriter writer;

    public OutputWriter(OutputStream outputStream) {
        writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
    }

    public void print(Object...objects) {
        for (int i = 0; i < objects.length; i++) {
            if (i != 0)
                writer.print(' ');
            writer.print(objects[i]);
        }
    }

    public void close() {
        writer.close();
    }

}
