import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map.Entry;

import java.util.PriorityQueue;
import java.util.Random;
import java.util.StringTokenizer;
import java.util.TreeSet;


public class Main {

	public static void main(String[] args) throws IOException {	
		try(final Scanner sc = new Scanner(System.in)){
			final char[] N = sc.next().toCharArray();
			final int K = sc.nextInt();
			
			final int digits = 10;
			final int length = N.length;
			
			long[][][] DP = new long[length][digits][K + 1];
			DP[0][0][0] = 1; 
			for(int d = 1; d < digits; d++) {
				for(int k = 0; k <= K; k++) {
					DP[0][d][k] = (k == 1) ? 1 : 0;
				}
			}
			
			for(int i = 0; i < length - 1; i++) {
				for(int d = 0; d < digits; d++) {
					for(int k = 0; k <= K; k++) {
						if(DP[i][d][k] == 0) { continue; }
						
						DP[i + 1][0][k] += DP[i][d][k];
						if(k == K) { continue; }

						for(int e = 1; e < digits; e++) {
							DP[i + 1][e][k + 1] += DP[i][d][k];
						}
					}
				}
			}
			
			long answer = 0;
			int preK = 0;
			
			for(int i = 0; i < length; i++) {
				final int d = N[i] - '0';
				if(preK > K) { break; }
				
				final int k = K - preK;
				
				for(int x = 0; x < d; x++) {
					answer += DP[(length - 1) - i][x][k];
					//System.out.println(((length - 1 ) - i) + " " + x + " " + k + " " + DP[(length - 1) - i][x][k]);
				}
				
				preK += (d == 0 ? 0 : 1);
			}
			
			{
				int z = 0;
				for(int i = 0; i < N.length; i++) {
					final int d = N[i] - '0';
					if(d != 0) { z += 1; }
				}
				
				if(z == K) { answer += 1; }
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