import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.BufferedWriter;
import java.util.InputMismatchException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.NoSuchElementException;
import java.io.Writer;
import java.math.BigInteger;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 * @author Alex
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
    public void solve(int testNumber, InputReader in, OutputWriter out){
	    int toperations = in.ri(), mbytestotal = in.ri();
	    long[] mem = new long[mbytestotal];
	    int cur = 1;
	    for(int operation = 0; operation < toperations; operation++) {
		    String type = in.next();
		    if(type.equals("alloc")){
			    int size = in.ri();
			    boolean worked = false;
			    for(int i = 0; i <= mem.length - size; i++) {
				    boolean possible = true;
				    for(int j = i; j < i + size; j++) {
					    if(mem[j] != 0) possible = false;
				    }
				    if(possible){
					    worked = true;
					    for(int j = i; j < i + size; j++) mem[j] = cur;
					    out.printLine(cur);
					    cur++;
					    break;
				    }
			    }
			    if (!worked) out.printLine("NULL");
		    }
		    else if(type.equals("erase")){
			    long toerase = in.readLong();
			    if (toerase <= 0 || toerase >= 1000){
				    out.printLine("ILLEGAL_ERASE_ARGUMENT");
			    }
			    else{
				    boolean erased = false;
				    for(int i = 0; i < mem.length; i++)
					    if(mem[i] == toerase){
						    erased = true;
						    mem[i] = 0;
					    }
				    if(!erased) out.printLine("ILLEGAL_ERASE_ARGUMENT");
			    }
		    }
		    else{
			    long[] newmem = new long[mem.length];
			    int pointer = 0;
			    for(int i = 0; i < mem.length; i++)  if (mem[i] != 0){
				    newmem[pointer] = mem[i];
				    pointer++;
			    }
			    mem = newmem;
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
	public int ri(){
		return readInt();
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

	public long readLong() {
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
	public String next() {
		return readString();
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
	public void printLine(int i) {
		writer.println(i);
	}

}

