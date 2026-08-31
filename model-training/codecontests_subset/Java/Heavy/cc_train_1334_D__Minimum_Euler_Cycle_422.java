import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;
import java.util.logging.Logger;


public class Main {
	public static void main(String[] args){
		PrintWriter out = new PrintWriter(System.out);
		InputReader sc=new InputReader(System.in);
		int t=sc.nextInt();
		for (int i = 0; i < t; i++) {
			long N=sc.nextInt();
			long l=sc.nextLong();
			long r=sc.nextLong();
			long indexl=0;
			for (long k = 1; k <= N; k++) {
				if (k==N) {
					if (N*(N-1)+1>=l) {
						indexl=(int) k;
					}
				}else {
					if (2*k*N-k*(k+1)>=l) {
						indexl=(int) k;
						break;
					}
				}
			}
			long indexr=0;
			for (long k = 1; k <= N; k++) {
				if (k==N) {
					if (N*(N-1)+1>=r) {
						indexr=(int) k;
					}
				}else {
					if (2*k*N-k*(k+1)>=r) {
						indexr=(int) k;
						break;
					}
				}
			}
			ArrayList<Integer> arrayList=new ArrayList<>();
			for (int j = (int) indexl; j <= (int)indexr; j++) {
				if (j==N) {
					arrayList.add(1);
				}
				for (int j2 = 1; j+j2 <= N; j2++) {
					arrayList.add(j);
					arrayList.add(j+j2);
				}
			}
			int start=(int) (l-((indexl-1)*2*N-(indexl-1)*(indexl)+1));
			int end=(int) (r-((indexl-1)*2*N-(indexl-1)*(indexl)+1));
			for (int j = start; j <= end; j++) {
				out.println(arrayList.get(j));
			}
		}
		out.flush();
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
