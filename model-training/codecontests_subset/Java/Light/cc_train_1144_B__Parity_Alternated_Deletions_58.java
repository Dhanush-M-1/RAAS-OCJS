import java.util.Arrays;
import java.util.Scanner;

public class ParityAltDel {
	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int n = in.nextInt(), i, a[] = new int[n], e = 0, o = 0, t = 0, m = 0, x = 0;
		for (i = 0; i < n; i++) {

			a[i] = in.nextInt();
			if (a[i] % 2 == 0) {
				e++;
			} else {
				o++;
			}
		}
		in.close();
		Arrays.sort(a);

		if (e < o) {
			t = 1;
			m = o - e - 1;
		} else {
			m = e - o - 1;
		}
		for (i = 0; i < n && m > 0; i++)
			if (a[i] % 2 == t) {
				x += a[i];
				m--;
			}
		System.out.println(x);
	}
}
