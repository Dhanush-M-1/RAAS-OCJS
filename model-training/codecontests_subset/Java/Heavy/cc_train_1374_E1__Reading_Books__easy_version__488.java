import java.util.*;
import java.io.*;
import java.math.*;
 
public class Main {

	private static FastReader fr = new FastReader();
	private static Helper helper = new Helper();
	private static StringBuilder result = new StringBuilder();
 
	public static void main(String[] args) {
		Task solver = new Task();
		solver.solve();
	}
 
	static class Task {
	    
		public void solve() {
		    int n = fr.ni(), k = fr.ni();
			int countA=0, countB = 0;
			long ans = 0;
			PriorityQueue<Integer> a = new PriorityQueue<>();
			PriorityQueue<Integer> b = new PriorityQueue<>();
			PriorityQueue<Integer> ab = new PriorityQueue<>();
			for(int i=0; i<n; i++){
				int t = fr.ni(), ai = fr.ni(), bi = fr.ni();
				if(ai == 1 && bi == 1) ab.add(t);
				else if(ai == 1) a.add(t);
				else if(bi == 1) b.add(t);
			}
			while(countA < k || countB < k){
				if(!ab.isEmpty() && !a.isEmpty() && !b.isEmpty()){
					if(ab.peek() <= a.peek() + b.peek()) ans += ab.poll();
					else ans += a.poll() + b.poll();
					countA++;
					countB++;
				}
				else if(!ab.isEmpty()){
					ans += ab.poll();
					countA++;
					countB++;
				}
				else if(!a.isEmpty() && countA < k){
					ans += a.poll();
					countA++;
				}
				else if(!b.isEmpty() && countB < k){
					ans += b.poll();
					countB++;
				}
				else break;
			}
			if(countA < k || countB < k) System.out.println(-1);
			else System.out.println(ans);
		}
	}
    
    static class Helper{
		public long[] tiArr(int n, int si){
			long[] arr = new long[n];
			for(int i=si; i<n; i++) arr[i] = fr.nl();
			return arr;
		}
	}
 
	static class FastReader {
		public BufferedReader reader;
		public StringTokenizer tokenizer;
		private static PrintWriter pw;
 
		public FastReader() {
			reader = new BufferedReader(new InputStreamReader(System.in));
			pw = new PrintWriter(System.out);
			tokenizer = null;
		}
 
		public String next() {
			while (tokenizer == null || !tokenizer.hasMoreTokens()) {
				try {
					tokenizer = new StringTokenizer(reader.readLine());
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
			return tokenizer.nextToken();
		}
 
		public int ni() {
			return Integer.parseInt(next());
		}
 
		public long nl() {
			return Long.parseLong(next());
		}
 
		public String rl() {
			try {
				return reader.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return null;
		}
 
		public void print(String str) {
			pw.print(str);
			pw.flush();
		}
	}
}