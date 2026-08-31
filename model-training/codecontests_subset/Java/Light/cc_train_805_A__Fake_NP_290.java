import java.util.Scanner;

public class A {
	public static void main(String[] args) {
		try (Scanner s = new Scanner(System.in)) {
			final int l = s.nextInt();
			final int r = s.nextInt();
			if (l == r) {
				System.out.println(l);
			} else {
				System.out.println(2);
			}
		}
	}
}
