import java.util.Scanner;

// https://codeforces.com/problemset/problem/1391/C
public class CyclicPermutations {
	static int mod = 1000000007;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long n = sc.nextLong();
		long temp = n, ans = 1, temp2 = 1;
		while (temp > 0) {
			ans = (ans * temp) % mod;
			if (temp > 1)
				temp2 = (temp2 * 2) % mod;
			temp--;
		}
		ans = ans - temp2;
		if (ans < 0) ans += mod;
		System.out.println(ans);
	}

}
