import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class Main {
	
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        OutputWriter out = new OutputWriter(outputStream);
        Solve solver = new Solve();
        solver.solve(1, in, out);
        out.close();
    }
    
    static class Solve {
    	public void solve(int testNumber, InputReader in, OutputWriter out) {
    		String S = in.next();
    		char s [] = S.toCharArray();
    		int size = S.length();
    		int k = in.nextInt();
    	
    		int a [] = new int [size+1];
    	
    		for (int i=1; i<=size; i++) 
    			a[i] = s[i-1]-'0';
    			
    		long dp0 [][] = new long [k+1][size+1];
    		long dp1 [][] = new long [k+1][size+1];
    		
    		dp1[0][0] = 1;
    		int cur = 0;
    		
    		for (int i=1; i<=size; i++) {
    			cur = a[i];
    			
    			for (int j=0; j<=k; j++) {
    				dp0[j][i] = dp0[j][i-1]; //add 0 to the left from dp0
    				
    				if (j!=0) {
    					dp0[j][i] += Math.max(cur-1, 0)*dp1[j-1][i-1]; //add non-0 from dp1
    					dp0[j][i] += 9*dp0[j-1][i-1]; //add non-0 from dp0
    				}
    				
    				if (cur==0)
    					dp1[j][i] = dp1[j][i-1]; // 0 or 1
    				
    				else {
    					dp0[j][i] += dp1[j][i-1]; //add 0 to the left from dp1
    					
    					if (j!=0) 
    						dp1[j][i] = dp1[j-1][i-1]; //add 0 to the right
    				}
    			}
    		}
    		
    		out.println(dp0[k][size]+dp1[k][size]);
    	}
    }
    	
    
    static class OutputWriter {
	    private final PrintWriter writer;
	
	    public OutputWriter(OutputStream outputStream) {
	        writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
	    }
	
	    public OutputWriter(Writer writer) {
	        this.writer = new PrintWriter(writer);
	    }
	
	    public void close() {
	        writer.close();
	    }
	
	    public void println(String string) {
	        writer.println(string);
	    }
	    
	    public void println(char string) {
	        writer.println(string);
	    }
	    
	    public void println(int number) {
	        writer.println(number);
	    }
	    
	    public void println(long number) {
	        writer.println(number);
	    }
	    
	    public void println(double number) {
	    	writer.println(number);
	    }
	    
	    public void print(long number) {
	        writer.print(number);
	    }
	    
	    public void print(int number) {
	        writer.print(number);
	    }
	    
	    public void print(char string) {
	        writer.print(string);
	    }
	    
	    public void print(String string) {
	        writer.print(string);
	    }
	    
	    public void print(double number) {
	    	writer.print(number);
	    }
	}
    
	static class InputReader {
		private InputStream in;
		private byte[] buffer = new byte[1024];
		private int curbuf;
		private int lenbuf;
		
		public InputReader(InputStream in) {
			this.in = in;
			this.curbuf = this.lenbuf = 0;
		}
		
		public String nextLine() {
			StringBuilder sb = new StringBuilder();
			int b = readByte();
			while (b!=10) {
				sb.appendCodePoint(b);
				b = readByte();
			}
			if(sb.length()==0)return "";
			return sb.toString().substring(0,sb.length()-1);
		}
		
		public boolean hasNextByte() {
			if (curbuf >= lenbuf) {
				curbuf = 0;
				try {
					lenbuf = in.read(buffer);
				} catch (IOException e) {
					throw new InputMismatchException();
				}
				if (lenbuf <= 0)
					return false;
			}
			return true;
		}
 
		private int readByte() {
			if (hasNextByte())
				return buffer[curbuf++];
			else
				return -1;
		}
 
		private boolean isSpaceChar(int c) {
			return !(c >= 33 && c <= 126);
		}
 
		private void skip() {
			while (hasNextByte() && isSpaceChar(buffer[curbuf]))
				curbuf++;
		}
 
		public boolean hasNext() {
			skip();
			return hasNextByte();
		}
 
		public String next() {
			if (!hasNext())
				throw new NoSuchElementException();
			StringBuilder sb = new StringBuilder();
			int b = readByte();
			while (!isSpaceChar(b)) {
				sb.appendCodePoint(b);
				b = readByte();
			}
			return sb.toString();
		}
 
		public int nextInt() {
			if (!hasNext())
				throw new NoSuchElementException();
			int c = readByte();
			while (isSpaceChar(c))
				c = readByte();
			boolean minus = false;
			if (c == '-') {
				minus = true;
				c = readByte();
			}
			int res = 0;
			do {
				if (c < '0' || c > '9')
					throw new InputMismatchException();
				res = res * 10 + c - '0';
				c = readByte();
			} while (!isSpaceChar(c));
			return (minus) ? -res : res;
		}
 
		public long nextLong() {
			if (!hasNext())
				throw new NoSuchElementException();
			int c = readByte();
			while (isSpaceChar(c))
				c = readByte();
			boolean minus = false;
			if (c == '-') {
				minus = true;
				c = readByte();
			}
			long res = 0;
			do {
				if (c < '0' || c > '9')
					throw new InputMismatchException();
				res = res * 10 + c - '0';
				c = readByte();
			} while (!isSpaceChar(c));
			return (minus) ? -res : res;
		}
		
		public double nextDouble() {
			return Double.parseDouble(next());
		}
 
		public int[] nextIntArray(int n) {
			int[] a = new int[n];
			for (int i = 0; i < n; i++)
				a[i] = nextInt();
			return a;
		}
 
		public long[] nextLongArray(int n) {
			long[] a = new long[n];
			for (int i = 0; i < n; i++)
				a[i] = nextLong();
			return a;
		}
 
		public char[][] nextCharMap(int n, int m) {
			char[][] map = new char[n][m];
			for (int i = 0; i < n; i++)
				map[i] = next().toCharArray();
			return map;
		}
	}
}
    