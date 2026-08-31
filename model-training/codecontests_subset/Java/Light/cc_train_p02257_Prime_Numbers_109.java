import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int count = 0;
		for (int i = 0; i < n; i++) {
			if (isPrime(scanner.nextInt())) {
				count++;
			}
		}
		System.out.println(count);
	}

	static boolean isPrime(int x) {
		if (x == 2) {
			return true;
		}
		if ((x < 2) || (x % 2 == 0)) {
			return false;
		}
		for (int i = 3; i <= Math.sqrt(x); i+=2) {
			if (x % i == 0) {
				return false;
			}
		}
		return true;
	}

}

