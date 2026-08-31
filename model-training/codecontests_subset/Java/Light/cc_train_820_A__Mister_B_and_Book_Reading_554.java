//package kattis;

import java.io.*;
import java.util.*;

public class A421 {
//codeforces #421
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		IO io = new IO(System.in);
		int c = io.nextInt();
		int v0 = io.nextInt();
		int v1 = io.nextInt();
		int a = io.nextInt();
		int l = io.nextInt();
		int curd = 1;
		int curp = v0;
		while(curp < c) {
			curp += Math.min(v1, v0 + curd*a);
			curp -= l;
			curd++;
		}
		System.out.println(curd);
		io.close();
	}
	
	
	static class IO extends PrintWriter {
		static BufferedReader r;
		static StringTokenizer t;

		public IO(InputStream i) {
			super(new BufferedOutputStream(System.out));
			r = new BufferedReader(new InputStreamReader(i));
			t = new StringTokenizer("");
		}

		public String next() throws IOException {
			while (!t.hasMoreTokens()) {
				t = new StringTokenizer(r.readLine());
			}
			return t.nextToken();
		}

		public int nextInt() throws IOException{
			return Integer.parseInt(next());
		}

		public long nextLong() throws IOException {
			return Long.parseLong(next());
		}

		public double nextDouble() throws IOException {
			return Double.parseDouble(next());
		}
}
}

