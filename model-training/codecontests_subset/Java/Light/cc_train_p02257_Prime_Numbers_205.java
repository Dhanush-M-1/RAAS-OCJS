import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		int count = 0;
		for (int i = 0; i < n; i++) {
			long num = sc.nextLong();
			if(isPrime(num)) count++;
		}

		System.out.println(count);

	}

	private static boolean isPrime(long num) {

		if (num == 2) return true;
		if (num % 2 == 0) return false;

		for (int i = 2; i <= (int)Math.pow(num, 0.5); i++) {
			if(num % i == 0) return false;
		}
		return true;
	}
}