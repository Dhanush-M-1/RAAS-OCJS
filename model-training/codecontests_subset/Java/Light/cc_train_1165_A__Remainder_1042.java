import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int x = sc.nextInt();
		int y = sc.nextInt();
		String s = sc.next();
		int count = 0;
		StringBuffer sb = new StringBuffer();
		for (int i = s.length() - 1; i >= s.length() - x; i--) {
			sb.append(s.charAt(i));
		}
		for (int i = 0; i < sb.length(); i++) {
			if (i < y && sb.charAt(i) == '1')
				++count;
			if (i == y && sb.charAt(i) == '0')
				++count;
			if (i > y && sb.charAt(i) == '1')
				++count;
		}
		System.out.println(count);

	}
}
