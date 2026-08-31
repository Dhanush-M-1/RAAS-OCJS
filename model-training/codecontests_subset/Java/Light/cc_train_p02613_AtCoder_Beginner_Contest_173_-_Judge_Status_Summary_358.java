import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] s = {"AC", "WA", "TLE", "RE"};
		int[] ans = new int[4];
		for (int N = sc.nextInt(); N > 0; N--) {
			String t = sc.next();
			for (int i = 0; i < 4; i++) {
				if (t.charAt(0) == s[i].charAt(0))
					ans[i]++;
			}
		}
		for (int i = 0; i < 4; i++) {
			System.out.println(s[i] + " x " + ans[i]);
		}
	}
}
