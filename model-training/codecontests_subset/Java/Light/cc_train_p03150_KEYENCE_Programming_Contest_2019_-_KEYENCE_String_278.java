import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String S = sc.nextLine();
		String K = "keyence";

		String k[] = new String[K.length()];
		String s[] = new String[S.length()];

		boolean ans = true;

		for (int i = 0; i < K.length(); i++) {
			k[i] = K.substring(i, i+1);
		}
		for (int i = 0; i < S.length(); i++) {
			s[i] = S.substring(i, i+1);

		}

		for (int i = 0; i < 7; i++) {
			if (!s[i].equals(k[i])) {
				for (int j = 0; j < 7 - i; j++) {
					if (!s[S.length()-1-j].equals(k[6-j])) {
						ans = false;
					}
				}
			}

		}

		if (ans) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
	}

}
