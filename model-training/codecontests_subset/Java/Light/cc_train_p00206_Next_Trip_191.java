
import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		new Main().run();
	}

	private void run() throws IOException {
		Scanner scanner = new Scanner(System.in);
		while (true) {
			int n = scanner.nextInt();
			if (n == 0)
				break;
			int sum = 0;
			int index = -1;

			for (int i = 0; i < 12; i++) {
				int a = scanner.nextInt();
				int b = scanner.nextInt();
				sum += a - b;
				if (sum >= n) {
					index = i + 1;
					sum = Integer.MIN_VALUE;
				}
			}
			System.out.println(index == -1 ? "NA" : index);
		}
	}
}