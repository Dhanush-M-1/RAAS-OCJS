import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int a = s.nextInt();
		int b = s.nextInt();
		int c = s.nextInt();
		String ans = "";

		if (a + b == c) {
			ans = "Yes";
		} else if (b + c == a) {
			ans = "Yes";
		} else if (c + a == b) {
			ans = "Yes";
		} else {
			ans = "No";
		}
		System.out.println(ans);
	}

}