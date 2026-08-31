import java.util.*;
import java.io.*;
 
public class Solution {
 
	public static void main(String[] args) throws IOException {
		IO io = new IO();
 		
 		int a = io.nextInt(), b = io.nextInt();
 		int hours = a;
 		while(a >= b) {
 			int t = a / b;
 			a -= t * b;
 			hours += t;
 			a += t;
 		}
 		io.println(hours);
		
		io.close();
	}
}

class IO {
	private byte[] buf;
	private InputStream in;
	private PrintWriter pw;
	private int total, index;
	public IO() {
		buf = new byte[1024];
		in = System.in;
		pw = new PrintWriter(System.out);
	}

	public int next() throws IOException {
		if(total < 0) 
			throw new InputMismatchException();
		if(index >= total) {
			index = 0;
			total = in.read(buf);
			if(total <= 0)
				return -1;
		}
		return buf[index++];
	}

	public int nextInt() throws IOException {
		int n = next(), integer = 0;
		while(isWhiteSpace(n))
			n = next();
		int neg = 1;
		if(n == '-') {
			neg = -1;
			n = next();
		}
		while(!isWhiteSpace(n)) {
			if(n >= '0' && n <= '9') {
				integer *= 10;
				integer += n - '0';
				n = next();
			}
			else
				throw new InputMismatchException();
		}
		return neg * integer;
	}

	public int[] nextIntArray(int n) throws IOException {
		int[] arr = new int[n];
		for(int i = 0; i < n; i++) 
			arr[i] = nextInt();

		return arr;
	}

	public long nextLong() throws IOException {
		long integer = 0l;
		int n = next();
		while(isWhiteSpace(n))
			n = next();
		int neg = 1;
		if(n == '-') {
			neg = -1;
			n = next();
		}
		while(!isWhiteSpace(n)) {
			if(n >= '0' && n <= '9') {
				integer *= 10;
				integer += n - '0';
				n = next();
			}
			else
				throw new InputMismatchException();
		}
		return neg * integer;
	}

	public double nextDouble() throws IOException {
		double doub = 0;
		int n = next();
		while(isWhiteSpace(n))
			n = next();
		int neg = 1;
		if(n == '-') {
			neg = -1;
			n = next();
		}
		while(!isWhiteSpace(n) && n != '.') {
			if(n >= '0' && n <= '9') {
				doub *= 10;
				doub += n - '0';
				n = next();
			}
			else
				throw new InputMismatchException();
		}
		if(n == '.') {
			n = next();
			double temp = 1;
			while(!isWhiteSpace(n)) {
				if(n >= '0' && n <= '9') {
					temp /= 10;
					doub += (n - '0') * temp;
					n = next();
				}
				else
					throw new InputMismatchException();
			}
		}
		return doub * neg;
	}

	public String nextString() throws IOException {
		StringBuilder sb = new StringBuilder();
		int n = next();
		while(isWhiteSpace(n)) 
			n = next();
		while(!isWhiteSpace(n)) {
			sb.append((char)n);
			n = next();
		}
		return sb.toString();
	}

	public String nextLine() throws IOException {
		int n = next();
		while(isWhiteSpace(n))
			n = next();
		StringBuilder sb = new StringBuilder();
		while(!isEndOfLine(n)) {
			sb.append((char)n);
			n = next();
		}
		return sb.toString();
	}

	private boolean isWhiteSpace(int n) {
		return n == ' ' || n == '\n' || n == '\r' || n == '\t' || n == -1;
	}

	private boolean isEndOfLine(int n) {
		return n == '\n' || n == '\r' || n == -1;
	}

	public void print(Object obj) {
		pw.print(obj);
	}

	public void println(Object obj) {
		pw.println(obj);
	}

	public void close() throws IOException {
		pw.close();
	}
}
