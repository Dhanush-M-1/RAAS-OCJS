
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		//		new Main().solveA();
		//		new Main().solveB();
		new Main().solveC();
		// new Main().solveD();
	}

	private void solveA() {
		Scanner scanner = null;
		int numN = 0;
		int numA = 0;
		int numB = 0;

		try {
			scanner = new Scanner(System.in);
			numN = scanner.nextInt();
			numA = scanner.nextInt();
			numB = scanner.nextInt();

			System.out.println(Math.min(numA * numN, numB));

		} finally {
			if (scanner != null) {
				scanner.close();
			}
		}
	}

	private int addAllDigit(int num) {
		if (num < 10) {
			return num;
		}
		return addAllDigit(num / 10) + num % 10;
	}

	private void solveB() {
		Scanner scanner = null;
		int numN = 0;

		try {
			scanner = new Scanner(System.in);
			numN = scanner.nextInt();

			int res = addAllDigit(numN);

			if (numN % res == 0) {
				System.out.println("Yes");
			} else {
				System.out.println("No");

			}

		} finally {
			if (scanner != null) {
				scanner.close();
			}
		}
	}

	private void solveC() {
		Scanner scanner = null;
		int numN = 0;

		try {
			scanner = new Scanner(System.in);
			numN = scanner.nextInt();

			int[][] shop = new int[numN][10];
			int[][] rieki = new int[numN][11];

			for (int j = 0; j < numN; j++) {
				for (int k = 0; k < 10; k++) {
					shop[j][k] = scanner.nextInt();
				}
			}

			for (int j = 0; j < numN; j++) {
				for (int k = 0; k < 11; k++) {
					rieki[j][k] = scanner.nextInt();
				}
			}
			int res = Integer.MIN_VALUE;
			//0000000000=0、1111111111=1023
			for (int i = 1; i < 1024; i++) {
				int wkRes = 0;
				int[] myShop = new int[10];
				int wkBit = i;
				//0000000000から、1111111111までの配列を作成。2の剰余を入れていけば2進数に変換できる。
				for (int j = 0; j < 10; j++) {
					myShop[j] = wkBit % 2;
					wkBit /= 2;
				}
				for (int j = 0; j < shop.length; j++) {
					int cnt = 0;
					for (int k = 0; k < myShop.length; k++) {
						if (myShop[k] == shop[j][k] && myShop[k] == 1) {
							cnt++;
						}
					}
					wkRes += rieki[j][cnt];
				}
				res = Math.max(res, wkRes);
			}

			System.out.println(res);

		} finally {
			if (scanner != null) {
				scanner.close();
			}
		}
	}

	private void solveD() {
		Scanner scanner = null;
		int lineAB = 0;
		int lineBC = 0;
		int lineCA = 0;

		try {
			scanner = new Scanner(System.in);
			lineAB = scanner.nextInt();

			System.out.println("");

		} finally {
			if (scanner != null) {
				scanner.close();
			}
		}
	}
}