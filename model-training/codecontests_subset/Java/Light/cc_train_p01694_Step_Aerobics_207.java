
import java.util.Scanner;

public class Main{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while (true) {
			int n = sc.nextInt();
			if (n == 0) {
				break;
			}

			char[] upOrDown = new char[n];
			for (int i = 0; i < n; i++) {
				upOrDown[i] = sc.next().charAt(1);
			}

			int count = 0;
			for (int i = 0; i < n / 2; i++) {
				if (upOrDown[2 * i] == upOrDown[2 * i + 1]) {
					count++;
				}
			}

			System.out.println(count);
		}
		sc.close();
	}
}