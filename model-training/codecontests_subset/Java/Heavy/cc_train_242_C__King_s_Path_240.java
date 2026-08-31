import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.*;
import javafx.util.Pair;

public class Kings_Path {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		int x0 = Integer.parseInt(s[0]);
		int y0 = Integer.parseInt(s[1]);
		int x1 = Integer.parseInt(s[2]);
		int y1 = Integer.parseInt(s[3]);
		int n = Integer.parseInt(br.readLine());

		HashMap<Pair<Integer, Integer>, Integer> map = new HashMap<>();
		for (int i = 0; i < n; i++) {
			String[] sl = br.readLine().split(" ");
			int r = Integer.parseInt(sl[0]);
			int a = Integer.parseInt(sl[1]);
			int b = Integer.parseInt(sl[2]);
			for (int j = a; j <= b; j++) {
				Pair<Integer,Integer> p = new Pair<Integer,Integer>(r, j);
				map.put(p, -1);
			}
		}
		int[][] dir = { { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, -1 }, { 0, 1 }, { 1, -1 }, { 1, 0 }, { 1, 1 } };
		LinkedList<Pair<Integer, Integer>> queue = new LinkedList<>();
		queue.addLast(new Pair<Integer,Integer>(x0, y0));
       map.put(new Pair<Integer,Integer>(x0,y0), 0);
		HashSet<Pair<Integer, Integer>> set = new HashSet<>();
		while (queue.size() > 0) {
			Pair<Integer, Integer> p = queue.removeFirst();
			
			for (int i = 0; i < 8; i++) {
				Pair<Integer, Integer> ps = new Pair(p.getKey() + dir[i][0], p.getValue() + dir[i][1]);
				if (map.containsKey(ps)) {
					if (map.get(ps) == -1) {
						map.put(ps, map.get(p) + 1);
						queue.addLast(ps);
					}
				}
			}

			if ((set.contains(p))) {
				continue;
			}
		}
		System.out.println(map.get(new Pair(x1,y1)));
	}

}
