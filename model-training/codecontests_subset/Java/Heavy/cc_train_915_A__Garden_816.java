
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

public class Solution {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String s[] = br.readLine().split(" ");
		int n = Integer.parseInt(s[0]);
		int k = Integer.parseInt(s[1]);
		ArrayList<Integer> a = new ArrayList(n);
		String s1[] = br.readLine().split(" ");

		Set<Integer> set = new TreeSet();
		div(k, set);
		for (int i = 0; i < n; i++) {
			a.add(Integer.parseInt(s1[i]));
		}
		Collections.sort(a, Collections.reverseOrder());
		for (Integer i : a) {
			if (set.contains(i)) {
				System.out.println(k / i);
				break;
			}
		}

	}

	static void div(int n, Set<Integer> div) {
		div.add(1);
		div.add(n);
		for (int i = 2; i <= Math.sqrt(n); i++) {
			if (n % i == 0) {
				div.add(i);
				div.add(n / i);
			}
		}
	}

}
