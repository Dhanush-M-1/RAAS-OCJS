import java.util.*;
import java.io.*;

public class Codeforces {
	public static void main (String[] args) throws IOException {
		BufferedReader reader = new BufferedReader (new InputStreamReader (System.in));
		int k = Integer.parseInt (reader.readLine());
		String s = reader.readLine();
		int[] appear = new int[26];
		for (int ii = 0; ii < s.length(); ii++) {
			char temp = s.charAt(ii);
			appear[temp - 'a']++;
        }
		for (int ii = 0; ii < 26; ii++) {
			if (appear[ii] != 0 && appear[ii] % k != 0) {
				System.out.println ("-1");
				return;
            }
        }
		for (int ii = 0; ii < k; ii++) {
			for (int jj = 0; jj < 26; jj++) {
				if (appear[jj] != 0) {
					for (int kk = 0; kk < appear[jj] / k; kk++) {
						System.out.print ((char) ('a' + jj));
                    }
                }
            }
        }
		System.out.println ();
	}
}
