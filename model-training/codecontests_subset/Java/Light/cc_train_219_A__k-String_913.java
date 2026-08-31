import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Scanner;

public class kString {

	public static boolean exists(LinkedList<Character> ls, char c) {
		for (int i = 0; i < ls.size(); i++) {
			if (ls.get(i) == c)
				return true;
		}
		return false;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		String s = in.next();
		LinkedList<Character> ls = new LinkedList<Character>();
		Hashtable<Character, Integer> ht = new Hashtable<Character, Integer>();
		for (int i = 0; i < s.length(); i++) {
			if (!exists(ls, s.charAt(i))) {
				ht.put(s.charAt(i), 1);
				ls.add(s.charAt(i));
			} else
				ht.put(s.charAt(i), ht.get(s.charAt(i)) + 1);
		}
		boolean flag = false;
		String res = "";
		for (int i = 0; i < ls.size(); i++) {
			if (ht.get(ls.get(i)) % n != 0) {
				flag = true;
				break;
			}
			for (int k = 0; k < ht.get(ls.get(i)) / n; k++) {
				res += ls.get(i);
			}
		}

		if (flag)
			System.out.println(-1);
		else {
			String fres = "";
			for (int k = 0; k < s.length() / res.length(); k++) {
				fres += res;
			}
			System.out.println(fres);
		}
	}
}