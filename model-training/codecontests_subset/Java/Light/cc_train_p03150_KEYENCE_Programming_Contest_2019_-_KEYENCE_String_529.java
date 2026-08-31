import java.util.*;

public class Main {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		String org = "keyence";
		String s = sc.next();
		int idx = 0;
		for (int i = 0; i < s.length(); i++) {
			if (org.charAt(i) != s.charAt(i)) {
				break;
			}
			idx++;
			if (idx == org.length()) {
				System.out.println("YES");
				return;
			}
		}
		for (int i = 0; i < s.length(); i++) {
			if (org.charAt(org.length() - i - 1) != s.charAt(s.length() - i - 1)) {
				break;
			}
			idx++;
			if (idx == org.length()) {
				System.out.println("YES");
				return;
			}
		}
		System.out.println("NO");
	}
}
