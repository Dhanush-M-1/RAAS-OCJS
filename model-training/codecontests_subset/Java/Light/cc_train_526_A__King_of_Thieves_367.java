import java.util.Scanner;

public class KingOfThieves {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		String scheme = in.next();
		boolean good = false;
		for (int i = 0; i < n; i++) {
			for (int j = 1; i + (4 * j) < n; j++) {
				if (scheme.charAt(i) == '*' && scheme.charAt(i + j) == '*' && scheme.charAt(i + (2 * j)) == '*'
						&& scheme.charAt(i + (3 * j)) == '*' && scheme.charAt(i + (4 * j)) == '*')
					good = true;
			}
		}

		if (good)
			System.out.println("yes");
		else
			System.out.println("no");

		in.close();
	}

}
