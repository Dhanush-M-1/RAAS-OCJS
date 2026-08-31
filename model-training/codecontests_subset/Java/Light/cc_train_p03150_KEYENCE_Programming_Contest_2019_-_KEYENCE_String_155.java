import java.util.Scanner;

public class Main {

	public static void main(String... args) {

		Scanner sc = new Scanner(System.in);

		String str = sc.next();
		sc.close();



		if (str.matches("k.*eyence")) {
			System.out.println("YES");
			return;
		}

		if (str.matches("ke.*yence")) {
			System.out.println("YES");
			return;
		}

		if (str.matches("key.*ence")) {
			System.out.println("YES");
			return;
		}

		if (str.matches("keye.*nce")) {
			System.out.println("YES");
			return;
		}

		if (str.matches("keyen.*ce")) {
			System.out.println("YES");
			return;
		}

		if (str.matches("keyenc.*e")) {
			System.out.println("YES");
			return;
		}

		if (str.matches(".*keyence")) {
			System.out.println("YES");
			return;
		}

		if (str.matches("keyence.*")) {
			System.out.println("YES");
			return;
		}

		System.out.println("NO");
	}
}
