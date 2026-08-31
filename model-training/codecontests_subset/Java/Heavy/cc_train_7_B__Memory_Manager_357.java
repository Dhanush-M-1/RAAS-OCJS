import java.util.*;
import java.io.*;

public class Solution {
	public static PrintWriter w = new PrintWriter(System.out);
	public static void main(String args[] ) throws Exception {
		Reader in = new Reader();
		int t = in.nextInt();
		int m = in.nextInt();
		int[] arr = new int[m];
		int ac = 0;
		while(t-- > 0) {
			char x = in.nextChar();
			if(x == 'a') {
				int a = alloc(arr,in.nextInt(),ac);
				if(a != -1) {
					ac++;
					w.println(ac);
				} else
					w.println("NULL");
				continue;
			}
			if(x == 'e') {
				if(!erase(arr,in.nextInt())) {
					w.println("ILLEGAL_ERASE_ARGUMENT");
					continue;
				}
			}
			if(x == 'd') {
				defragment(arr);
			}
		}
		w.flush();
		return;
	}
	public static int alloc(int[] arr, int n, int ac) {
		int la = -1;
		for (int i=0; i<arr.length; i++) {
			if(arr[i] != 0) {
				la = i;
				continue;
			}
			if((i-la) == n) {
				Arrays.fill(arr,la+1,i+1,ac+1);
				return (ac+1);
			}
		}
		return -1;
	}
	public static boolean erase(int[] arr, int x) {
		if(x <= 0)
			return false;
		for (int i=0; i<arr.length; i++) {
			if(arr[i] == x) {
				while(i < arr.length && arr[i] == x) {
					arr[i] = 0;
					i++;
				}
				return true;
			}
		}
		return false;
	}
	public static void defragment(int[] arr) {
		int ui = 0;
		for (int i=0; i<arr.length; i++) {
			if(arr[i] != 0) {
				arr[ui] = arr[i];
				ui++;
			}
		}
		while(ui < arr.length) {
			arr[ui] = 0;
			ui++;
		}
		return;
	}
}

class Reader {
	final private int BUFFER_SIZE = 1 << 16;
	private DataInputStream din;
	private byte[] buffer;
	private int bufferPointer, bytesRead;

	public Reader() {
		din = new DataInputStream(System.in);
		buffer = new byte[BUFFER_SIZE];
		bufferPointer = bytesRead = 0;
	}
	public String nextLine() throws IOException {
		int c = read();
		while(isSpaceChar(c))
			c = read();
		StringBuilder res = new StringBuilder();
		do {
			res.appendCodePoint(c);
			c = read();
		} while(!isEndOfLine(c));
		return res.toString();
	}
	public String next() throws IOException {
		int c = read();
		while(isSpaceChar(c))
			c = read();
		StringBuilder res = new StringBuilder();
		do {
			res.appendCodePoint(c);
			c = read();
		} while(!isSpaceChar(c));
		return res.toString();
	}
	public int nextInt() throws IOException {
		int ret = 0;
		byte c = read();
		while(c <= ' ')
			c = read();
		boolean neg = (c == '-');
		if(neg)
			c = read();
		do {
			ret = ret * 10 + c - '0';
		} while((c = read()) >= '0' && c <= '9');
		if (neg)
			return -ret;
		return ret;
	}
	public int[] nextIntArray(int n) throws IOException {
		int a[] = new int[n];
		for(int i = 0; i < n; i++)
			a[i] = nextInt();
		return a;
	}
	public int[][] next2dIntArray(int n, int m) throws IOException {
		int a[][] = new int[n][m];
		for(int i = 0; i < n; i++)
			for(int j = 0; j < m; j++)
				a[i][j] = nextInt();
		return a;
	}
	public char nextChar() throws IOException {
		return next().charAt(0);
	}
	public long nextLong() throws IOException {
		long ret = 0;
		byte c = read();
		while(c <= ' ')
			c = read();
		boolean neg = (c == '-');
		if(neg)
			c = read();
		do {
			ret = ret * 10 + c - '0';
		} while((c = read()) >= '0' && c <= '9');
		if (neg)
			return -ret;
		return ret;
	}
	public double nextDouble() throws IOException {
		double ret = 0, div = 1;
		byte c = read();
		while(c <= ' ')
			c = read();
		boolean neg = (c == '-');
		if(neg)
			c = read();
		do {
			ret = ret * 10 + c - '0';
		} while((c = read()) >= '0' && c <= '9');
		if (c == '.') {
			while((c = read()) >= '0' && c <= '9') {
				ret += (c - '0') / (div *= 10);
			}
		}
		if(neg)
			return -ret;
		return ret;
	}
	private void fillBuffer() throws IOException {
		bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
		if(bytesRead == -1)
			buffer[0] = -1;
	}
	private byte read() throws IOException {
		if(bufferPointer == bytesRead)
			fillBuffer();
		return buffer[bufferPointer++];
	}
	public void close() throws IOException {
		if(din == null)
			return;
		din.close();
	}
	public boolean isSpaceChar(int c) {
		return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
	}
	private boolean isEndOfLine(int c) {
		return c == '\n' || c == '\r' || c == -1;
	}
}