import java.io.*;
import java.math.*;
import java.util.*;

import static java.util.Arrays.fill;
import static java.lang.Math.*;
import static java.util.Arrays.sort;
import static java.util.Collections.sort;

public class Trips {
	static int mod = 1000000007;
	static InputReader in = new InputReader(System.in);
	static PrintWriter out = new PrintWriter(System.out);

	static int n,m,k;
	static HashSet<Integer>[] adjlist;
	static boolean[] isact;
	static int active=0;
	static int[] edge_a;
	static int[] edge_b;
	static int[] ans;
	static int[] deg;
	
	static void disable(int i)
	{
		if(!isact[i])
			return;
		if(deg[i]<k)
		{
			isact[i]=false;
			for(int u : adjlist[i])
			{
				deg[u]--;
				disable(u);
			}
			active--;
		}
	}
	
	public static void main(String[] args) {

		n=in.nextInt();
		m=in.nextInt();
		k=in.nextInt();
		adjlist=new HashSet[n+1];
		isact=new boolean[n+1];
		Arrays.fill(isact, true);
		edge_a=new int[m+1];
		edge_b=new int[m+1];
		ans=new int[m+1];
		deg=new int[n+1];
		for(int i=1;i<=n;i++)
		{
			adjlist[i]=new HashSet<>();
		}
		for(int i=1;i<=m;i++)
		{
			int a=in.nextInt();
			int b=in.nextInt();
			edge_a[i]=a;
			edge_b[i]=b;
			deg[a]++;
			deg[b]++;
			adjlist[a].add(b);
			adjlist[b].add(a);
		}
		active=n;
		for(int i=1;i<=n;i++)
		{
			if(deg[i]<k)
			{
				disable(i);
			}
		}
		ans[m]=active;
		for(int i=m;i>=2;i--)
		{
			int a=edge_a[i];
			int b=edge_b[i];
			if(isact[b])
				deg[a]--;
			if(isact[a])
				deg[b]--;
			adjlist[a].remove(b);
			adjlist[b].remove(a);
			disable(a);
			disable(b);
			ans[i-1]=active;
		}
		for(int i=1;i<=m;i++)
		{
			out.println(ans[i]);
		}
		out.close();

	}

	static class InputReader {
		private final InputStream stream;
		private final byte[] buf = new byte[8192];
		private int curChar, snumChars;

		public InputReader(InputStream st) {
			this.stream = st;
		}

		public int read() {
			if (snumChars == -1)
				throw new InputMismatchException();
			if (curChar >= snumChars) {
				curChar = 0;
				try {
					snumChars = stream.read(buf);
				} catch (IOException e) {
					throw new InputMismatchException();
				}
				if (snumChars <= 0)
					return -1;
			}
			return buf[curChar++];
		}

		public int nextInt() {
			int c = read();
			while (isSpaceChar(c)) {
				c = read();
			}
			int sgn = 1;
			if (c == '-') {
				sgn = -1;
				c = read();
			}
			int res = 0;
			do {
				res *= 10;
				res += c - '0';
				c = read();
			} while (!isSpaceChar(c));
			return res * sgn;
		}

		public long nextLong() {
			int c = read();
			while (isSpaceChar(c)) {
				c = read();
			}
			int sgn = 1;
			if (c == '-') {
				sgn = -1;
				c = read();
			}
			long res = 0;
			do {
				res *= 10;
				res += c - '0';
				c = read();
			} while (!isSpaceChar(c));
			return res * sgn;
		}

		public String readString() {
			int c = read();
			while (isSpaceChar(c)) {
				c = read();
			}
			StringBuilder res = new StringBuilder();
			do {
				res.appendCodePoint(c);
				c = read();
			} while (!isSpaceChar(c));
			return res.toString();
		}

		public String nextLine() {
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

		public boolean isSpaceChar(int c) {
			return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
		}

		private boolean isEndOfLine(int c) {
			return c == '\n' || c == '\r' || c == -1;
		}
	}

	private static void tr(Object... o) {
		if (!(System.getProperty("ONLINE_JUDGE") != null))
			System.out.println(Arrays.deepToString(o));
	}
}


