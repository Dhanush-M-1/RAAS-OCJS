import java.util.Scanner;

public class Main {

	public static void selection_sort(int[] a) {
		int num_swaps = 0;
		for (int i = 0; i < a.length; i++) {
			int mini = i;
			for (int j = i; j < a.length; j++) {
				if (a[j] < a[mini])
					mini = j;
			}
			// swap
			int tmp = a[i];
			a[i] = a[mini];
			a[mini] = tmp;
			if (i != mini)
				num_swaps++;
		}
		display(a);
		System.out.println(num_swaps);
	}

	public static void display(int[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i]);
			if (i != a.length - 1)
				System.out.print(" ");
			else
				System.out.print("\n");
		}
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = s.nextInt();
		}
		selection_sort(a);
	}
}
