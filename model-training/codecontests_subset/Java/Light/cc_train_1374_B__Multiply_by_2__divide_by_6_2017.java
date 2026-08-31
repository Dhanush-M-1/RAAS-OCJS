import java.util.Scanner;

public class div6 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int t = scanner.nextInt();
		for (int i = 0; i < t; i++) {
			int n = scanner.nextInt();
			int twos = 0;
			int threes = 0;
			while (n % 2 == 0) {
				n /= 2;
				twos++;
			}
			while (n % 3 == 0) {
				n /= 3;
				threes++;
			}
			if (n == 1 && twos <= threes) {
				System.out.println(2 * threes - twos);
			} else {
				System.out.println(-1);
			}
		}
	}
}
