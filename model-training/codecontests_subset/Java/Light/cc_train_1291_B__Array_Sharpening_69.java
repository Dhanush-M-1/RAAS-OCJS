
import java.util.Scanner;

public class B21 {
	public static boolean sol(int[] a) {
		if (a.length == 1)
			return true;
		if (a.length == 2) {
			if (a[0] > 0 || a[1] > 0)
				return true;
		}
		int lp = -1;
		for (int i = 0; i < a.length; i++) {
			if (lp < a[i]) {
				lp++;
			} else
				break;
		}
		int rp = -1;
		for (int i = a.length - 1; i >= 0; i--) {
			if (rp < a[i]) {
				rp++;
			} else
				break;
			if (lp >= a.length - rp - 1) {
				return true;
			}
		}
		return false;

	}

	public static void main(String[] args) {
		Scanner nik = new Scanner(System.in);

		int t = nik.nextInt();

		while (t-- > 0) {
			int n = nik.nextInt();
			int a[] = new int[n];
			for (int i = 0; i < n; i++) {
				a[i] = nik.nextInt();
			}
			boolean res = sol(a);
			if (res)
				System.out.println("Yes");
			else {
				System.out.println("No");
			}
		}
	}
}