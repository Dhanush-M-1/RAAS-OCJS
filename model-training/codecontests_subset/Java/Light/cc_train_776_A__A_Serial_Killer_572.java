import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class A {
	private void work() {
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		String a = sc.next();
		String b = sc.next();
		System.out.printf("%s %s\n", a, b);
		int n = sc.nextInt();
		while (n-- > 0) {
			String k = sc.next();
			String r = sc.next();
			if (a.equals(k))
				a = r;
			else
				b = r;
			System.out.printf("%s %s\n", a, b);
		}
		sc.close();
	}

	public static void main(String[] args) {
		new A().work();
	}

}
