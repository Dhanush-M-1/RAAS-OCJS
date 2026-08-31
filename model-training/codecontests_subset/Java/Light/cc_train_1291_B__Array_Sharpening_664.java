import java.util.Scanner;

public class B {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while (t-- > 0) {
			int n = in.nextInt();
			int[] a = new int[n + 2];
			for (int i = 1; i <= n; i++) {
				a[i] = in.nextInt();
			}
			int[] l = new int[n + 2];
			l[0] = 0;
			for (int i = 1; i <= n; i++) {
				l[i] = l[i - 1];
				if (a[i] < i - 1) l[i]++;
			}
			int[] r = new int[n + 2];
			r[n + 1] = 0;
			for (int i = n; i >= 1; i--) {
				r[i] = r[i + 1];
				if (a[i] < n - i) r[i]++;
			}
			boolean possible = false;
			for (int i = 1; i <= n; i++) {
				possible |= (l[i] == 0 && r[i] == 0);
			}
			System.out.println(possible ? "Yes" : "No");
		}
	}
}