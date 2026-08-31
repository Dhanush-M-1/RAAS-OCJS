import java.util.Scanner;

//AtCoder Beginner Contest 154
//E	Almost Everywhere Zero
public class Main {

	static String removeHeadZero(String N) {
		StringBuilder S = new StringBuilder();
		boolean hasNonZero = false;
		for (int i = 0; i < N.length(); i++) {
			if (!hasNonZero && N.charAt(i) - 48 != 0) {
				hasNonZero = true;
			}
			if (hasNonZero) {
				S.append(N.charAt(i));
			}
		}
		return S.toString();
	}

	static long countK1(String N) {
		String S = removeHeadZero(N);
		if (S.length() == 0) {
			return 0l;
		}
		long ans = 0;
		ans += S.charAt(0) - 48;
		ans += (S.length()-1) * 9;
		return ans;
	}

	static long countK2(String N) {
		String S = removeHeadZero(N);
		if (S.length() <= 1) {
			return 0l;
		}
 		long ans = 0;
		int first = S.charAt(0) - 48;
		StringBuilder nines = new StringBuilder();
		for (int i = 0; i < S.length()-1; i++) {
			nines.append("9");
		}
		ans += countK2(nines.toString());
		ans += (first-1) * countK1(nines.toString());
		ans += countK1(S.substring(1));
		return ans;
	}

	static long countK3(String N) {
		if (N.length() <= 2) {
			return 0l;
		}
 		long ans = 0;
		int first = N.charAt(0) - 48;
		StringBuilder nines = new StringBuilder();
		for (int i = 0; i < N.length()-1; i++) {
			nines.append("9");
		}
		ans += countK3(nines.toString());
		ans += (first-1) * countK2(nines.toString());
		ans += countK2(N.substring(1));
		return ans;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String N = sc.next();
		int K = Integer.parseInt(sc.next());
		sc.close();

		long ans = 0;
		if (K == 1) {
			ans = countK1(N);
		}
		if (K == 2) {
			ans = countK2(N);
		}
		if (K == 3) {
			ans = countK3(N);
		}

		System.out.println(ans);
	}
}
