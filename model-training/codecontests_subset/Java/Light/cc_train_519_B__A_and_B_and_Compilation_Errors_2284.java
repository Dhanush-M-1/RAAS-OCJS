import java.util.Scanner;

public class ABCompilationErrors {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();

		int sum = 0;
		for (int i = 0; i < n; i++) {
			sum += scanner.nextInt();
		}

		int sum2 = 0;
		for (int i = 0; i < n - 1; i++) {
			sum2 += scanner.nextInt();
		}

		System.out.println(sum - sum2);

		int sum3 = 0;
		for (int i = 0; i < n - 2; i++) {
			sum3 += scanner.nextInt();
		}
		System.out.println(sum2 - sum3);

	}
}
