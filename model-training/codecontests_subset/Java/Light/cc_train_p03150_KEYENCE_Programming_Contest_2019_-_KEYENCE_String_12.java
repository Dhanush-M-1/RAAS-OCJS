import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) {
		FastReader fr = new FastReader();
		String s = fr.nextLine();
		String v = "keyence";
		int n = s.length();
		boolean pos = false;
		for (int i=0; i<v.length(); i++) {
			String t = s.substring(0, i);
			String rest = v.substring(t.length());
			if (s.substring(n-rest.length(), n).equals(rest) && (t+rest).equals(v)) {
				pos = true;
				break;
			}
		}
		
		if (pos) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
	}
	
	static class FastReader {
		BufferedReader br;
		StringTokenizer st;

		public FastReader() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		public String next() {
			while (st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
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
			String str = "";
			try {
				str = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return str;
		}
	}

}
