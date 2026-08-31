import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class D2 {
	
	public static class Pair implements Comparable<Pair> {
		int idx;
		long value;
		
		public Pair(int idx, long value){
			this.idx = idx;
			this.value = value;
		}

		@Override
		public int compareTo(Pair o) {
			return -Long.compare(this.value, o.value);
		}
	}
	
	public static void main(String[] args) {
		try (final Scanner sc = new Scanner(System.in)) {
			final int n = sc.nextInt();
			final long d = sc.nextLong();
			
			long[] as = new long[n];
			for(int i = 0; i < n; i++){
				as[i] = sc.nextLong();
			}
			
			PriorityQueue<Pair> queue = new PriorityQueue<Pair>();
			{
				long cost = 0;
				for(int i = 0; i < n; i++){
					cost += as[i];
					queue.add(new Pair(i, cost));
				}
			}
			
			int answer = 0;
			
			long curr_value = 0;
			long glob_plus = 0;
			for(int i = 0; i < n; i++){
				curr_value += as[i];
				
				if(curr_value > d){
					System.out.println(-1);
					return;
				}else if(as[i] != 0){
					continue;
				}else if(curr_value >= 0){
					continue;
				}
				
				long back_max = Long.MIN_VALUE;
				while(!queue.isEmpty()){
					final Pair p = queue.poll();
					
					if(p.idx < i){ continue; }
					
					back_max = p.value + glob_plus;
					queue.add(p);
					break;
				}
				
				final long can_up = d - back_max;
				final long back_plus = Math.min(d, curr_value + can_up) - curr_value;
				//System.out.println(back_max + " " + back_plus + " " + curr_value);
				if(curr_value + back_plus < 0){
					System.out.println(-1);
					return;
				}
				
				glob_plus += back_plus;				
				curr_value += back_plus;
				answer++;
			}
			
			System.out.println(answer);
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
