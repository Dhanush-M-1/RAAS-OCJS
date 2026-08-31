import java.util.Scanner;

public class C {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int numOfTests = scanner.nextInt();

		for (int i=0; i<numOfTests; i++) {
			int k = scanner.nextInt();
			int n = scanner.nextInt();
			int m = scanner.nextInt();

			Integer [] a = new Integer[300];
			Integer [] b = new Integer[300];

			for (int j = 0; j < n; j++) {
				a[j] = scanner.nextInt();
			}

			for (int j = 0; j < m; j++) {
				b[j] = scanner.nextInt();
			}

			Integer [] finalSequence = new Integer[1000];
			boolean notPossible = false;

			int index = 0;
			for(int x = 0, y = 0; x < n || y < m; ) {
				if (x < n && (a[x] == 0 || a[x] <= k)) {
					finalSequence[index] = a[x];
					if (a[x] == 0) {
						k++;
					}
					x++;
				} else if (y < m && (b[y] == 0 || b[y] <= k)) {
					finalSequence[index] = b[y];
					if (b[y] == 0) {
						k++;
					}
					y++;
				} else {
					notPossible = true;
					break;
				}
				
				index++;
			}

			if (!notPossible) {
				for (int j = 0; j < index - 1; j++) {
					System.out.print(finalSequence[j] + " ");
				}

				System.out.println(finalSequence[index - 1]);
			} else {
				System.out.println("-1");
			}
		}
	}
}