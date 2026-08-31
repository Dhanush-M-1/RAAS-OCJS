import java.util.Scanner;

/**
 * ?´???°????????°?????????????????????
 * @author moritahokuto
 *
 */
public class Main {

	public static void main(String[] args) {
		int count = 0;
		Scanner scanner = new Scanner(System.in);
		int size = scanner.nextInt();
		for (int i = 0; i < size; i++) {
			if (isPrime(scanner.nextInt())) {
				count++;
			}
		}
		System.out.println(count);
	}
	static boolean isPrime(int num) {
		if (num == 2) {
			return true;
		}
		if (num < 2 || num % 2 == 0) {
			return false;
		}
		int i = 3;
		while (i <= Math.sqrt(num)) {
			if (num % i == 0) {
				return false;
			}
			i = i + 2;
		}
		return true;
	}
}