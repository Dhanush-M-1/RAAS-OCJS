public class Main {
	public static void main(String[] args) {
		try (java.util.Scanner sc = new java.util.Scanner(System.in)) {
			while (true) {
				int H = sc.nextInt();
				int W = sc.nextInt();
				if (H == 0 && W == 0) {
					break;
				}

				for (int h = 0; h < H; h++) {
					for (int w = 0; w < W; w++) {
						if ((h + w) %2 == 0) {
							System.out.print("#");
						} else {
							System.out.print(".");
						}
					}
					System.out.println();
				}
				System.out.println();
			}
		}
	}
}
