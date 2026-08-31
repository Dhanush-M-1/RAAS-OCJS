import java.util.Scanner;

public class Main {

	public void solve() {
		Scanner sc = new Scanner(System.in);

		char[] string = sc.next().toCharArray();
		String sA = sc.next();
		String sB = sc.next();

		char[] a;
		char[] b;

		if (sA.length() < sB.length()) {
			a = sA.toCharArray();
			b = sB.toCharArray();
		} else {
			a = sB.toCharArray();
			b = sA.toCharArray();
		}

		int[] sNum = new int[26];
		for (int i = 0; i < string.length; i++) {
			sNum[string[i] - 'a']++;
		}
		int[] aNum = new int[26];
		for (int i = 0; i < a.length; i++) {
			aNum[a[i] - 'a']++;
		}
		int[] bNum = new int[26];
		for (int i = 0; i < b.length; i++) {
			bNum[b[i] - 'a']++;
		}

		StringBuilder ans = new StringBuilder();
		int amax = Integer.MAX_VALUE;
		for (int i = 0; i < 26; i++) {
			if (aNum[i] == 0) {
				continue;
			}
			amax = Math.min(amax, sNum[i] / aNum[i]);
		}

		int[] scopy = new int[26];
		int amaxcnt = 0;
		int totalmax = 0;
		for (int acnt = 0; acnt <= amax; acnt++) {
			for (int i = 0; i < 26; i++) {
				scopy[i] = sNum[i] - aNum[i] * acnt;
			}
			int bmin = Integer.MAX_VALUE;

			for (int i = 0; i < 26; i++) {
				if (bNum[i] == 0) {
					continue;
				}
				bmin = Math.min(bmin, scopy[i] / bNum[i]);
			}
			if (bmin + acnt > totalmax) {
				totalmax = bmin + acnt;
				amaxcnt = acnt;
			}
		}

		for (int i = 0; i < amaxcnt; i++) {
			ans.append(String.valueOf(a));
		}
		for (int i = 0; i < 26; i++) {
			sNum[i] -= aNum[i] * amaxcnt;
		}

		int min = Integer.MAX_VALUE;
		for (int i = 0; i < 26; i++) {
			if (bNum[i] == 0) {
				continue;
			}
			min = Math.min(min, sNum[i] / bNum[i]);
		}
		for (int i = 0; i < min; i++) {
			ans.append(String.valueOf(b));
		}
		for (int i = 0; i < 26; i++) {
			sNum[i] -= bNum[i] * min;
		}
		for (int i = 0; i < 26; i++) {
			char c = (char) (i + 'a');
			for (int j = 0; j < sNum[i]; j++) {
				ans.append(c);
			}
		}
		System.out.println(ans.toString());
	}

	public static void main(String[] args) {
		new Main().solve();
	}
}