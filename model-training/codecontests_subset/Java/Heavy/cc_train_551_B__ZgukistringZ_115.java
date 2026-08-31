import java.util.Scanner;

public class B {
	public static void main(String[] args) {
		new Task().solve();
	}

	static class Task {
		Scanner in = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		StringBuilder sc = new StringBuilder();
		int[] or = new int[26];
		int[] a = new int[26];
		int[] b = new int[26];
		int[] c = new int[26];
		int res = 0;
		int len, gen = 0;
		int tmp;

		public void solve() {
			for (char ch : in.nextLine().toCharArray()) {
				a[ch - 'a']++;
				or[ch - 'a']++;
			}
			for (char ch : in.nextLine().toCharArray()) {
				b[ch - 'a']++;
				sb.append(ch);
			}
			for (char ch : in.nextLine().toCharArray()) {
				c[ch - 'a']++;
				sc.append(ch);
			}
			int maxB = calc(b);
			int maxC = calc(c);

			int[] gr = (maxB < maxC ? c : b);
			int[] le = (gr == b ? c : b);

			res = Math.max(maxB, maxC);
			len = 0;
			gen = res;

			for (int i = 1; i <= Math.min(maxB, maxC); i++) {
				remove(le);
				if (i + (tmp = calc(gr)) > res) {
					len = i;
					gen = tmp;
					res = i + tmp;
				}
			}
			a = or;
			
			for (int i = 0; i < len; i++) {
				System.out.print(le == b ? sb.toString() : sc.toString());
				remove(le);
			}
			for (int i = 0; i < gen; i++) {
				System.out.print(gr == b ? sb.toString() : sc.toString());
				remove(gr);
			}
			for (int j = 0; j < 26; j++) {
				for (int k = 0; k < or[j]; k++) {
					System.out.print((char) ('a' + j));
				}
			}

		}

		private void remove(int[] x) {
			for (int i = 0; i < 26; i++) {
				a[i] -= x[i];
			}
		}

		private int calc(int[] x) {
			int max = Integer.MAX_VALUE;
			for (int i = 0; i < 26; i++) {
				if (x[i] == 0)
					continue;
				max = Math.min(max, a[i] / x[i]);
			}
			return max;
		}

	}
}
