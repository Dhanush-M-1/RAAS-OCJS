import java.util.Scanner;

public class Main {
	public static int N;
	public static String str;

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		str = s.next();
		N = str.length();
		int last = -1;
		int right = 0;
		for (int i = N - 1; i >= 0; i--) {
			if (str.charAt(i) == '#') {
				last = i;
				break;
			} else if (str.charAt(i) == '(') {
				right--;
			} else {
				right++;
			}
			if (right < 0) {
				System.out.println(-1);
				return;
			}
		}
		int curr = 0;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < last; i++) {
			if (str.charAt(i) == '(') {
				curr++;
			} else if (str.charAt(i) == ')') {
				curr--;
			} else {
				curr--;
				sb.append("1").append("\n");
			}
			if (curr < 0) {
				System.out.println(-1);
				return;
			}
		}
		if (curr <= right) {
			System.out.println(-1);
			return;
		}
		sb.append(curr - right).append("\n");
		System.out.print(sb.toString());
	}
}