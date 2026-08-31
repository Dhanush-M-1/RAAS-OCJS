import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			if (a == 0 && b == 0)
				break;
			for (int i = 0; i < a; i++) {
				for (int c = 0; c < b; c++) {
					if ((i + c) % 2 == 0) {
						System.out.printf("#");
					} else {
						System.out.printf(".");
					}
				}
				System.out.println();
			}
			System.out.println();
		}
	}
}
