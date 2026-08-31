import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;
 
public class Solution {
	public static void main(String[] args) {
		InputReader in = new InputReader();
		PrintWriter out = new PrintWriter(System.out);
		Thread th = new Thread(null, new Runnable(){public void run(){new Task1().solve(in, out);}},"Task1",1<<24);
		try{
			th.start();
			th.join();
		} catch(InterruptedException e){}
		out.close();
	}
	
	static class Task1 {
		static final int MAX = 30;
		static final int MOD = 1000000007;
		boolean[] isPrime;
		public void solve(InputReader in, PrintWriter out){ 
			int n = in.nextInt();
			int[] h = new int[n], g = new int[n];
			int[] count = new int[101];
			for(int i=0; i<n; i++){
				h[i] = in.nextInt();
				g[i] = in.nextInt();
				count[h[i]]++;
			}

			int ans = 0;
			for(int i=0; i<n; i++){
				ans += count[g[i]];
			}
			out.println(ans);
		}

		void sieve(){
			isPrime = new boolean[MAX];
			Arrays.fill(isPrime, true);
			isPrime[0] = isPrime[1] = false;
			for(int i=2; i<MAX; i++){
				if(isPrime[i]){
					for(int j=i+i; j<MAX; j+=i){
						isPrime[j] = false;
					}
				}
			}
		}

		long expo(long a, long b){
			long result = 1;
			while(b>0){
				if(b%2==1) result *= a;
				a = a*a;
				b = b>>1;
			}
			return result;
		}
	}
	static class InputReader {
		public BufferedReader reader;
		public StringTokenizer tokenizer;
		public InputReader() {
			reader = new BufferedReader(new InputStreamReader(System.in));
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
		public int nextInt() {
			return Integer.parseInt(next());
		}
		public long nextLong() {
			return Long.parseLong(next());
		}
		public double nextDouble() {
			return Double.parseDouble(next());
		}
		public String nextLine() {
			String s=null;
			try{
				s = reader.readLine();
			} catch(IOException e){
				throw new RuntimeException(e);
			}
			return s;
		}
		public String nextParagraph() {
			String line=null;
			String ans = "";
			try{
				while ((line = reader.readLine()) != null) {
				ans += line;
				}
			} catch(IOException e){
				throw new RuntimeException(e);
			}
			return ans;
		}
	}
}