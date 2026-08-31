import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

//http://codeforces.com/contest/1015/problem/B
public class Main4 {

	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader in = new InputReader(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		XeniaAndBitOperations solver = new XeniaAndBitOperations();
		// while (test-- > 0)
		solver.solve(1, in, out);
		out.close();
	}

	static class XeniaAndBitOperations {

		public void solve(int testNumber, InputReader in, PrintWriter out) {
			int n = in.nextInt();
			int s = in.nextInt();
			
			int a[] = new int[n];
			for(int i=0; i<n; i++){
				a[i]= in.nextInt();
			}
			Arrays.sort(a);
			
			int mid = n/2;
			
			long ans = 0;
			if(s>a[n-1]){
				for(int i=n-1; i>=mid; i--)
					ans += (s-a[i]);
			}
			else if(s<a[0]){
				for(int i=0; i<=mid; i++)
					ans += (a[i]-s);
			}else{
				if(s>a[mid]){
					for(int i=mid; i<n && a[i]<s; i++)
						ans += (s-a[i]);
				}
				else if(s<a[mid]){
					for(int i=mid; i>=0 && a[i]>s; i--)
						ans += (a[i]-s);
				}
			}
			
			out.print(ans);
		}
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