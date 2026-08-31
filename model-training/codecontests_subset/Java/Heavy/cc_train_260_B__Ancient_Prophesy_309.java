import java.io.OutputStreamWriter;
import java.io.BufferedWriter;
import java.util.Locale;
import java.util.HashMap;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.InputMismatchException;
import java.util.Set;
import java.math.BigInteger;
import java.util.Collections;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 * @author Jacob Jiang
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
        int[] dayCount = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        HashSet<String> set = new HashSet<String>();
        for (int year = 2013; year <= 2015; year++) {
            for (int month = 1; month <= 12; month++) {
                for (int day = 1; day <= dayCount[month]; day++) {
                    set.add(String.format("%02d-%02d-%04d", day, month, year));
                }
            }
        }
        String s = in.next();
        Counter<String> counter = new Counter<String>();
        for (int i = 0; i <= s.length() - 10; i++) {
            String tmp = s.substring(i, i + 10);
            if (set.contains(tmp)) {
                counter.add(tmp);
            }
        }
        long maxValue = Collections.max(counter.values());
        for (Map.Entry<String, Long> entry : counter.entrySet()) {
            if (entry.getValue() == maxValue) {
                out.println(entry.getKey());
                return;
            }
        }
    }
}

class InputReader {

    private InputStream stream;
    private byte[] buf = new byte[1 << 16];
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

    public String next() {
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

    }

class OutputWriter {
    private PrintWriter writer;

    public OutputWriter(OutputStream stream) {
        writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(stream)));
    }

    public OutputWriter(Writer writer) {
        this.writer = new PrintWriter(writer);
    }

    public void println(String x) {
        writer.println(x);
    }

    public void close() {
        writer.close();
    }

    }

class Counter<T> extends HashMap<T, Long> {

    public void add(T obj) {
        put(obj, get(obj) + 1L);
    }

    public Long get(Object key) {
        return containsKey(key) ? super.get(key) : 0L;
    }
}

