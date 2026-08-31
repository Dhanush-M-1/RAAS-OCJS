
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int count = 0;
		for (int i = 0; i < n; i++) {
			if (isPrime(sc.nextInt())) {
				count++;
			}
		}
		System.out.println(count);
	}

	public static boolean isPrime(int n) {
		int max = (int) Math.sqrt(n)+1;
		for (int i = 2; i < max; i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}
}

