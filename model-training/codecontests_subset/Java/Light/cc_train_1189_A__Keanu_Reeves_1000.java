import java.util.Scanner;

public class A {
	public static boolean check(String s) {
		int ones = 0, zeroes = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '1') ones++;
			else zeroes++;
		}
		return !(ones == zeroes);
	}

	public static void find(String s) {
		int inx = 1;
		while (!(check(s.substring(0, inx)) && check(s.substring(inx)))) {
			inx++;
		}
		System.out.println(s.substring(0, inx) + " " + s.substring(inx, s.length()));
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String s = sc.next();
		if (check(s)) {
			System.out.println(1);
			System.out.println(s);
		} else {
			System.out.println(2);
			find(s);
		}
	}
}