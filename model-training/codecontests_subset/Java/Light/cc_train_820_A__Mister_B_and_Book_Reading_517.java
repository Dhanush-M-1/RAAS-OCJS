import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class CF820A {
	public static void main(String[] args) {
		FastReader fr = new FastReader();
		int c = fr.nextInt();
		int v0 = fr.nextInt();
		int v1 = fr.nextInt();		//cannot read more that this
		int a = fr.nextInt();
		int rr = fr.nextInt();
		int days = 0;
		int cur = v0;
		boolean done = false;
		int day = 1;
		int rem = c - cur;
		while(rem>0)
		{
			cur = ((day*a)+v0);
			if(cur>v1)
				cur = v1;
			cur = cur - rr;
			rem = rem - cur;
			day++;
		}
		System.out.println(day);
	}

	//Better IO Class
	static class FastReader {
		BufferedReader br;
		StringTokenizer st;

		FastReader() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() {
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

		public Double nextDouble() {
			return Double.parseDouble(next());
		}

		public Float nextFloat() {
			return Float.parseFloat(next());
		}

		String nextLine() {
			String str = "";
			try {
				str = br.readLine();
			} catch (IOException e) {
				System.out.println(e);
			}
			return str;
		}
	}
}
