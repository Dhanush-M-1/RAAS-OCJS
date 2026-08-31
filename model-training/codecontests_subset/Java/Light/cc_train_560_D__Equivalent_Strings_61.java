import java.util.*;


public class SolveD {
	static HashMap<String, Boolean> map;
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String s1 = in.next();
		String s2 = in.next();
		map = new HashMap<>();
		System.out.println(check(s1, s2) ? "YES" : "NO");
	}
	public static boolean check(String a, String b) {
		if (a.length() % 2 == 1) {
			map.put(a + " " + b, a.equals(b));
			return a.equals(b);
		} else {
			if (!map.containsKey(a + " " + b)) {
				boolean val = (check(a.substring(0, a.length() / 2), b.substring(0, b.length() / 2)) && check(a.substring(a.length() / 2), b.substring(b.length() / 2)) || (check(a.substring(0, a.length() / 2), b.substring(b.length() / 2)) && check(a.substring(a.length() / 2), b.substring(0, b.length() / 2))));	
				map.put(a + " " + b, val); 
			}
			return map.get(a + " " + b);
		}
	}
}
