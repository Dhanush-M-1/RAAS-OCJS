
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Rebus_CF663A {

	public static void main(String[] args) throws IOException {

		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);

		int pos = 1;
		int neg = 0;
		sc.next();
		ArrayList<Boolean> sign = new ArrayList<Boolean>();
		sign.add(true);
		int n = 0;
		while (true) {
			char sn = sc.next().charAt(0);
			switch (sn) {
			case '+':
				sign.add(true);
				pos++;
				sc.next();
				break;
			case '-':
				sign.add(false);
				neg++;
				sc.next();
				break;
			case '=':
				n = sc.nextInt();
				break;
			}
			if (n != 0)
				break;
		}
		int np = n;
		if (pos * n - neg < n || pos - neg * n > n)
			out.println("Impossible");
		else {
			out.println("Possible");
			boolean start = true;
			for (boolean sn : sign) {
				if (pos + neg == 1) {
					if (start)
						out.print(n);
					else if (sn)
						out.print(" + " + n);
					else
						out.print(" - " + (-1 * n));

				} else {
					if (sn) {
						pos--;
						if(!start)
							out.print(" + ");
						if( pos * np - neg >= n-np  && pos - neg * np <= n-np){
							out.print(np);
							n -= np;
						}
						else{
							out.print(1);
							n-= 1;
						}
					} else {
						if(!start)
							out.print(" - ");
						if( pos * np - neg >= n+np  && pos - neg * np <= n+np){
							out.print(np);
							n += np;
						}
						else{
							out.print(1);
							n += 1;
						}
						neg--;
					}
					start = false;
				}
			}
			out.println(" = "+ np);
		}

		out.flush();
		out.close();
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
			String x = next();
			StringBuilder sb = new StringBuilder("0");
			double res = 0, f = 1;
			boolean dec = false, neg = false;
			int start = 0;
			if (x.charAt(0) == '-') {
				neg = true;
				start++;
			}
			for (int i = start; i < x.length(); i++)
				if (x.charAt(i) == '.') {
					res = Long.parseLong(sb.toString());
					sb = new StringBuilder("0");
					dec = true;
				} else {
					sb.append(x.charAt(i));
					if (dec)
						f *= 10;
				}
			res += Long.parseLong(sb.toString()) / f;
			return res * (neg ? -1 : 1);
		}

		public boolean ready() throws IOException {
			return br.ready();
		}

	}

}
