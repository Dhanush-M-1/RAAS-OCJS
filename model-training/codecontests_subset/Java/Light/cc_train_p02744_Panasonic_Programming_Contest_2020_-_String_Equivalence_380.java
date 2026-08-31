import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		dfs("", (char) ('a' - 1), n);
	}

	static void dfs(String s, char mx, int n) {
		if (s.length() == n) {
			System.out.println(s);
			return;
		}

		for (char c = 'a'; c <= mx + 1; c++) {
			String str = s + c;
			dfs(str, (char) Math.max(mx, c), n);
		}
	}
}