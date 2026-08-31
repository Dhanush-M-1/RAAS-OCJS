
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int ans = 0;
		for (int i = 0; i < N; i++) {
			ans += in.nextInt() - 1;
		}
		System.out.println(ans);
		in.close();
	}
}