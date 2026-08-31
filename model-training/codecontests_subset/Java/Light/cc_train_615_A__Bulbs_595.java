import java.util.Scanner;

public class Bulbs {
	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int n = in.nextInt(), m = in.nextInt(), i;
		boolean[] a = new boolean[m];
		String o = "YES";

		while (n-- > 0) {
			int x = in.nextInt();
			while (x-- > 0) {
				a[in.nextInt() - 1] = true;
			}
		}
		in.close();
		for (i = 0; i < m; i++) {
			if (a[i] == false) {
				o = "NO";
			}
		}
		System.out.println(o);
	}
}
