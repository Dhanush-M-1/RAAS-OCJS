
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int x = scanner.nextInt();
		int sum = 0;
		for (int i = 0; i < x; i++) {
			if (isPrime(scanner.nextInt())) {
				sum++;
			}
		}
		System.out.println(sum);
	}

	public static boolean isPrime(int i) {
		if (i == 2)
			return true;
		if (i % 2 == 0)
			return false;
		if (i < 8)
			return true;
		if (i % 3 == 0)
			return false;
		int k = 5;
		while (k * k <= i) {
			if (i % k == 0)
				return false;
			if (i % (k + 2) == 0)
				return false;
			k += 6;
		}
		return true;
	}
}