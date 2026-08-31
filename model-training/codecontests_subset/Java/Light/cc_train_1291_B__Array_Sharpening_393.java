import java.util.Scanner;

public class CBR79B {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		int t = s.nextInt();
		while (t-- > 0) {
			int n = s.nextInt();

			int[] a = new int[n+1];

			for (int i = 1; i <=n; i++) {
				a[i] = s.nextInt();
			}
			int l = 0;
			int r = n + 1;

			for (int i = 1; i <=n; i++) {
				if (a[i] >=i - 1) {
					l = i;
				} else
					break;
			}

			for (int i = n; i >= 1; i--) {
				if (a[i] >=n - i) {
					r=i;
				} else
					break;
			}
			if (l >= r) {
				System.out.println("Yes");
			} else {
				System.out.println("No");
			}

		}
	}

}
