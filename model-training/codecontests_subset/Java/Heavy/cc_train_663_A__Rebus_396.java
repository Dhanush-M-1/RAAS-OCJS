import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;

public class C347B {

	static StringTokenizer st;
	static BufferedReader br;
	static PrintWriter pw;
	static int[] vplus = new int [101];
	static int[] vminus = new int [101];
	static int lp = 0, lm = 0;
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		int plus = 1;
		int minus = 0;
		boolean[] znak = new boolean [101];
		int len = 0;
		next();
		String sign = next();
		while (!sign.equals("=")) {
			if (sign.equals("+")) {
				plus++;
				len++;
			} else {
				minus++;
				znak[len++] = true;
			}
			next();
			sign = next();
		}
		int n = nextInt();
		//System.out.println(plus + " " + minus + " " + n);
		if (plus == 1) {
			if (minus > 0) {
				pw.println("Impossible");
			} else {
				pw.println("Possible");
				pw.println(n + " = " + n);
			}
		} else {
			if ((plus * n - minus < n) || (plus - n * minus > n))
				pw.println("Impossible");
			else {
				find(plus, minus, n, n);
				pw.println("Possible");
				int curp = 0, curm = 0;
				pw.print(vplus[curp++]);
				for (int i = 0; i < len; ++i) 
					if (!znak[i]) {
						pw.print(" + " + vplus[curp++]);
					} else {
						pw.print(" - " + vminus[curm++]);
					}
				pw.println(" = " + n);
			}
		}
		pw.close();
	}
	
	private static void find(int plus, int minus, int n, int ans) {
		if (plus + minus == 0)
			return;
		if (plus == 0) {
			//System.out.println(minus + "  " + ans);
			if ((minus - 1) * n >= -ans) {
				vminus[lm++] = 1;
				find(plus, minus - 1, n, ans + 1);
			} else {
				if (n * minus >= -ans && (-ans - n + (minus - 1) * n > 0)) {
					vminus[lm++] = n;
					find(plus, minus - 1, n, ans + n);
				} else {
					if (minus == 1) {
						vminus[lm++] = -ans;
						return;
					} else {
						int a = 1 / 0;
					}
				}
			}
		} else if (check(plus - 1, minus, n, ans - 1)) {
			vplus[lp++] = 1;
			find(plus - 1, minus, n, ans - 1);
		} else if (check(plus - 1, minus, n, ans - n)) {
			//System.out.print(plus + " " + minus + " " + ans);
			vplus[lp++] = n;
			find(plus - 1, minus, n, ans - n);
		} else {
			if (plus == 1) {
				for (int i = 1; i <= n; ++i) {
					if (check(0, minus, n, ans - i)) {
						vplus[lp++] = i;
						find(0, minus, n, ans - i);
						return;
					}
				}
			} else {
				//System.out.println(plus + " " + minus + " " + ans);
				int a = 1 / 0;
			}
		}
		
	}

	private static boolean check(int plus, int minus, int n, int ans) {
		boolean answ1 = plus * n - minus >= ans;
		boolean answ2 = plus - minus * n <= ans;
		return answ1 && answ2;
	}

	private static int sumf(int[] fen, int id) {
		int summ = 0;
		for (; id >= 0; id = (id & (id + 1)) - 1) 
 			summ += fen[id];
		return summ;
	}

	private static void addf(int[] fen, int id) {
		for (; id < fen.length; id |= id + 1) 
			fen[id]++;
	}

	private static int nextInt() throws IOException {
		return Integer.parseInt(next());
	}
	private static long nextLong() throws IOException {
		return Long.parseLong(next());
	}
	private static double nextDouble() throws IOException {
		return Double.parseDouble(next());
	}
	private static String next() throws IOException {
		while (st==null || !st.hasMoreTokens())
			st = new StringTokenizer(br.readLine());
		return st.nextToken();
	}
}