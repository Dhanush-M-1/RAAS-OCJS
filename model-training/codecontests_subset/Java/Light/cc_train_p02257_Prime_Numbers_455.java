import java.util.Scanner;

public class Main {

	public static boolean isPrime(int n) {
		boolean out = true;
		int last = (int) (Math.floor(Math.sqrt(n)));
		for (int j = 3; j <= last; j += 2) {
			if (n % j == 0) {
				return false;
			}
		}
		return out;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int aCount = in.nextInt();
		int count = 0;
		int next;

		for (int i = 0; i < aCount; i++) {
			next = in.nextInt();
			if (next == 2) {
				count++;
			} else if (next % 2 != 0) {
				if (isPrime(next)) {
					count++;
				}
			}
		}
		System.out.println(count);
		in.close();
	}
}

