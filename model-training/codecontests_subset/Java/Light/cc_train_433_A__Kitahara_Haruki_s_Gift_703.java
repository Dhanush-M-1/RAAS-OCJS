import java.util.Scanner;

public class KitaharaHaruki {
	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int n = in.nextInt(), i, c1 = 0, c2 = 0;

		for (i = 0; i < n; i++) {
			if (in.nextInt() == 100) {
				c1++;
			} else {
				c2++;
			}
		}
		in.close();
		System.out.println(c1 % 2 == 0 && c1 > 0 || c1 == 0 && c2 % 2 == 0 ? "YES" : "NO");
	}
}
