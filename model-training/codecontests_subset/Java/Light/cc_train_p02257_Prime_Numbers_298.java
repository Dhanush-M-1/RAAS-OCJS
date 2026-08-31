import java.util.Scanner;

/**
 * 素数判定
 * @author nobu
 * @see <a href="http://judge.u-aizu.ac.jp/onlinejudge/description.jsp?id=ALDS1_1_C&lang=ja">ALDS1_1_C</a>
 */
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		int answer = 0;
		for (int i = 0; i < n; i++) {
			if (isPrime(sc.nextInt())) answer++;
		}

		System.out.println(answer);

		sc.close();
	}

	private static boolean isPrime(int x) {
		if (x == 2) return true;
		if (x < 2 || x % 2 == 0) return false;

		for (int i = 3; i <= Math.sqrt(x); i += 2) {
			if (x % i == 0) return false;
		}
		return true;
	}

}

