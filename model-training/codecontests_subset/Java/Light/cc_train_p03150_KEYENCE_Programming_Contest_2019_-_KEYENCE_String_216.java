import java.util.*;
import java.lang.*;


public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		int len = s.length() - 7;
		boolean pos = false;
		for (int i = 0; i <= 7; i++) {
			String ans = s.substring(0, i) + s.substring(i + len);
			if (ans.equals("keyence")) {
				pos = true;
				break;
			}
		}
		if (pos) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
	}
}