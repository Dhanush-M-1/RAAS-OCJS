import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	public void solve() throws IOException {
		int n = in.nextInt(), i = 0, ans = 0;
		String s = in.next();
		
		for (int j = 0; j < n; ++j) {
			i += s.charAt(j) == 'I' ? 1 : 0;
		}
		
		for (int j = 0; j < n; ++j) {
			if (s.charAt(j) == 'A') {
				ans += i == 0 ? 1 : 0;
			} else if (s.charAt(j) == 'I') {
				ans += i == 1 ? 1 : 0;
			}
		}
		
		System.out.println(ans);
	}
	
	public void run() throws IOException {
		in = new MyScanner();
		solve();
		in.close();
	}
	
	private MyScanner in;
	//private PrintWriter out;
	
	public class MyScanner {
		private BufferedReader br;
		private StringTokenizer st;
		
		public MyScanner() {
			this.br = new BufferedReader(new InputStreamReader(System.in));
		}
		
		public MyScanner(String fileTitle) throws IOException {
			this.br = new BufferedReader(new FileReader(fileTitle + ".in"));
		}
		
		public String next() throws IOException {
			while (st == null || !st.hasMoreTokens()) {
				String s = br.readLine();
				if (s == null) {
					return "-1";
				}
				st = new StringTokenizer(s);
			}
			return st.nextToken();
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
		
		public int[] nextIntArray(int size) throws IOException {
			int[] arr = new int[size];
			for (int i = 0; i < size; ++i) {
				arr[i] = nextInt();
			}
			return arr;
		}
		
		public void close() throws IOException {
			br.close();
		}
	}
	
	public static void main(String[] args) throws IOException {
		new Solution().run();
	}

}
