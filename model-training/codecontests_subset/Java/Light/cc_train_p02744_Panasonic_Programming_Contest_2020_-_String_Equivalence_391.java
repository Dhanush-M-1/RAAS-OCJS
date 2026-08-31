import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();

		List<String> ans = new ArrayList<>();
		ans.add("a");
		for (int i = 1; i < n; i++) {
			List<String> work = new ArrayList<>();
			for (String s : ans) {
				char ch = 'a';
				for (int j = 0; j < s.length(); j++) {
					if (s.charAt(j) > ch) ch = s.charAt(j);
				}
				ch++;
				for (char c = 'a'; c <= ch; c++) {
					work.add(s + c);
				}
			}
			ans = work;
		}
		Collections.sort(ans);
		PrintWriter pw = new PrintWriter(System.out);
		for ( String s : ans) {
			pw.println(s);
		}
		pw.flush();
	}
}
