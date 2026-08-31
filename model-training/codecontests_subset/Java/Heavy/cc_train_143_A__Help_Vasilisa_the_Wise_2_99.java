

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class football {
	static long time = 0, mp = Integer.MAX_VALUE, k = 0, cnt = 0, edge = 0, no = 0;

	static int[] goal;
	static int[] init;
	static int[] col;
	static char[][] g;
	static String sb = "";
	static ArrayList<Integer>[] a;

	static ArrayList<Integer> p = new ArrayList<>();

	public static void main(String[] args) throws IOException {

		Reader scn = new Reader();

		int r1= scn.nextInt();
		int r2=scn.nextInt();
		int c1=scn.nextInt();
		int c2=scn.nextInt();
		int d1=scn.nextInt();
		int d2=scn.nextInt();
		boolean check[]=new boolean[10];
		check[0]=true;
		int a=(c1+d1-r2)/2;
		if(a<10 && !check[a]){
			check[a]=true;
		}
		else{
			System.out.println(-1);
			return;
		}
		int b=(c2+d2-r2)/2;
		if(b<10 && !check[b]){
			check[b]=true;
		}
		else{
			System.out.println(-1);
			return;
		}
		int c=(c1+d2-r1)/2;
		if(c<10 && !check[c]){
			check[c]=true;
		}
		else{
			System.out.println(-1);
			return;
		}
		int d=(c2+d1-r1)/2;
		if(d<10 && !check[d]){
			check[d]=true;
		}
		else{
			System.out.println(-1);
			return;
		}
		
		System.out.println(a +" "+ b);
		System.out.println(c+" "+d);
		

	}

	static class pair implements Comparable<pair> {
		int n = 0;
		int cnt = 0;
		String s = "";
		// int cnt;

		pair(int b, int a, String k) {
			this.n = b;
			this.cnt = a;
			s = k;
			// cnt = x;
		}

		@Override
		public int compareTo(pair o) {

			return 1;

		}
	}

	// -----------PrintWriter for faster output---------------------------------
	public static PrintWriter out;

	public static class Reader {
		final private int BUFFER_SIZE = 1 << 16;
		private DataInputStream din;
		private byte[] buffer;
		private int bufferPointer, bytesRead;

		public Reader() {
			din = new DataInputStream(System.in);
			buffer = new byte[BUFFER_SIZE];
			bufferPointer = bytesRead = 0;
		}

		public Reader(String file_name) throws IOException {
			din = new DataInputStream(new FileInputStream(file_name));
			buffer = new byte[BUFFER_SIZE];
			bufferPointer = bytesRead = 0;
		}

		public String readLine() throws IOException {
			byte[] buf = new byte[100000 + 1]; // line length
			int cnt = 0, c;
			while ((c = read()) != -1) {
				if (c == '\n')
					break;
				buf[cnt++] = (byte) c;
			}
			return new String(buf, 0, cnt);
		}

		public int nextInt() throws IOException {
			int ret = 0;
			byte c = read();
			while (c <= ' ')
				c = read();
			boolean neg = (c == '-');
			if (neg)
				c = read();
			do {
				ret = ret * 10 + c - '0';
			} while ((c = read()) >= '0' && c <= '9');

			if (neg)
				return -ret;
			return ret;
		}

		public long nextLong() throws IOException {
			long ret = 0;
			byte c = read();
			while (c <= ' ')
				c = read();
			boolean neg = (c == '-');
			if (neg)
				c = read();
			do {
				ret = ret * 10 + c - '0';
			} while ((c = read()) >= '0' && c <= '9');
			if (neg)
				return -ret;
			return ret;
		}

		public double nextDouble() throws IOException {
			double ret = 0, div = 1;
			byte c = read();
			while (c <= ' ')
				c = read();
			boolean neg = (c == '-');
			if (neg)
				c = read();

			do {
				ret = ret * 10 + c - '0';
			} while ((c = read()) >= '0' && c <= '9');

			if (c == '.') {
				while ((c = read()) >= '0' && c <= '9') {
					ret += (c - '0') / (div *= 10);
				}
			}

			if (neg)
				return -ret;
			return ret;
		}

		private void fillBuffer() throws IOException {
			bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
			if (bytesRead == -1)
				buffer[0] = -1;
		}

		private byte read() throws IOException {
			if (bufferPointer == bytesRead)
				fillBuffer();
			return buffer[bufferPointer++];
		}

		public void close() throws IOException {
			if (din == null)
				return;
			din.close();
		}

		public int[] nextIntArray(int n) throws IOException {
			int[] arr = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = nextInt();
			}
			return arr;
		}

		public long[] nextLongArray(int n) throws IOException {
			long[] arr = new long[n];
			for (int i = 0; i < n; i++) {
				arr[i] = nextLong();
			}
			return arr;
		}

		public int[][] nextInt2DArray(int m, int n) throws IOException {
			int[][] arr = new int[m][n];
			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++)
					arr[i][j] = nextInt();
			}
			return arr;
		}

	}
}
