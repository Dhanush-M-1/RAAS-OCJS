import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map.Entry;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;

public class Main {
	
	public static void main(String[] args) throws IOException {
		try(final Scanner sc = new Scanner(System.in)){
			final int N = sc.nextInt();
			final int K = sc.nextInt();
			final int Q = sc.nextInt();
			
			int[] array = new int[N];
			for(int i = 0; i < N; i++) {
				array[i] = sc.nextInt();
			}
			
			if(Q == 1) { System.out.println(0); return; }
			
			TreeSet<Integer> set = new TreeSet<Integer>();
			for(final int x : array) { set.add(x); }
			ArrayList<Integer> list = new ArrayList<Integer>(set);
			
			int answer = Integer.MAX_VALUE;
			
			for(final int ignore_value : list) {
				PriorityQueue<Integer> all = new PriorityQueue<Integer>();
				
				int right = 0;
				for(int left = 0; left < N; left++) {
					if(right < left) { right = left; }
					//System.out.println(left + " " + right);
					
					if(array[left] < ignore_value) { continue; }
					while(right < N && array[right] >= ignore_value) { right++; }
					
					final int size = right - left;
					//System.out.println(size);
					if(size < K) { continue; }
					
					PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
					for(int i = left; i < right; i++) { queue.add(array[i]); }
					
					for(int i = 0; i <= (size - K); i++) { all.add(queue.poll()); }
					
					left = right;
				}
				
				if(all.size() < Q) { continue; }
				
				final int min = all.poll();
				for(int x = 0; x < Q - 2; x++) { all.poll(); }
				final int max = all.poll();
				
				//System.out.println(ignore_value + " " + all + " " + (max - min));
				
				answer = Math.min(answer, max - min);
			}
			
			System.out.println(answer);
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