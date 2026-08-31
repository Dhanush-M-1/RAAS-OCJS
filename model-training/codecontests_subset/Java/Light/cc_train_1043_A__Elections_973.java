import java.util.Scanner;

public class Elections {
	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int n = in.nextInt(), a[] = new int[n], k = 0, s = 0, c = 0, i;

		for (i = 0; i < n; i++) {
			a[i] = in.nextInt();
			k = Math.max(k, a[i]);
			s += a[i];
		}
		for (i = 0; i < n; i++) {
			c += k - a[i];
		}
		while (c <= s) {
			c += n;
			k++;
		}
		System.out.println(k);
		in.close();
	}
}
