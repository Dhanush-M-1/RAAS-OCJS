import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		String s = sc.next();
		String key = "keyence";
		String tmp;
		boolean b = false;
		for (int i = 0; i < key.length() + 1; i++) {
			tmp = key.substring(0, i) + ".*" + key.substring(i, key.length());
			if (s.matches(tmp)) {
				b = true;
				break;
			}
		}
		if (b) {
			sb.append("YES");
		} else {
			sb.append("NO");
		}
		System.out.println(sb);
	}
}
