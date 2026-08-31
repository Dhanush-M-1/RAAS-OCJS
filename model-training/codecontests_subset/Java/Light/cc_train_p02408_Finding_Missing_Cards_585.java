
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();//最初に太郎が持っているカードの枚数n
		int[][] bucket = new int[4][13];

		for (int i = 0; i < n; i++) {
			String a = sc.next();
			int b = sc.nextInt();
			if ("S".equals(a)) {
				bucket[0][b - 1] = 1;
			} else if ("H".equals(a)) {
				bucket[1][b - 1] = 1;
			} else if ("C".equals(a)) {
				bucket[2][b - 1] = 1;
			} else {
				bucket[3][b - 1] = 1;
			}
		}
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 13; j++) {
				if (bucket[i][j] == 0) {
					if (i == 0) {
						System.out.println("S" + " " + (j + 1));
					}
					if (i == 1) {
						System.out.println("H" + " " + (j + 1));
					}
					if (i == 2) {
						System.out.println("C" + " " + (j + 1));
					}
					if (i == 3) {
						System.out.println("D" + " " + (j + 1));
					}
				}
			}

		}
	}
}

