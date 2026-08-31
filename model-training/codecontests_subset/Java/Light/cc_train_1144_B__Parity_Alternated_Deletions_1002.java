import java.util.*;

public class Basioni {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] l = new int[n];
		int odd = 0;
		int even = 0;
		for (int i = 0; i < n; i++) {
			int x = sc.nextInt();
			if (x % 2 == 0)
				even++;
			else
				odd++;
			l[i] = x;
		}
		if (odd == even || (int) Math.abs(odd - even) == 1) {
			System.out.println(0);
		} else {
			int d = Math.abs(odd - even) - 1;
			Arrays.sort(l);
			int i = 0;
			int c = 0;
			if (odd > even) {
				for (int j = 0; j < l.length && i < d; j++) {
					if (l[j] % 2 == 1) {
						i++;
						c += l[j];
					}

				}
			} else {
				for (int j = 0; j < l.length && i < d; j++) {
					if (l[j] % 2 == 0) {
						i++;
						c += l[j];
					}

				}
			}
			System.out.println(c);

		}

	}

	// بسيوني هو البابا
}
