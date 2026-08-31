
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (true) {
			int a = scanner.nextInt();
			int b = scanner.nextInt();
			if (a == 0 & b == 0)
				break;
			for (int i = 0; i < a; i++) {
				for (int j = 0; j < b; j++) {
					if (i % 2 == 0 && j % 2 == 0 || i % 2 == 1 && j % 2 == 1)
						System.out.print("#");
					else
						System.out.print(".");
				}
				System.out.println();
			}
			System.out.println();
		}
	}
}