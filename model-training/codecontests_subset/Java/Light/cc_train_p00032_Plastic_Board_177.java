import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		int tyouhoukei = 0;
		int hishigata = 0;

		while (sc.hasNext()) {
			String[] s = sc.nextLine().split(",");

			int a = Integer.parseInt(s[0]);
			int b = Integer.parseInt(s[1]);
			int c = Integer.parseInt(s[2]);
			if (c * c == a * a + b * b) {
				tyouhoukei++;
			}
			if (a == b) {
				hishigata++;
			}
		}
		System.out.println(tyouhoukei);
		System.out.println(hishigata);
	}
}