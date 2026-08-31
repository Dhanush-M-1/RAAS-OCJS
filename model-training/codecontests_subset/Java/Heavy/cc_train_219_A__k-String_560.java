import java.util.*;
import java.io.*;

public class codeforces {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int k = sc.nextInt();
		String s = sc.next();
		Map<Character, Integer> hm = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			hm.put(s.charAt(i), hm.getOrDefault(s.charAt(i), 0) + 1);
		}
		for (Integer val : hm.values()) {
			if (val % k != 0) {
				System.out.println("-1");
				return;
			}
		}
		String tmp = "";
		for (Character c : hm.keySet()) {
			int freq = hm.get(c);
			for (int i = 0; i < freq / k; i++) {
				tmp += c;
			}
		}
		String res = "";
		for (int i = 0; i < k; i++) {
			res += tmp;
		}
		System.out.println(res);
		sc.close();
		return;
	}
}