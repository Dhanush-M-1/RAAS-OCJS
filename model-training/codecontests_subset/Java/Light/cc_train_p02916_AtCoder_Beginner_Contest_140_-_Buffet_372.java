import java.util.Scanner;

public class Main {

	static int n;
	static int a[] = new int[20];
	static int b[] = new int[20];
	static int c[] = new int[20];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
		}
		for (int i = 0; i < n; i++) {
			b[i] = sc.nextInt();
		}
		for (int i = 0; i < n - 1; i++) {
			c[i] = sc.nextInt();
		}

		int manzokudo = 0;
		manzokudo += b[a[0] - 1];
		for (int i = 1; i < n; i++) {
			manzokudo += b[a[i] - 1];
			if (a[i] == a[i - 1] + 1)
				manzokudo += c[a[i - 1] - 1];
		}
		System.out.println(manzokudo);

	}

}
