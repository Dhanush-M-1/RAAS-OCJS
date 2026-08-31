import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;


public class c_714 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		FastScanner in = new FastScanner(System.in);
		OutputStream outputStream = System.out;
		PrintWriter out = new PrintWriter(outputStream);
		
		int T = in.nextInt();
		Solver A = new Solver(in, out); 
		A.precompute();
		for(int aa = 0; aa < T; aa++) {
			A.answer(aa + 1);
		}
		
		
		out.close();
	}
	
	static class Solver {
		FastScanner in;
		PrintWriter out;
		
		long answer [][] = new long [10][300000];
		final long MOD = 1000000007;

		public Solver(FastScanner in, PrintWriter out) {
			this.in = in;
			this.out = out;
		}
		
		public void precompute() {
			for(int i = 0; i < 10; i++) {
				answer[i][0] = 1;
			}
			
			for(int i = 1; i < 250000; i++) {
				for(int j = 0; j < 10; j++) {
					if(i >= 10 - j) {
						answer[j][i] = (answer[1][i - (10 - j)] + answer[0][i - (10 - j)])%MOD;
					} else {
						answer[j][i] = 1;
					}
				}
			}
		}
		
		public void answer(int aa) throws Exception {
			char s [] = in.next().toCharArray();
			int M = in.nextInt();
			long ans = 0;
			for(char x : s) {
				ans = (ans + answer[x - '0'][M])%MOD;
			}
			out.println(ans);
		}
		
		
	}

	static class FastScanner {
		BufferedReader br;
		StringTokenizer st;

		public FastScanner(InputStream stream) {
			br = new BufferedReader(new InputStreamReader(stream));
			st = new StringTokenizer("");
		}

		public FastScanner(String fileName) throws Exception {
			br = new BufferedReader(new FileReader(new File(fileName)));
			st = new StringTokenizer("");
		}

		public String next() throws Exception {
			while (!st.hasMoreTokens()) {
				st = new StringTokenizer(br.readLine());
			}
			return st.nextToken();
		}

		public int nextInt() throws Exception {
			return Integer.parseInt(next());
		}

		public long nextLong() throws Exception {
			return Long.parseLong(next());
		}

		public Double nextDouble() throws Exception {
			return Double.parseDouble(next());
		}

		public String nextLine() throws Exception {
			if (st.hasMoreTokens()) {
				StringBuilder str = new StringBuilder();
				boolean first = true;
				while (st.hasMoreTokens()) {
					if (first) {
						first = false;
					} else {
						str.append(" ");
					}
					str.append(st.nextToken());
				}
				return str.toString();
			} else {
				return br.readLine();
			}
		}
	}
	
}
