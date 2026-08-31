import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class B {
	
	public static void main(String[] args) {
		try (final Scanner sc = new Scanner(System.in)) {
			
			final int n = sc.nextInt();
			final long k = sc.nextLong();
			
			long[] ids = new long[n];
			for(int i = 0; i < n; i++){
				ids[i] = sc.nextLong();
			}
			
			for(long pos = 1; pos <= n; pos++){
				final long last_pos  = pos * (pos + 1) / 2;
				final long first_pos = ((pos - 1) * pos / 2) + 1;
				//System.out.println(first_pos + " " + last_pos);
				
				if(k > last_pos){ continue; }
				final int index = (int)((k - first_pos) % n);
				//System.out.println(index);
				
				System.out.println(ids[index]);
				return;
			}
			
		}
	}

	public static class Scanner implements Closeable {
		private BufferedReader br;
		private StringTokenizer tok;

		public Scanner(InputStream is) {
			br = new BufferedReader(new InputStreamReader(is));
		}

		private void getLine() {
			try {
				while (!hasNext()) {
					tok = new StringTokenizer(br.readLine());
				}
			} catch (IOException e) { /* ignore */
			}
		}

		private boolean hasNext() {
			return tok != null && tok.hasMoreTokens();
		}

		public String next() {
			getLine();
			return tok.nextToken();
		}

		public int nextInt() {
			return Integer.parseInt(next());
		}

		public long nextLong() {
			return Long.parseLong(next());
		}

		public void close() {
			try {
				br.close();
			} catch (IOException e) { /* ignore */
			}
		}
	}
}
