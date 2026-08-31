import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Ajay {

	static class FastReader {
		BufferedReader br;
		StringTokenizer st;

		public FastReader() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() {
			while (st == null || !st.hasMoreTokens()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		String nextLine() {
			String str = "";
			try {
				str = br.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return str;
		}

		int nextInt() {
			return Integer.parseInt(next());
		}

		double nextDouble() {
			return Double.parseDouble(next());
		}

		long nextLong() {
			return Long.parseLong(next());
		}

		BigInteger nextBigIntger() {
			BigInteger bb = new BigInteger(next());
			return bb;
		}
	}

	public static void main(String[] args) {
		FastReader sc = new FastReader();
		long a1 = sc.nextLong();
		long a2 = sc.nextLong();
		long b1 = sc.nextLong();
		long b2 = sc.nextLong();
		long c1 = sc.nextLong();
		long c2 = sc.nextLong();
		if((a1-b1==b1-c1) && (a2-b2==b2-c2))
			System.out.println("No");
		else 
			System.out.println((a1-b1)*(a1-b1)+(a2-b2)*(a2-b2)==(b1-c1)*(b1-c1)+(b2-c2)*(b2-c2)?"Yes":"No");
	}
}
