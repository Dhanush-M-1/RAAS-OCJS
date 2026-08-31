import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;

//http://codeforces.com/contest/1043/problem/A
public class Main2 {

	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader in = new InputReader(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		XeniaAndBitOperations solver = new XeniaAndBitOperations();
//		int test = in.nextInt();
//		while (test-- > 0)
			solver.solve(1, in, out);
		out.close();
	}

	static class XeniaAndBitOperations {

		public void solve(int testNumber, InputReader in, PrintWriter out) {

			long n = in.nextLong();
			long sum = 0;
			long max = -1;
			for(int i=0; i<n; i++){
				
				long num = in.nextLong();
				sum += num;
				if(num>max)
					max=num;
			}
			
			long ans = max;
			while(n*ans<=2*sum)
				ans++;
			
			out.println(ans);
			

		}
	}

	private static long digitsum(long x) {
		long t = x;
		long ans = 0L;
		while(t>0){
			ans += t%10;
			t = t/10;
		}
		
		return ans;
	}

	static class InputReader {
		public BufferedReader reader;
		public StringTokenizer tokenizer;

		public InputReader(InputStream stream) {
			reader = new BufferedReader(new InputStreamReader(stream), 32768);
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

	}
}