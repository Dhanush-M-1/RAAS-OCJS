import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int n = scanner.nextInt();
		int[] as = new int[n];
		int[] bs = new int[n];
		int[] cs = new int[n - 1];
		for (int i = 0; i < n; i++) {
			as[i] = scanner.nextInt();
		}
		for (int i = 0; i < n; i++) {
			bs[i] = scanner.nextInt();
		}
		for (int i = 0; i < n - 1; i++) {
			cs[i] = scanner.nextInt();
		}

		int sum = 0;
		int preA = 0;
		boolean flag = false;
		for (int a : as) {
			sum += bs[a - 1];
			if (flag && preA + 1 == a) {
				sum += cs[preA - 1];
			} else {
				flag = true;
			}
			preA = a;
		}
		System.out.println(sum);

	}
}
