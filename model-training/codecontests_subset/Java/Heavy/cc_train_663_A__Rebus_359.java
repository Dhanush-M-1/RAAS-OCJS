import java.util.*;
import java.io.*;

public class CF664F{

	private static InputStream stream;
	private static byte[] buf = new byte[1024];
	private static int curChar;
	private static int numChars;
	private static SpaceCharFilter filter;
	private static PrintWriter pw;
	

	private static void soln(){
		String str = nextLine();
		int l = str.length();
		int un=0,pl=1,min=0,kn=0;
		int i=0;
		while(i<l){
			if(str.charAt(i) == '?')
				un++;
			else if(str.charAt(i) == '+')
				pl++;
			else if(str.charAt(i) == '-')
				min++;
			else if(str.charAt(i) >= '0' && str.charAt(i) <= '9'){
				kn = Integer.parseInt(str.substring(i));
				break;
			}
			i++;
		}
		if(kn >= pl - min*kn && kn <= pl*kn - min){
			pw.println("Possible");
			int[] plus = new int[pl];
			int[] minus = new int[min];
			for (i=0; i<pl; i++) {
				plus[i]=1;
			}
			for (i=0; i<min; i++) {
				minus[i]=kn;
			}
			int temp = pl - min*kn;
			int x1 = 0 ;
			int x2 = 0 ;
			while(temp!=kn){
				if (kn == pl*kn - min){
					for (i=0; i<pl; i++) {
						plus[i]= kn;
					}
					for (i=0; i<min; i++) {
						minus[i]=1;
					}
					break;
				}
				else if(temp < kn){
					if(kn - temp > kn-1){
						if(x1<pl){
							plus[x1] = kn;
							temp = temp+(kn-1);
							x1++;
						}
						else{
							minus[x2] = 1;
							temp = temp+(kn-1);
							x2++;
						}
					}
					else{
						if(x1<pl){
							plus[x1] = kn - temp + 1;
							temp = kn;
							x1++;
						}
						else{
							minus[x2] = temp;
							temp = kn;
							x2++;
						}
					}
				}
			}
			x1 = 0;
			x2 = 0;
			i=0;
			while(i<l){
				if(str.charAt(i) == ' '){
					pw.print(' ');
				}
				else if(str.charAt(i) == '+'){
					pw.print("+");
				}
				else if(str.charAt(i) == '-'){
					pw.print("-");
				}
				else if(str.charAt(i) == '?'){
					if(i == 0){
						pw.print(plus[x1]);
						x1++;
					}
					else if (str.charAt(i-2) == '+'){
						pw.print(plus[x1]);
						x1++;
					}
					else if (str.charAt(i-2) == '-'){
						pw.print(minus[x2]);
						x2++;
					}
				}
				else if(str.charAt(i) == '='){
					pw.print('=');
				}
				else if(str.charAt(i) >= '0' && str.charAt(i) <= '9'){
					pw.println(kn);
					break;
				}
				i++;
			}			
		}
		else{
			pw.println("Impossible");
		}

	}

	public static void main(String[] args){
		InputReader(System.in);
		pw = new PrintWriter(System.out);
		soln();
		pw.close();
	}


	// To Get Input
	// Some Buffer Methods

	public static void InputReader(InputStream stream1) {
		stream = stream1;
	}

	private static boolean isWhitespace(int c) {
		return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
	}

	private static boolean isEndOfLine(int c) {
		return c == '\n' || c == '\r' || c == -1;
	}

	private static int read() {
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

	private static int nextInt() {
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
 
	private static long nextLong() {
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
 
	private static String nextToken() {
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
 
	private static String nextLine() {
		int c = read();
		while (isSpaceChar(c))
			c = read();
		StringBuilder res = new StringBuilder();
		do {
			res.appendCodePoint(c);
			c = read();
		} while (!isEndOfLine(c));
		return res.toString();
	}

	private static int[] nextIntArray(int n) {
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = nextInt();
		}
		return arr;
	}
	  
	private static long[] nextLongArray(int n) {
		long[] arr = new long[n];
		for (int i = 0; i < n; i++) {
			arr[i] = nextLong();
		}
		return arr;
	}

	private static void pArray(int[] arr){
		for (int i=0; i<arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
		return;
	}

	private static void pArray(long[] arr){
		for (int i=0; i<arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
		return;		
	}

	private static boolean isSpaceChar(int c) {
		if (filter != null)
			return filter.isSpaceChar(c);
		return isWhitespace(c);
	}
 
	private interface SpaceCharFilter {
		public boolean isSpaceChar(int ch);
	}

}
