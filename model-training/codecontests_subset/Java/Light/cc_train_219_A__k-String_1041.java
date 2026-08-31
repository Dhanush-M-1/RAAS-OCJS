

import java.util.Scanner;

public class K_STRING {

	public static void main(String[] args) {

		Scanner r = new Scanner(System.in);
		String ans = "";
		int n = r.nextInt();
		String s = r.next();
		int a[] = new int[26];
		for (int i = 0; i < s.length(); i++) {
			a[s.charAt(i) - 'a']++;
		}
		for (int i = 0; i < 26; i++) {
			if (a[i] % n != 0) {
				System.out.println("-1");
				return;
			}
		}
		for (int i = 0; i < 26; i++) {
			for (int j = 0; j < a[i] / n; j++)
				ans = ans + (char) (i + 97);
		}
		for (int i = 0; i < n; i++) {
			System.out.print(ans);
		}

	}

}
