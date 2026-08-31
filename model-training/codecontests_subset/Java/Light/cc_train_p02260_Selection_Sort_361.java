
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] a = new int[n];
		int count = 0;
		for (int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
		}
		for (int i = 0; i < n; i++) {
			int min = Integer.MAX_VALUE;
			int minj = 0;
			for (int j = i+1; j < n; j++) {
				if (min > a[j]) {
					min = a[j];
					minj = j;
				}
			}
			if (a[i] > min) {
				int tmp = a[i];
				a[i] = min;
				a[minj] = tmp;
				count++;
			}
		}
		print(a);
		System.out.println(count);
	}
	static void print(int[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i]);
			if (i != a.length-1) {
				System.out.print(" ");
			}
		}
		System.out.print("\n");
	}

}

