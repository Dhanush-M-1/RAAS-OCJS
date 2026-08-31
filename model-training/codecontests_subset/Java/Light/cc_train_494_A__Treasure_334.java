import java.util.Scanner;

public class C {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		char[] s = in.nextLine().toCharArray();
		int count = 0;
		int length = s.length;
		int last = -1;
		int f = 0;
		int h = 0;
		StringBuilder str = new StringBuilder();
		for (int i = 0; i < length; ++i) {
			if (s[i] == '(') {
				f++;
				continue;
			}
			if (s[i] == ')') {
				++h;
				continue;
			}
			if (last == -1) {
				last = i;
			} else {
				s[last] = ')';
				h++;
				last = i;
				str.append("1\n");
			}
		}
		int t = f - h;
		if (t <= 0) {
			System.out.println(-1);
			return;
		}
		f = 0;
		h = 0;
		for (int i = 0; i < length; ++i) {
			if (s[i] == '(') {
				f++;
			} else if (s[i] == ')') {
				++h;
			} else {
				h += t;
				str.append(t);
			}
			if (h > f) {
				System.out.println(-1);
				return;
			}
		}

		System.out.println(str);

	}
}