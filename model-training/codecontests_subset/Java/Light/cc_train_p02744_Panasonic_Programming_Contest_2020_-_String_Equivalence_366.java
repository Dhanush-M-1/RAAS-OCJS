import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Map.Entry;

import java.util.PriorityQueue;
import java.util.Random;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;


public class Main {
	
	public static void dfs2(int depth, int deep, int limit, int select, boolean first, char[] chs, int[] group) {
		if(select >= limit) {
			dfs(depth + 1, deep + 1, limit, chs, group);
			return;
		}
		
		if(group[select] >= 1) {
			dfs2(depth, deep, limit, select + 1, false, chs, group);
			return;
		}
		
		if(!first) {
			dfs2(depth, deep, limit, select + 1, false, chs, group);
		}
			
		group[select] = depth;
		chs[select] = (char)('a' + (depth - 1));
		dfs2(depth, deep, limit, select + 1, false, chs, group);
		group[select] = 0;
	}
	
	public static TreeSet<String> set = new TreeSet<String>();
	
	public static void dfs(int depth, int deep, int limit, char[] chs, int[] group) {
		if(deep >= limit) {
			set.add(new StringBuilder().append(chs).toString());
			return;
		}
		
		if(group[deep] >= 1) {
			dfs(depth, deep + 1, limit, chs, group);
			return;
		}else {
			dfs2(depth, deep, limit, deep, true, chs, group);
		}
	}
	
	public static void main(String[] args) throws IOException {	
		try(final Scanner sc = new Scanner(System.in)){
			final int N = sc.nextInt();
			
			dfs(1, 0, N, new char[N], new int[N]);
			for(final String s : set) {
				System.out.println(s);
			}
		}
	}

	public static class Scanner implements Closeable {
		private BufferedReader br;
		private StringTokenizer tok;

		public Scanner(InputStream is) throws IOException {
			br = new BufferedReader(new InputStreamReader(is));
		}

		private void getLine() throws IOException {
			while(!hasNext()){
				tok = new StringTokenizer(br.readLine());
			}
		}

		private boolean hasNext() {
			return tok != null && tok.hasMoreTokens();
		}

		public String next() throws IOException {
			getLine();
			return tok.nextToken();
		}

		public int nextInt() throws IOException {
			return Integer.parseInt(next());
		}

		public long nextLong() throws IOException {
			return Long.parseLong(next());
		}
		

		public double nextDouble() throws IOException {
			return Double.parseDouble(next());
		}

		public int[] nextIntArray(int n) throws IOException {
			final int[] ret = new int[n];
			for(int i = 0; i < n; i++){
				ret[i] = this.nextInt();
			}
			return ret;
		}

		public long[] nextLongArray(int n) throws IOException {
			final long[] ret = new long[n];
			for(int i = 0; i < n; i++){
				ret[i] = this.nextLong();
			}
			return ret;
		}

		public void close() throws IOException {
			br.close();
		}
	}
}
