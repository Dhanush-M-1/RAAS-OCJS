import java.math.BigInteger;
import java.util.Scanner;

public class Main {

	static Scanner sc = new Scanner(System.in);
	static int M;
	static int[] mm;
	static int MOD = 10000;

	static boolean check(char[] s) {
		if (s.length == 1) return true;
		if (s[0] == s[1]) return false;
		boolean top = s[0] < s[1];
		for (int i = 1; i < s.length - 1; ++i) {
			if (s[i] == s[i + 1]) return false;
			boolean expect = top ^ (i % 2 != 0);
			if (expect != s[i] < s[i + 1]) return false;
		}
		return true;
	}

	static int naive(int min, int max) {
		int ret = 0;
		for (int i = min; i <= max; ++i) {
			if (i % M != 0) continue;
			char[] a = Integer.toString(i).toCharArray();
			if (check(a)) ++ret;
		}
		return ret;
	}

	static int solve(String upper) {
//		System.out.println("upper:" + upper);
		int L = upper.length();
		int ret = 1;
		if (L <= 2) {
			int u = Integer.parseInt(upper);
			for (int i = 1; i <= u; ++i) {
				if (i % 11 == 0 || i % M != 0) continue;
				++ret;
			}
			return ret;
		}
		for (int i = 1; i <= 99; ++i) {
			if (i % 11 == 0 || i % M != 0) continue;
			++ret;
		}
		int[] d = new int[L];
		for (int i = 0; i < L; ++i) {
			d[i] = upper.charAt(i) - '0';
		}
		int[][][][] dp = new int[2][L][M][10];
		for (int i = 0; i <= 9; ++i) {
			dp[0][0][i % M][i] += 1;
			dp[1][0][i % M][i] += 1;
		}
		for (int i = 1; i < L - 1; ++i) {
			for (int j = 0; j <= 9; ++j) {
				for (int k = 0; k < j; ++k) {
					for (int l = 0; l < M; ++l) {
						dp[0][i][(l + k * mm[i]) % M][k] += dp[1][i - 1][l][j];
						if (dp[0][i][(l + k * mm[i]) % M][k] >= MOD) dp[0][i][(l + k * mm[i]) % M][k] -= MOD;
					}
				}
				for (int k = j + 1; k <= 9; ++k) {
					for (int l = 0; l < M; ++l) {
						dp[1][i][(l + k * mm[i]) % M][k] += dp[0][i - 1][l][j];
						if (dp[1][i][(l + k * mm[i]) % M][k] >= MOD) dp[1][i][(l + k * mm[i]) % M][k] -= MOD;
					}
				}
			}
			if (i >= 2) {
				for (int j = 1; j <= 9; ++j) {
					ret += dp[0][i][0][j] + dp[1][i][0][j];
				}
			}
			ret %= MOD;
		}
//		System.out.println(ret);
		for (int j = 0; j <= 9; ++j) {
			for (int k = 0; k < j && k < d[0]; ++k) {
				for (int l = 0; l < M; ++l) {
					dp[0][L - 1][(l + k * mm[L - 1]) % M][k] += dp[1][L - 2][l][j];
					if (dp[0][L - 1][(l + k * mm[L - 1]) % M][k] >= MOD) dp[0][L - 1][(l + k * mm[L - 1]) % M][k] -= MOD;
				}
			}
			for (int k = j + 1; k <= 9 && k < d[0]; ++k) {
				for (int l = 0; l < M; ++l) {
					dp[1][L - 1][(l + k * mm[L - 1]) % M][k] += dp[0][L - 2][l][j];
					if (dp[1][L - 1][(l + k * mm[L - 1]) % M][k] >= MOD) dp[1][L - 1][(l + k * mm[L - 1]) % M][k] -= MOD;
				}
			}
		}
		for (int j = 1; j < d[0]; ++j) {
			ret += dp[0][L - 1][0][j] + dp[1][L - 1][0][j];
			//			System.out.println(j + " " + dp[0][L - 1][0][j] + " " + dp[1][L - 1][0][j]);
		}
//		System.out.println(ret);
		ret %= MOD;

		int mmSur = d[0] * mm[L - 1] % M;
		for (int i = 0; i < Math.min(d[0], d[1]); ++i) {
			ret += dp[0][L - 2][(M - mmSur) % M][i];
		}
		for (int i = d[0] + 1; i < d[1]; ++i) {
			ret += dp[1][L - 2][(M - mmSur) % M][i];
		}
		//		System.out.println(ret);
		if (d[0] != d[1]) {
			boolean top = d[0] > d[1];
			mmSur = (mmSur + d[1] * mm[L - 2]) % M;
			if (top) {
				for (int i = d[1] + 1; i < d[2]; ++i) {
					ret += dp[1][L - 3][(M - mmSur) % M][i];
				}
			} else {
				for (int i = 0; i < Math.min(d[1], d[2]); ++i) {
					ret += dp[0][L - 3][(M - mmSur) % M][i];
				}
			}
			for (int i = 2; i < L; ++i) {
				if (d[i] == d[i - 1]) break;
				mmSur = (mmSur + d[i] * mm[L - 1 - i]) % M;
				boolean expect = top;
				expect ^= i % 2 == 0;
				boolean actual = d[i - 1] > d[i];
//				System.out.println(i + " " + expect + " " + actual);
				if (expect != actual) break;
				if (i == L - 1) {
					if (mmSur == 0) ++ret;
					break;
				}
				if (actual) {
					for (int j = d[i] + 1; j < d[i + 1]; ++j) {
						ret += dp[1][L - (i + 2)][(M - mmSur) % M][j];
					}
				} else {
					for (int j = 0; j < Math.min(d[i], d[i + 1]); ++j) {
						ret += dp[0][L - (i + 2)][(M - mmSur) % M][j];
					}
				}
//				System.out.println(ret);
			}
		}
		ret %= MOD;
//		System.out.println(ret);
		return ret;
	}

	public static void main(String[] args) {
		String A = sc.next();
		String B = sc.next();
		M = sc.nextInt();
//		System.out.println(naive(0, Integer.parseInt(A) - 1));
//		System.out.println(naive(0, Integer.parseInt(B)));
		mm = new int[B.length()];
		mm[0] = 1 % M;
		for (int i = 1; i < mm.length; ++i) {
			mm[i] = mm[i - 1] * 10 % M;
		}
		int nb = solve(B);
		int na = solve(new BigInteger(A).subtract(BigInteger.ONE).toString());
		System.out.println((nb - na + MOD) % MOD);
	}
}