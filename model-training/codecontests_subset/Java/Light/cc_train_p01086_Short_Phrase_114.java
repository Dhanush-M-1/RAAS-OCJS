import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.Integer.parseInt;

public class Main {

	static final int CHARS = 31;
	static final int[] WORDS = new int[]{5, 7, 5, 7, 7};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line;
//		String[] words;

		while ((line = br.readLine()) != null && !line.isEmpty()) {

			int n = parseInt(line);
			if (n == 0) break;

			int[] words = new int[n + 1];
			for (int i = 1; i <= n; i++) {
				words[i] = br.readLine().length();
				words[i] += words[i - 1];
			}

			int k = 0;
			outer:
			for (int i = 1; i <= n; i++) {
				for (int j = n; j >= i; j--) {
					if (words[j] - words[i - 1] == CHARS) {
						//check
						if (check(words, i, j)) {
							k = i;
							break outer;
						}
					}
				}
			}
			System.out.println(k);
		} //end while
	} //end main

	static boolean check(int[] words, int from, int to) {
		boolean ret = true;
		int _j = from;
		for (int i = 0; i < WORDS.length; i++) {
			for (int j = _j; j <= to; j++) {
				int len = words[j] - words[_j - 1];
				if (len == WORDS[i]) {
					_j = j + 1;
					break;
				} else if (len > WORDS[i]) {
					ret &= false;
				}
			}
		}
		return ret;
	}
}