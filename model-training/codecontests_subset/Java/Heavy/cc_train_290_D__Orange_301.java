import java.util.Scanner;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigDecimal;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Writer;
import java.math.BigInteger;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 * @author Fish <lyhypacm@gmail.com>
 */
public class Main {
	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader in = new InputReader(inputStream);
		OutputWriter out = new OutputWriter(outputStream);
		TaskD solver = new TaskD();
		solver.solve(1, in, out);
		out.close();
	}
}

class TaskD {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        String arr = in.next();
        int n = in.nextInt();
        char[] chars = arr.toCharArray();
        for (int i = 0; i < chars.length; ++i) {
            if (chars[i] >= 'A' && chars[i] <= 'Z')
                chars[i] = (char) (chars[i] - 'A' + 'a');
            if (chars[i] >= 'a' && chars[i] < 'a' + n)
                chars[i] = (char) (chars[i] - 'a' + 'A');
            out.print(chars[i]);
        }
        out.println();
    }
}

class InputReader {
    private Scanner scanner;

    public InputReader(InputStream inputStream) {
        scanner = new Scanner(new BufferedReader(new InputStreamReader(inputStream)));
    }

    public int nextInt() {
        return scanner.nextInt();
    }

    public long nextLong() {
        return scanner.nextLong();
    }

    public String next() {
        return scanner.next();
    }

    public BigInteger nextBigInteger() {
        return scanner.nextBigInteger();
    }

    public BigDecimal nextBigDecimal() {
        return scanner.nextBigDecimal();
    }

    public double nextDouble() {
        return scanner.nextDouble();
    }
}

class OutputWriter {
    private PrintWriter printWriter;

    public OutputWriter(OutputStream outputStream) {
        printWriter = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
    }

    public OutputWriter(Writer writer) {
        printWriter = new PrintWriter(writer);
    }

    public <T> void print(T object) {
        printWriter.print(object);
    }

    public <T> void println(T object) {
        printWriter.println(object);
    }

    public void println() {
        printWriter.println();
    }

    public void close() {
        printWriter.close();
    }
}
