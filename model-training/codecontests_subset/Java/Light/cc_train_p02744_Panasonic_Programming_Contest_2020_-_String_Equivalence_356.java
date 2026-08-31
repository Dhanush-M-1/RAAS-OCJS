import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		dfs("", (char) ('a'-1), num);
	}

	private static void dfs(String s, char max, int num) {
		if (s.length()==num) {
			System.out.println(s);
			return;
		}

		for (char i = 'a'; i <= max + 1; i++) {
			String result = s + i;
			char t = max > i ? max : i;
			dfs(result, t, num);
		}
	}

}
