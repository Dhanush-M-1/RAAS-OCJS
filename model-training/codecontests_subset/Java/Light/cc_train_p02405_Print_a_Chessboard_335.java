import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int H;
		int W;

		while (true) {
			H = sc.nextInt();
			W = sc.nextInt();

			if (H == 0 && W == 0)
				break;

			printChessboard(H, W);

		}

	}

	static void printChessboard(int H, int W) {
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				if((i+j)%2==0)
				System.out.print("#");
				
				else
					System.out.print(".");

				if (j == (W - 1))
					System.out.println("");
			}
		}
		System.out.println();
	}

}