import java.io.*;
import java.util.*;
 
public class io8 {
 
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	PrintWriter pw = new PrintWriter(System.out);
	long MOD = (long) (1e9 + 7);
 
	public static void main(String[] args) throws IOException {
		io8 m = new io8();
		m.solve();
		m.close();
	}
 
	void solve() throws IOException {
		long vv[][] = new long[(int) (2e5 + 1)][10];
		int r = vv.length;
		for (int i = 0; i < 10; i++) {
			int dig[] = new int[10];
			dig[i] = 1;
			int ii = 1;
			while (ii < r) {
				int fv[] = new int[10];
				for (int g = 0; g < 9; g++)
					fv[g + 1] = dig[g];
				if (dig[9] != 0) {
					fv[0] += dig[9];
					fv[1] += dig[9];
					fv[0] %= MOD;
					fv[1] %= MOD;
				}
				long cnt = 0;
				for (long v : fv) {
					cnt += v;
					cnt %= MOD;
				}
				vv[ii][i] = cnt;
				dig = fv;
				ii++;
			}
		}
		StringBuilder king = new StringBuilder();
		for (int t = i(); t > 0; --t) {
			int i1[] = readIntLine();
			int n = i1[0], m = i1[1];
			int d[] = new int[10];
			while (n != 0) {
				d[n % 10]++;
				n /= 10;
				
				
				
				
			}
			long aa = 0;
			for (int i = 0; i < 10; i++) {
				if (d[i] == 0)
					continue;
				long p = d[i] * vv[m][i];
				p %= MOD;
				aa += p;
				aa %= MOD;
			}
			king.append(aa);
			king.append("\n");
		}
		pw.print(king);
		pw.flush();
	}
 
	public static int gcd(int a, int b) {
		return (b == 0) ? a : gcd(b, a % b);
	}
 
	void close() throws IOException {
		pw.flush();
		pw.close();
		br.close();
	}
 
	int i() throws IOException {
		return Integer.parseInt(br.readLine());
	}
 
	long l() throws IOException {
		return Long.parseLong(br.readLine());
	}
 
	String s() throws IOException {
		return br.readLine();
	}
 
	String[] readStrLine() throws IOException {
		String[] tokens = br.readLine().split(" ");
		return tokens;
	}
 
	int[] readIntLine() throws IOException {
		String[] tokens = br.readLine().split(" ");
		int[] A = new int[tokens.length];
		for (int i = 0; i < A.length; i++)
			A[i] = Integer.parseInt(tokens[i]);
		return A;
	}
 
	long[] readLongLine() throws IOException {
		String[] tokens = br.readLine().split(" ");
		long[] A = new long[tokens.length];
		for (int i = 0; i < A.length; i++)
			A[i] = Long.parseLong(tokens[i]);
		return A;
	}
}