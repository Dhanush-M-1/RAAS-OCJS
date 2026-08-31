import java.util.Arrays;
import java.util.Scanner;

public class performTheCombo {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		StringBuilder finalAns = new StringBuilder();
		while (--t >= 0) {
			int n = sc.nextInt(), m = sc.nextInt();
			int pref[] = new int[n];
			String s = sc.next();
			int freq[] = new int[26];
			for (int i = 0; i < m; i++) {
				pref[sc.nextInt() - 1]++;
			}
			pref[n - 1]++;
			for (int i = n - 1; i > 0; i--) {
				pref[i - 1] += pref[i];
				freq[s.charAt(i) - 'a'] += pref[i];
			}
			freq[s.charAt(0) - 'a'] += pref[0];
			for (int i = 0; i < 26; i++) {
				finalAns.append(freq[i] + " ");
			}
			finalAns.append('\n');
		}
		System.out.print(finalAns);
	}
}
