import java.util.Scanner;

class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < n; i++)
			a[i] = sc.nextInt();

		int[] b = new int[n];
		for (int i = 0; i < n; i++)
			b[i] = sc.nextInt();

		int[] c = new int[n];
		for (int i = 0; i < n - 1; i++)
			c[i] = sc.nextInt();

		sc.close();
		int s = 0;

		for (int i = 0; i < n; i++)
			s = s + b[a[i] - 1];

		for (int i = 1; i < n; i++) {
			if (a[i] - a[i - 1] == 1)
				s = s + c[a[i - 1] - 1];
		}

		System.out.println(s);

	}
}