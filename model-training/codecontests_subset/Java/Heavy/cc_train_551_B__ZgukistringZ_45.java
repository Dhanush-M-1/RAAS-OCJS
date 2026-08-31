import java.io.BufferedWriter;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.math.BigInteger;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Writer;
import java.io.IOException;
import java.util.Arrays;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.util.Comparator;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 * @author Stanislav Pak
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
		char[] a = in.readString().toCharArray();
		char[] b = in.readString().toCharArray();
		char[] c = in.readString().toCharArray();
		int[] ca = make_count(a);
		int[] cb = make_count(b);
		int[] cc = make_count(c);
		int ans = 0;
		int nb = -1, nc = -1;
		for (int i = 0; ;++i) {
			int candidate = i + max_words(ca, cc);
			if (candidate > ans) {
				ans = candidate;
				nb = i;
				nc = candidate - i;
			}
			for (int j = 0; j < 26; ++j) ca[j] -= cb[j];
			if (ArrayUtils.minElement(ca) < 0) break;
		}
		ca = make_count(a);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < nb; ++i) {
			sb.append(new String(b));
			for (int j = 0; j < 26; ++j) ca[j] -= cb[j];
		}
		for (int i = 0; i < nc; ++i) {
			sb.append(new String(c));
			for (int j = 0; j < 26; ++j) ca[j] -= cc[j];
		}
		for (int i = 0; i < 26; ++i) {
			while (ca[i] > 0) {
				--ca[i];
				sb.append((char)('a' + i));
			}
		}
		out.printLine(sb);
    }

	private int max_words(int[] a, int[] b) {
		int res = (int)1e8;
		for (int i = 0; i < 26; ++i) {
			if (b[i] > 0) {
				res = Math.min(res, a[i] / b[i]);
			}
		}
		assert res < 1e7;
		return res;
	}

	private int[] make_count(char[] a) {
		int[] res = new int[26];
		for (char c : a) {
			++res[c - 'a'];
		}
		return res;
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

	public String readString() {
		int c = read();
		while (isSpaceChar(c))
			c = read();
		StringBuilder res = new StringBuilder();
		do {
			if (Character.isValidCodePoint(c))
				res.appendCodePoint(c);
			c = read();
		} while (!isSpaceChar(c));
		return res.toString();
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

	public void printLine(Object...objects) {
		print(objects);
		writer.println();
	}

	public void close() {
		writer.close();
	}

}

class ArrayUtils {

	public static int minPosition(int[] array) {
		return minPosition(array, 0, array.length);
	}

	public static int minPosition(int[] array, int from, int to) {
        if (from >= to)
            return -1;
        int min = array[from];
        int result = from;
        for (int i = from + 1; i < to; i++) {
            if (array[i] < min) {
                min = array[i];
                result = i;
            }
        }
        return result;
    }

	public static int minElement(int[] array) {
		return array[minPosition(array)];
	}

}
