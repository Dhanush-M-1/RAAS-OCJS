import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*package whatever //do not write package name here */

public final class Solution {
	public static void main(String[] args) throws IOException {

		BufferedReader bi = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(bi.readLine());
		while (t > 0) {
			String s[] = bi.readLine().split(" ");
			int a = Integer.parseInt(s[0]);
			int b = Integer.parseInt(s[1]);
			int n = Integer.parseInt(s[2]);
			int c = a ^ b;
			int rem = (n % 3);
			int ans = rem == 0 ? a : rem == 1 ? b : c;
			System.out.println(ans);
			t--;
		}
	}

}