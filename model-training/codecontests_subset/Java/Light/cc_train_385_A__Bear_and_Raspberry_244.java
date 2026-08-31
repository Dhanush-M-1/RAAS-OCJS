import java.util.*;
public class hello {
	public static void main(String [] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int c = scan.nextInt();
		int ans = 0;
		int temp = scan.nextInt();
		for (int i = 0; i < n - 1; ++i) {
			int temp2 = scan.nextInt();
			ans = Math.max(ans, temp - temp2);
			temp = temp2;
		}
		System.out.println(Math.max(0, ans - c));
	}
}