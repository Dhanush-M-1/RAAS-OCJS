import java.util.*;

public class Solution {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		String result = "YES";
		int nabl = 3;
		Set<Integer> players = new HashSet<>();
		players.add(1);
		players.add(2);
		for(int i = 0; i < n; i++) {
			int a = scan.nextInt();
			if(!players.contains(a)) {
				result = "NO";
				break;
			}
			int loser = 0;
			for(Integer elem : players) {
				if(!elem.equals(a)) loser = elem;
			}
			players.add(nabl);
			players.remove(loser);
			nabl = loser;
		}
		System.out.println(result);
	}
}
