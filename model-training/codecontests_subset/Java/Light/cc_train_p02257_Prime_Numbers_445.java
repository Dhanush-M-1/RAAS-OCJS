import java.util.Scanner;

public class Main {
	public static boolean isPrime(int x) {
		if(x <= 1) {
			return false;
		} else {
			for (int i = 2; i <= Math.sqrt(x); i++) {
				if (x % i == 0) {
					return false;
				}
			}
			return true;
		}
	}

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
}
