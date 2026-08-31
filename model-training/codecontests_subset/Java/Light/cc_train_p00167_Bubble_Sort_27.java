
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (true) {
			int n = scanner.nextInt();
			if (n == 0)
				break;
			int[] num = new int[n];
			for (int i = 0; i < n; i++) {
				num[i] = scanner.nextInt();
			}
			int count = 0;
			for (int i = 0; i < n - 1; i++) {
				for (int j = 0; j < n - 1 - i; j++) {
					if (num[j] > num[j + 1]) {
						count++;
						int tmp = num[j];
						num[j] = num[j + 1];
						num[j + 1] = tmp;
					}
				}
			}
			System.out.println(count);
		}
	}
}