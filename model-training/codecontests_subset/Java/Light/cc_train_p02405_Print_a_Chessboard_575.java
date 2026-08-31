import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = null;
		while (sc.hasNext()) {
			int H = sc.nextInt();
			int W = sc.nextInt();
			if (H == 0 && W == 0) {
				sc.close();
				break;
			}
			for (int i=0; i < H; i++) {
				for (int j=0; j < W; j++) {
					s = i % 2 == 0 ? j % 2 == 0 ? "#" : "." :  j % 2 == 0 ? "." : "#";
					System.out.print(s);
					if (j == W-1)
						System.out.println();
				}
				if (i == H-1)
					System.out.println();
			}
		}
	}
}