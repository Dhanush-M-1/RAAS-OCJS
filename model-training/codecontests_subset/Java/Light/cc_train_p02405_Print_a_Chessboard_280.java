import java.util.Scanner;

public class Main{
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		while(true) {
			int H = scan.nextInt();
			int W = scan.nextInt();
			int i, j;
			if (H == 0 && W == 0) break;
			for (i = 1; i <= H; i ++) {
				if (i % 2 == 1) for (j = 1; j <= W; j ++) {
					if (j % 2 == 1) System.out.print("#");
					else System.out.print(".");
				}
				if (i % 2 == 0) for (j = 1; j <= W; j ++) {
					if (j % 2 == 1) System.out.print(".");
					else System.out.print("#");
				}
				System.out.print("\n");
			}
			System.out.print("\n");
		}

	}
}