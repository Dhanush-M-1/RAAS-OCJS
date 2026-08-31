import java.util.Scanner;
import java.util.TreeMap;

/*
 3
 3 2 2
 4
 2 2 2 2
 3
 1000000000 1000000000 1000000000
 4
 1000000000 1000000000 1000000000 1000000000
 3
 4 4 4
 */
public class c {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int people = in.nextInt();

		TreeMap<Integer, Integer> ps = new TreeMap<Integer, Integer>();

		for (int i = 0; i < people; i++) {
			int games = in.nextInt();
			int toPlace = 1;
			if (ps.containsKey(games))
				toPlace += ps.get(games);
			ps.put(games, toPlace);
		}

		long min = 1;
		long max = Integer.MAX_VALUE;
		while (min < max) {
			long mid = (min + max) >> 1;
			long used = 0;
			for (int gamesWanted : ps.keySet()) {
				if (gamesWanted > mid) {
					used = 0;
					break;
				} else {
					used += (mid - gamesWanted) * ps.get(gamesWanted);
				}
			}
			if (used >= mid) {
				max = mid;
			} else {
				min = mid + 1;
			}
		}
		System.out.println(min);
	}
}
