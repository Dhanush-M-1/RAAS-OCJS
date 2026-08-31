import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		int num = 0;
		int count = 0;
		boolean prime;

		for (int i = 0; i < n; i++) {
			num = sc.nextInt();
			if (num == 2) {
				count++;
				continue;
			}

			prime = true;
			for (int j = 2; j < num / (j-1); j++) {
				if (num % j == 0) {
					prime = false;
					break;
				}
			}
			if (prime) {
				count++;
			}
		}

		System.out.println(count);
	}

}
