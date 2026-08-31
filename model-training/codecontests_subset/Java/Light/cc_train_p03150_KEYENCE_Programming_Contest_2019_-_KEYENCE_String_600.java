import java.util.*;

class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next(), t = "keyence";
		if (s.length() >= t.length()) {
			int d = s.length() - t.length();
			for (int i = 0; i + d <= s.length(); i++) {
				if (t.equals(s.substring(0, i) + s.substring(i + d))) {
					System.out.println("YES");
					return;
				}
			}
		}
		System.out.println("NO");
	}
}