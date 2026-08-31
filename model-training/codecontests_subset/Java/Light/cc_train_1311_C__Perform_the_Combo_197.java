import java.util.*;
import java.io.*;
public class combo {
	public static void main (String args[]) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int n = sc.nextInt();
		for (int i = 0; i < n; ++i) {
			int slen = sc.nextInt();
			int wlen = sc.nextInt();
			sc.nextLine();
			String s = sc.nextLine();
			int lol[] = new int[wlen];
			for (int j = 0; j < wlen; ++j) {
				lol[j] = sc.nextInt() - 1;
			}
			
			int prefix[] = new int[slen];
			for (int j = 0; j < wlen; ++j) {
				++prefix[lol[j]];
			}
			for (int j = prefix.length - 1; j > 0; --j) {
				prefix[j-1] += prefix[j];
			}
			//System.out.println(Arrays.toString(prefix));
			int res[] = new int[26];
			for (int j = 0; j < slen; ++j) {
				res[s.charAt(j)-'a'] += prefix[j] + 1;
			}
			for (int j : res) {
				System.out.print(j + " ");
			}
			System.out.println();
			//System.out.println(Arrays.toString(res));
		}
	}
}
