import java.io.*;
import java.util.*;

class Main {

	private static int n;
	private static List<String> a = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		final Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		dfs(0, new StringBuilder(), new HashMap());
		StringBuilder sb = new StringBuilder();
		for (String b : a) {
			sb.append(b).append("\n");
		}
		System.out.print(sb);
	}

	private static void dfs(int x, StringBuilder sb, Map<Character, Integer> s) {
		if (sb.length() == n) {
			//if (ok(sb.toString())) {
			a.add(sb.toString());
			//}
			return;
		}

		for (int i = 0; i <= x && i <= s.size(); i++) {
			char c = (char) ('a' + i);
			s.put(c, s.getOrDefault(c, 0) + 1);
			sb.append(c);
			dfs(x + 1, sb, s);
			sb.deleteCharAt(sb.length() - 1);
			if (s.getOrDefault(c, 1) == 1) {
				s.remove(c);
			} else {
				s.put(c, s.get(c) - 1);
			}
		}
	}

	private static boolean ok(String a) {
		if (a.charAt(a.length() - 1) == (char) ('a' + n - 1)) {
			for (int i = 0; i < a.length(); i++) {
				if (a.charAt(i) != (char) ('a' + i)) return false;
			}
		}
		return true;
	}
}
