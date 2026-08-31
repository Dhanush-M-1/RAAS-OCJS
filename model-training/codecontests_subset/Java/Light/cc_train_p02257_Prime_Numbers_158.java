import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = 0;
		int count = 0;
		while (sc.hasNext()) {
			x = sc.nextInt();
			if (isPrime(x))
				count++;
		}
		System.out.println(count);
	}

	public static boolean isPrime(int x) {
		if (x == 2) {
			return true;
		} else if (2 > x || x % 2 == 0) {
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

