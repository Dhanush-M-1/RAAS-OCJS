
import java.util.Scanner;

public class B16 {
	static int max = 11;

	public static void main(String[] args) {

		Scanner nik = new Scanner(System.in);
		int t = nik.nextInt();

		for (int i = 0; i < t; i++) {

		}
		StringBuilder st = new StringBuilder();
		while (t-- > 0) {
			int n = nik.nextInt();
			int m = nik.nextInt();
			String s = nik.next();

			int a[] = new int[s.length()];
			for (int i = 0; i < m; i++) {
				int val = nik.nextInt();
				a[val] += 1;
			}
			int str = a[s.length() - 1];
			a[s.length() - 1] = 1;
			for (int i = s.length() - 2; i >= 0; i--) {
				int ss = a[i];
				a[i] = str + a[i + 1];
				str = ss;
			}

			int res[] = new int[26];
			for (int i = 0; i < a.length; i++) {
				char c = s.charAt(i);
				res[c - 'a'] += a[i];
			}
			for (int i = 0; i < 26; i++) {
				st.append(res[i] + " ");
			}
			st.append("\n");
		}
		System.out.println(st);
	}
}
