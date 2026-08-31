import java.util.Scanner;

public class BestGift {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			int m = scanner.nextInt();

			int[] frequencies = new int[m];
			for (int i = 0; i < n; i++) {
				int book = scanner.nextInt();
				frequencies[book - 1]++;
			}

			long total = (long) n * (n - 1) / 2;
			for (int freq : frequencies) {
				total -= (long) freq * (freq - 1) / 2;
			}

			System.out.println(total);
		}
	}
}
