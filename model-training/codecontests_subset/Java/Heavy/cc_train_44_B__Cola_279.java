import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class B {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);

		int n = in.nextInt();
		int n05 = in.nextInt();
		int n10 = in.nextInt();
		int n20 = in.nextInt();

		int ans = 0;
		for (int x = 0; x <= n05; x += 2) {
			for (int y = 0; y <= n10; y++) {
				int ost = n - (int) (x * 0.5 + y);
				if ((ost > 0) && (ost % 2) == 0 && (ost / 2) <= n20) {
					ans++;
				}
				
				if (ost == 0) {
					ans++;
				}
			}
		}
		out.print(ans);

		out.close();
		in.close();
	}
}
