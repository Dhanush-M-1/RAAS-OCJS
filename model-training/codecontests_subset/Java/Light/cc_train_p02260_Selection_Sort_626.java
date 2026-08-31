import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO ?????????????????????????????????????????????
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		sc.nextLine();

		String[] datastr = sc.nextLine().split(" ");
		int[] a = new int[n];
		for (int i=0; i < n; i++) {
			a[i] = Integer.parseInt(datastr[i]);
		}

		int count = 0;
		for (int i=0; i < n; i++) {

			int minj = i;
			for ( int j=i; j < n; j++) {
				if (a[minj] > a[j]) {
					minj = j;
				}
			}

			// swap( a[i], a[minj] )
			// temp <- a[i] <- a[minj] <- temp
			if (minj != i) {
				int temp = a[i];
				a[i] = a[minj];
				a[minj] = temp;
				count++;
			}

		}

		for (int i=0; i < n-1; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println(a[n-1]);
		System.out.println(count);
	}

}