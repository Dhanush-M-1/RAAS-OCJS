import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Enumeration;
import java.util.Hashtable;

public class KString_219A {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int k = new Integer(br.readLine());
		String input = br.readLine();
		Hashtable<Character, Integer> map = new Hashtable<>();
		for (int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);
			if (map.containsKey(c))
				map.put(c, map.remove(c) + 1);
			else
				map.put(c, 1);
		}
		Enumeration<Character> keys = map.keys();
		String res = "";
		boolean flag = true;
		while (keys.hasMoreElements()) {
			char cur = keys.nextElement();
			int val = map.get(cur);
			if (val % k != 0) {
				flag = false;
				break;
			} else
				for (int i = 0; i < val / k; i++)
					res += cur;
			// System.out.println(res);
		}
		if (!flag)
			System.out.println(-1);
		else {
			String tmp = res;
			for (int i = 0; i < k - 1; i++) {
				tmp += res;
			}
			System.out.println(tmp);
//			System.out.println(res);
		}

	}

}
