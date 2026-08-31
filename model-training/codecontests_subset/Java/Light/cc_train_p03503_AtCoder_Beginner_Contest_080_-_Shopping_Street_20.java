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
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;

public class Main {
	
	public static void main(String[] args) throws IOException {
		try (Scanner sc = new Scanner(System.in)) {
			final int N = sc.nextInt();
			
			final int size = 5 * 2;
			
			boolean[][] opened = new boolean[N][size];
			for(int i = 0; i < N; i++){
				for(int j = 0; j < size; j++){
					opened[i][j] = sc.nextInt() == 1;
				}
			}
			
			long[][] score = new long[N][size + 1];
			for(int i = 0; i < N; i++){
				for(int j = 0; j <= size; j++){
					score[i][j] = sc.nextLong();
				}
			}
			
			long answer = Long.MIN_VALUE;
			
			for(int open_bit = 1; open_bit < (1 << size); open_bit++){
				
				long sum = 0;
				for(int shop = 0; shop < N; shop++){
					int same_count = 0;
					
					for(int i = 0; i < size; i++){
						if((open_bit & (1 << i)) == 0){ continue; }
						if(!opened[shop][i]){ continue; }
						
						same_count++;
					}
					
					sum += score[shop][same_count];
				}
				
				answer = Math.max(answer, sum);
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
			while (!hasNext()) {
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
			for (int i = 0; i < n; i++) {
				ret[i] = this.nextInt();
			}
			return ret;
		}

		public long[] nextLongArray(int n) throws IOException {
			final long[] ret = new long[n];
			for (int i = 0; i < n; i++) {
				ret[i] = this.nextLong();
			}
			return ret;
		}

		public void close() throws IOException {
			br.close();
		}
	}
}