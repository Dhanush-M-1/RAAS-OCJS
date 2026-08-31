import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
		}
		Main main = new Main();
		int ans = main.selectionSort(a, n);
		for (int i = 0; i < n; i++) {
			if (i != n - 1) {
				System.out.print(a[i] + " ");
			} else {
				System.out.println(a[i]);
			}
		}
		System.out.println(ans);

	}

	// 選択ソート
	private int selectionSort(int[] a, int n) {
		int cnt = 0;// 入れ替えた回数

		for (int i = 0; i < n - 1; i++) {
			int minj = i;// 最小の要素を持つ位置

			for (int j = i; j < n; j++) {
				if (a[j] < a[minj]) {
					minj = j;
				}
			}

			if (i != minj) {
				int tmp = a[minj];
				a[minj] = a[i];
				a[i] = tmp;
				cnt++;
			}

		}
		return cnt;
	}

}

