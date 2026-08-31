
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Practice {

	public static void main(String args[]) throws IOException {
		Scanner sc = new Scanner(System.in);
		String [] first = new String [2];
		first[0] = sc.next();
		first[1] = sc.next();
		int days = sc.nextInt();
		System.out.println(first[0] + " " + first[1]);
		for(int i =0; i < days; i++)
		{
			String one = sc.next();
			String tow = sc.next();
			if(one.equals(first[0]))
				first[0] = tow;
			else
				first[1] = tow;
			
			System.out.println(first[0] + " " + first[1]);
		}
			
	}

	static class Scanner {
		StringTokenizer st;
		BufferedReader br;

		public Scanner(InputStream s) {
			br = new BufferedReader(new InputStreamReader(s));
		}

		public String next() throws IOException {
			while (st == null || !st.hasMoreTokens())
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}

		public int nextInt() throws IOException {
			return Integer.parseInt(next());
		}

		public long nextLong() throws IOException {
			return Long.parseLong(next());
		}

		public String nextLine() throws IOException {
			return br.readLine();
		}

		public double nextDouble() throws IOException {
			return Double.parseDouble(next());
		}

		public boolean ready() throws IOException {
			return br.ready();
		}

	}
}
