import java.util.Scanner;

public class B {
	public static void main(String[] args) {
		Scanner jin = new Scanner(System.in);
		int n = jin.nextInt();
		int res = 0;
		for (int i = 0; i < n; ++i) {
			int curr = jin.nextInt();
			res = Math.max(res, Math.min(curr - 1, 1000000 - curr));
		}
		System.out.println(res);

	}
}
