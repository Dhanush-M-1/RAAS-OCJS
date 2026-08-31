import java.util.Scanner;

public class BadTriangle {
	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while (t-- > 0) {
			
			int n = in.nextInt(), a[] = new int[n], i;
			for (i = 0; i < n; i++) {
				a[i] = in.nextInt();
			}
			System.out.println(a[0] + a[1] <= a[n - 1] ? "1 2 " + n : -1);
		}
		in.close();
	}
}
