import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class AkString {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		int k = scan.nextInt();

		String s = scan.next();

		String result = "";

		boolean check = true;

		char[] word = s.toCharArray();

		Arrays.sort(word);
		
		for (int i = 0; i < word.length; i += k) {
			result += String.valueOf(word[i]);
			if (check == false) {
				break;
			}
			for (int j = 0; j < k; j++) {
				if (word[i] != word[i + j] || word.length % k != 0) {
					System.out.println(-1);
					check = false;
					break;
				} else {
					continue;
				}
			}
		}

		if (check == true) {
			System.out.println(String.join("", Collections.nCopies(k, result)));
		}

		scan.close();
	}

}
