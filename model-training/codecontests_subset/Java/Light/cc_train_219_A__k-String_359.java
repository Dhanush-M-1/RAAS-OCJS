import java.util.Collections;
import java.util.Scanner;

public class KString {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int z = scan.nextInt();
		String r = scan.next();
		int p[] = new int[26];
		for (int i = 0; i < r.length(); i++) {
			p[r.charAt(i) - 'a'] = p[r.charAt(i) - 'a'] + 1;
		}

		// for (int i = 0; i < p.length; i++) { System.out.println(p[i]); }

		int i = 0;
		int j = 0;
		String re = "";
		for (; j < p.length; j++) {
			if (p[j] % z != 0) {
				break;
			} else if (p[j] > 0 && p[j] % z == 0) {
				String s = "" + ((char) (j + 'a'));
				re = re + String.join("", Collections.nCopies(p[j] / z, s));// IntStream.range(0, n).mapToObj(m
			}
		}
		if (j != p.length) {
			System.out.println("-1");
		} else {
			for (i = 0; i < z; i++) {

				System.out.print(re);
			}
		}

	}
}
