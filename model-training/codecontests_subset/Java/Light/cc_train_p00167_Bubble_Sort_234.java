
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
			boolean flag = true;
			while (flag) {
				flag = false;
				for (int i = 0; i < n - 1; i++) {
					if (num[i] > num[i + 1]) {
						count++;
						flag = true;
						int tmp = num[i];
						num[i] = num[i + 1];
						num[i + 1] = tmp;
					}
				}

			}
			System.out.println(count);
		}
	}
}