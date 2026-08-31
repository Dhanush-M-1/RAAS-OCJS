import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int num[] = new int[n];

		for (int i = 0; i < n; i++) {
			num[i] = scan.nextInt();
		}

		int count = 0;

		for (int i = 0; i < n; i++) {
			int mini = i;
			for (int j = i; j < n; j++) {
				if (num[j] < num[mini]) {
					mini = j;
				}
			}

			if (mini != i) {
				int tmp = num[i];
				num[i] = num[mini];
				num[mini] = tmp;
				count++;
			}
		}

		for (int i = 0; i < n; i++) {
			System.out.print(num[i]);
			if (i != n - 1)
				System.out.print(" ");
		}

		System.out.println();
		System.out.println(count);
		scan.close();
	}

}