import java.io.OutputStreamWriter;
import java.io.BufferedWriter;
import java.util.HashMap;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Writer;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Set;
import java.util.NoSuchElementException;
import java.math.BigInteger;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 * @author Walker
 */
public class Main {
	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader in = new InputReader(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		TaskB solver = new TaskB();
		solver.solve(1, in, out);
		out.close();
	}
}

class TaskB {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.readInt();
        HashMap<Integer, Integer> s = new HashMap<Integer, Integer>();
        int[] a = IOUtils.readIntArray(in, n);
        int[] b = IOUtils.readIntArray(in, n - 1);
        int[] c = IOUtils.readIntArray(in, n - 2);
        for(int i = 0; i < a.length; i++){
            if(s.containsKey(a[i])){
                s.put(a[i], s.get(a[i]) + 1);
            }
            else{
                s.put(a[i], 1);
            }
        }
        HashMap<Integer, Integer> omap = new HashMap<Integer, Integer>();
        for(int i = 0; i < b.length; i++){
            if(omap.containsKey(b[i])){
                omap.put(b[i], omap.get(b[i]) + 1);
            }
            else{
                omap.put(b[i], 1);
            }
        }
        for(Integer k : s.keySet()){
            if(!omap.containsKey(k) || omap.get(k) < s.get(k)){
                out.println(k);
                break;
            }
        }
        s.clear();
        for(int i = 0; i < c.length; i++){
            if(s.containsKey(c[i])){
                s.put(c[i], s.get(c[i]) + 1);
            }
            else{
                s.put(c[i], 1);
            }
        }
        for(Integer k : omap.keySet()){
            if(!s.containsKey(k) || s.get(k) < omap.get(k)){
                out.println(k);
                break;
            }
        }
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

class IOUtils {

	public static int[] readIntArray(InputReader in, int size) {
		int[] array = new int[size];
		for (int i = 0; i < size; i++)
			array[i] = in.readInt();
		return array;
	}

}

