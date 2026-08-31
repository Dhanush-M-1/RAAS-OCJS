import java.io.OutputStreamWriter;
import java.io.BufferedWriter;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.Map;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.TreeMap;
import java.util.Set;
import java.util.function.BiFunction;
import java.util.NoSuchElementException;
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
	class Date implements Comparable<Date>{
		int month;
		int day;
		int year;
		public Date(int day, int month, int year){this.day = day; this.month = month;
			this.year = year;}
		public int compareTo(Date o){
			if (year != o.year) return Integer.compare(year, o.year);
			if (day != o.day) return Integer.compare(day, o.day);
			return Integer.compare(month, o.month);
		}
	}
    public void solve(int testNumber, InputReader in, OutputWriter out){
	    char[] input = in.next().toCharArray();
	    TreeMap<Date, Integer> tm = new TreeMap<>();
	    int[] days = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	    for(int i = 0; i < input.length - 9; i++) {
		    if (Character.isDigit(input[i]) && Character.isDigit(input[i + 1])){
			    int day = Character.getNumericValue(input[i]) * 10 + Character.getNumericValue(input[i+1]);
			    if(input[i + 2] == '-' && Character.isDigit(input[i + 3]) && Character.isDigit(input[i + 4])){
				    int month = Character.getNumericValue(input[i + 3]) * 10 + Character.getNumericValue(input[i + 4]);
				    if(month <= 12 && month > 0 && day > 0 && day <= days[month-1] &&  input[i + 5] == '-' && Character.isDigit(input[i + 6]) && Character.isDigit(input[i + 7]) && Character.isDigit(input[i + 8]) && Character.isDigit(input[i + 9])){
					    int year = Character.getNumericValue(input[i + 6]) * 1000 + Character.getNumericValue(input[i + 7]) * 100 + Character.getNumericValue(input[i + 8]) * 10 + Character.getNumericValue(input[i + 9]);
					    if (year >= 2013 && year <= 2015){
							tm.merge(new Date(day, month, year), 1, Integer::sum);
					    }
				    }
			    }
		    }
	    }
	    int maxoccur = 0;
	    Date maxdate = new Date(-1, -1, -1);
	    for(Map.Entry<Date, Integer> e : tm.entrySet()) {
		    if (e.getValue() > maxoccur){
			    maxoccur = e.getValue();
			    maxdate = e.getKey();
		    }
	    }
	    out.printLine((maxdate.day < 10 ? "0" : "")+maxdate.day + "-" +(maxdate.month < 10 ? "0" : "")+ maxdate.month + "-" + maxdate.year);
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
}

