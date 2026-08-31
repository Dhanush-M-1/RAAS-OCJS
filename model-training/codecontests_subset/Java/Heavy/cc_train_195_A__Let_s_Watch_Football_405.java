import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Closeable;
import java.util.Iterator;
import java.io.BufferedReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.NoSuchElementException;
import java.io.Writer;
import java.util.StringTokenizer;
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
		QuickScanner in = new QuickScanner(inputStream);
		ExtendedPrintWriter out = new ExtendedPrintWriter(outputStream);
		TaskA solver = new TaskA();
		solver.solve(1, in, out);
		out.close();
	}
}

class TaskA {
	public void solve(int testNumber, QuickScanner in, ExtendedPrintWriter out) {
        int a = in.nextInt();
        int b = in.nextInt();
        int c = in.nextInt();
        out.println(NumberUtils.upDiv(a * c, b) - c);
    }
}

class QuickScanner implements Iterator<String>, Closeable {
    BufferedReader reader;
    StringTokenizer tokenizer;
    boolean endOfFile = false;

    public QuickScanner(InputStream inputStream){
        reader = new BufferedReader(new InputStreamReader(inputStream));
        try {
            tokenizer = new StringTokenizer(reader.readLine());
        } catch (Exception e) {
            endOfFile = true;
        }
    }

    public boolean hasNext() {
        if (!tokenizer.hasMoreTokens()) {
            try {
                checkNext();
            } catch (NoSuchElementException ignored) {
            }

        }
        return !endOfFile;
    }

    private void checkNext() {
        if (endOfFile) {
            throw new NoSuchElementException();
        }
        try {
            while (!tokenizer.hasMoreTokens()) {
                tokenizer = new StringTokenizer(reader.readLine());
            }
        } catch (Exception e) {
            endOfFile = true;
            throw new NoSuchElementException();
        }
    }

    public String next() {
        checkNext();
        return tokenizer.nextToken();
    }

    public void remove() {
        throw new UnsupportedOperationException();
    }

    public int nextInt() {
        return Integer.parseInt(next());
    }

    public void close() {
        try {
            reader.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}

class ExtendedPrintWriter extends PrintWriter {


    public ExtendedPrintWriter(Writer out) {
        super(out);
    }

    public ExtendedPrintWriter(Writer out, boolean autoFlush) {
        super(out, autoFlush);
    }

    public ExtendedPrintWriter(OutputStream out) {
        super(out);
    }

    public ExtendedPrintWriter(OutputStream out, boolean autoFlush) {
        super(out, autoFlush);
    }

    }

class NumberUtils {
    public static int upDiv(int a, int b) {
        return a % b == 0 ? (a / b) : (a / b + 1);
    }

    }

