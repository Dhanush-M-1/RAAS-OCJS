import java.io.IOException;
import java.util.Scanner;

public class Main {

	static Scanner in = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		int c = in.nextInt();
		int v0 = in.nextInt();
		int v1 = in.nextInt();
		int a = in.nextInt();
		int l = in.nextInt();

		int ans = 0;

		while (true) {
			c -= v0;
			v0 += a;
			v0 = Math.min(v0, v1);
			ans++;
			if (c <= 0)
				break;

			c += l;
		}
		System.out.println(ans);

	}
}