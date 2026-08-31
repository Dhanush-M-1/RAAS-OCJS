import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (true) {
			int w = scanner.nextInt(), h = scanner.nextInt();
			if (w == 0 && h == 0)
				break;
			for (int i = 0; i < w; ++i) {
				for (int j = 0; j < h; ++j) {
					System.out.print((i + j) % 2 == 0 ? '#' : '.');
				}
				System.out.print('\n');
			}
			System.out.println();
		}
	}
}

