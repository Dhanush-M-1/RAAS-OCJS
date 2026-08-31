import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner s = new Scanner(System.in);
		String str = s.nextLine();
		char[] strKeyence = { 'k', 'e', 'y', 'e', 'n', 'c', 'e' };

		int backEnd = -1;
		for (int i = 0; i < strKeyence.length; i++) {
			if (strKeyence[i] != str.charAt(i)) {
				backEnd = i;
				break;
			}
			if (i == strKeyence.length - 1) {
				System.out.println("YES");
				return;
			}
		}

		boolean checkKeyence = true;
		for (int j = strKeyence.length - 1; j >= backEnd; j--) {
			int backId = str.length() - 1 + j - (strKeyence.length - 1);
			if (strKeyence[j] != str.charAt(backId))
				checkKeyence = false;
		}

		if (checkKeyence)
			System.out.println("YES");
		else
			System.out.println("NO");
	}
}
