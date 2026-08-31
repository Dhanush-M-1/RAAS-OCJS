import java.util.*;

public class Main {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		HashMap<String, Integer> map = new HashMap<>();
		String[] ans = new String[]{"AC", "WA", "TLE", "RE"};
		for (String s : ans) {
		    map.put(s, 0);
		}
		for (int i = 0; i < n; i++) {
		    String s = sc.next();
		    map.put(s, map.get(s) + 1);
		}
		StringBuilder sb = new StringBuilder();
		for (String s : ans) {
		    sb.append(s).append(" x ").append(map.get(s)).append("\n");
		}
		System.out.print(sb);
	}
}
