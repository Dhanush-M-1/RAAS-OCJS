import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		int n = scan.nextInt();
		long ans = 0;
		for(int i = 0; i < n; i++) {
			ans += scan.nextInt() - 1;
		}
		System.out.println(ans);
	}
}