

import java.util.Scanner;

public class Main {
	private static int selectionSort(int a[]) {
		int cnt = 0;
		for (int i = 0; i < a.length - 1; ++i) {
			int min = i;
			for (int j = i + 1; j < a.length; ++j) {
				if (a[j] < a[min])
					min = j;
			}
			if (min != i) {
				int t = a[min];
				a[min] = a[i];
				a[i] = t;
				cnt++;
			}
		}
		return cnt;
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < n; ++i)
			a[i] = scan.nextInt();
		int cnt = selectionSort(a);
		for (int t = 0; t < a.length; ++t) {
			System.out.print(a[t]);
			if (t != a.length - 1) 
				System.out.print(" ");
		}
		System.out.println();
		System.out.println(cnt);
	}
//	public static void main(int a) {
//		
//	}
}

