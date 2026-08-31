import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int cnt = 0;
		for (int i = 0; i < n; i++) {
			int num = sc.nextInt();
			if (isPrime(num)) {
				cnt++;
			}
		}

		System.out.println(cnt);
	}

	private static boolean isPrime(int x) {
		if (x == 2) {
			return true;
		}

		if (x < 2 || x % 2 == 0) {
			return false;
		}

		int i = 3;

		while (i <= Math.sqrt(x)) {
			if (x % i == 0) {
				return false;
			}
			i = i + 2;
		}
		return true;
	}
}