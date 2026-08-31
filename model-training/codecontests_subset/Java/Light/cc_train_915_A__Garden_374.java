import java.util.Scanner;

public class Main {

	static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {

		int n = in.nextInt();
		int k = in.nextInt();
		int ans = k;
		for (int i = 0; i < n; i++) {
			int tmp = in.nextInt();
			if (k % tmp == 0)
				ans = Math.min(ans, k / tmp);
		}
		System.out.println(ans);

	}

}