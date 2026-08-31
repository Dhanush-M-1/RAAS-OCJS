import java.util.Scanner;

public class Main {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			if (a == 0 && b == 0) break;
			printFrame(a, b);
			System.out.println();
		}
		sc.close();
	}
	static void printFrame (int h, int w) {
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				System.out.print((i + j) % 2 == 0 ? "#" : ".");
			}
			System.out.println();
		}
	}
}