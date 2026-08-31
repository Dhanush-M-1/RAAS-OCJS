import java.util.ArrayList;
import java.util.Scanner;

public class A_5 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<String> a = new ArrayList<String>();
		int ans = 0;
		while (sc.hasNext()) {
			String s = sc.nextLine();
			if (s.charAt(0) == '+' && !a.contains(s)) {
				a.add(s);
			} else if (s.charAt(0) == '-') {
				a.remove(a.indexOf("+" + s.substring(1, s.length())));
			} else {
				for (int i = 0; i < s.length(); i++) {
					if (s.charAt(i) == ':') {
						ans += a.size() * (s.length() - i - 1);
					}
				}
			}
		}
		System.out.println(ans);
	}
}
