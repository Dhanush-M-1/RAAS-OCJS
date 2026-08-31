import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class P1 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		String st = in.next();
		int pre = 0;

		ArrayList<Integer> a = new ArrayList<Integer>();
		int n = st.length();
		int cnt = 0;
		int d = 0;
		for (int i = 0; i < n; i++) {
			if (st.charAt(i) == '#') {
				d = i;
			}
		}
		int ans = 0;
		int an = 0;
		for (int i = d + 1; i < n; i++) {
			if (st.charAt(i) == '(') {
				an--;
			} else {
				an++;
			}
		}
		if (an < 0) {
			out.println("-1");
			out.close();
			return;
		}
		for (int i = 0; i < n; i++) {
			if (st.charAt(i) == '(') {
				pre++;

			}
			if (st.charAt(i) == ')') {
				pre--;
			}
			if (st.charAt(i) == '#') {
				if (i == d) {
					ans = pre - an;
					pre = an;
					continue;
				}
				pre--;
				cnt++;
			}
			if (pre < 0) {
				out.println("-1");
				out.close();
				return;
			}
		}
		// out.print(ans + " ");
		if (pre > 0 || ans <= 0) {
			out.println("-1");
			out.close();
			return;
		}
		for (int i = 0; i < cnt; i++) {
			out.println("1");
		}
		out.println(ans);

		out.close();
	}
}
