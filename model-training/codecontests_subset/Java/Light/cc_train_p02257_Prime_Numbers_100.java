import java.util.Scanner;

public class Main {

	public static boolean is_prime(int n) {
		int square_root = (int)Math.sqrt(n);
		for (int i = square_root; i > 1; i--) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int num_of_primes = 0;
		for (int i = 0; i < n; i++) {
			int m = s.nextInt();
			if (is_prime(m))
				num_of_primes++;
		}
		System.out.println(num_of_primes);
	}
}

