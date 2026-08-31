import java.util.Scanner;

class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int H, W;
		boolean sharp = false;

		while (true) {
			H = scanner.nextInt();
			W = scanner.nextInt();

			if (H == 0 && W == 0)
				break;

			for (int i = 0; i < H; i++) {
				if (i % 2 == 0)
					sharp = false;
				else
					sharp = true;

				for (int i2 = 0; i2 < W; i2++) {
					System.out.print((sharp = !sharp) ? "#" : ".");
				}

				System.out.println();
			}

			System.out.println();
		}
	}
}