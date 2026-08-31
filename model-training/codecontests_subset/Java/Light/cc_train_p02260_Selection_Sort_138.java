import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] array = new int[N];
		for(int i = 0; i < N; i++) {
			array[i] = sc.nextInt();
		}
		int ans = selectionSort(array);
		showArray(array);
		System.out.println(ans);
		sc.close();
	}

	// 選択ソート（昇順）
	public static int selectionSort(int[] a) {
		int cnt = 0;  // 要素の交換が行われた回数
		for(int i = 0; i < a.length - 1; i++) {
			int minj = i;
			for(int j = i + 1; j < a.length; j++) {
				if(a[j] < a[minj]) {
					minj = j;
				}
			}
			if(i != minj) {
				int tmp = a[minj];
				a[minj] = a[i];
				a[i] = tmp;
				cnt++;
			}
		}
		return cnt;
	}

	public static void showArray(int[] a) {
		System.out.print(a[0]);
		for(int i = 1; i < a.length; i++) {
			System.out.print(" " + a[i]);
		}
		System.out.println();
	}
}
