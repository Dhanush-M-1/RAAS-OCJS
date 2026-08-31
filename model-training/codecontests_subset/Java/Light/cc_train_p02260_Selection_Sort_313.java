import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] a = new int[n];
		for(int i = 0 ; i < n ; i++) {
			a[i] = sc.nextInt();
		}
		selectionSort(a, n);
	}

	static void selectionSort(int[] a, int n) {
		int cnt = 0;
		for(int i = 0 ; i < n ; i++) {
			int minj = i;
			for(int j = i ; j < n ; j++) {
				if(a[minj] > a[j]) {
					minj = j;
				}
			}
			if(a[minj] < a[i]) {
				int v = a[i];
				a[i] = a[minj];
				a[minj] = v;
				cnt++;
			}
		}
		for(int i = 0 ; i < n ; i++) {
			if(i != n - 1) {
				System.out.print(a[i] + " ");
			} else {
				System.out.println(a[i]);
			}
		}
		System.out.println(cnt);
	}

}