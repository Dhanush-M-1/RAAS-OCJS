import java.util.Scanner;

public class A {
	public static void main(String... g) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		String z = s.next();
		if (ok(z)) {
			System.out.println(1);
			System.out.println(z);
		} else {
			for (int i = 0; i < z.length(); i++) {
				String a = z.substring(0, i);
				String b = z.substring(i);
				if (ok(a) && ok(b)) {
					System.out.println(2);
					System.out.println(a + " " + b);
					return;
				}
			}
		}
	}

	static boolean ok(String z) {
		int a = 0, b = 0;
		for (char c : z.toCharArray()) {
			if (c == '0') {
				a++;
			} else {
				b++;
			}
		}
		return a != b;
	}
}
