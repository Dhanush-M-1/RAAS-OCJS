import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class Practice {
	public static long mod = (long) Math.pow(10, 9) + 7;
	public static long mod2 = 998244353;
	public static int tt = 1;
	public static ArrayList<Integer> prime;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		int t = Integer.parseInt(br.readLine());

		while (t-- > 0) {
			String[] s1 = br.readLine().split(" ");
			int n = Integer.valueOf(s1[0]);
			long l = Long.valueOf(s1[1]);
			long r = Long.valueOf(s1[2]);
			long curr = 1;
			long no = 1;
			StringBuilder str = new StringBuilder();
			while (true) {
				long h = (n - no) * 2;
				if (h == 0) {
					break;
				}
				// System.out.println(h);
				if (h + curr < l) {
					// System.out.println("999");
				} else {
					long k = l - curr;
	//				System.out.println(k);
					long st = -1;
					if (k % 2 == 0) {
						k = k / 2;
						st = no + k + 1;
					} else {
						k = k / 2;
						str.append((no + k + 1) + " ");
						l++;
						if (l > r) {
							break;
						}
						st = no + k + 2;
					}
	//				System.out.println(st + " " + no + " " + l);
					while (st <= n) {
						str.append((no) + " ");
						l++;
						if (l > r) {
							break;
						}
						str.append((st) + " ");
						l++;
						// System.out.println(l);
						if (l > r) {
							break;
						}
						st++;
					}
					if (l > r) {
						break;
					}
					// System.out.println(str);

				}
			//	System.out.println(curr + " " + no + " " + h + " " + str);
//				if (no == 3) {
//					break;
//				}
				curr += h;
				no++;
			}
			if (l == r) {
				str.append(1 + " ");
			}

			pw.println(str.toString());
		}
		pw.close();
	}

}

//	private static void getFac(long n, PrintWriter pw) {
//		// TODO Auto-generated method stub
//		int a = 0;
//		while (n % 2 == 0) {
//			a++;
//			n = n / 2;
//		}
//		if (n == 1) {
//			a--;
//		}
//		for (int i = 3; i <= Math.sqrt(n); i += 2) {
//			while (n % i == 0) {
//				n = n / i;
//				a++;
//			}
//		}
//		if (n > 1) {
//			a++;
//		}
//		if (a % 2 == 0) {
//			pw.println("Bob");
//		} else {
//			pw.println("Alice");
//		}
//		//System.out.println(a);
//		return;
//	}

//	private static long power(long a, long p) {
//		// TODO Auto-generated method stub
//		long res = 1;
//		while (p > 0) {
//			if (p % 2 == 1) {
//				res = (res * a) % mod;
//			}
//			p = p / 2;
//			a = (a * a) % mod;
//		}
//		return res;
//	}
//
//	private static void fac() {
//		fac[0] = 1;
//		// TODO Auto-generated method stub
//		for (int i = 1; i < fac.length; i++) {
//			if (i == 1) {
//				fac[i] = 1;
//			} else {
//				fac[i] = i * fac[i - 1];
//			}
//			if (fac[i] > mod) {
//				fac[i] = fac[i] % mod;
//			}
//		}
//	}
//
//	private static int getLower(Long long1, Long[] st) {
//		// TODO Auto-generated method stub
//		int left = 0, right = st.length - 1;
//		int ans = -1;
//		while (left <= right) {
//			int mid = (left + right) / 2;
//			if (st[mid] <= long1) {
//				ans = mid;
//				left = mid + 1;
//			} else {
//				right = mid - 1;
//			}
//		}
//		return ans;
//	}

//	private static long getGCD(long l, long m) {
//
//		long t1 = Math.min(l, m);
//		long t2 = Math.max(l, m);
//		while (true) {
//			long temp = t2 % t1;
//			if (temp == 0) {
//				return t1;
//			}
//			t2 = t1;
//			t1 = temp;
//		}
//	}