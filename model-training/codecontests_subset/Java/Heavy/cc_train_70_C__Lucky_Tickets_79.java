import java.io.*;
import java.util.*;

/**
 * Codeforces Beta Round #64 (Div. 1), C
 * @author Roman Kosenko <madkite@gmail.com>
 */
public class LuckyTickets64 {
	public static void main(String[] args) throws IOException {
		if(!Boolean.parseBoolean(System.getProperty("ONLINE_JUDGE")))
			System.setIn(new FileInputStream(new File("input.txt")));
		Scanner s = new Scanner(System.in);
		int maxx = s.nextInt(), maxy = s.nextInt(), w = s.nextInt();

		long[] a = new long[Math.max(maxx, maxy) + 1];
		Map<Long, List<Integer>> map = new HashMap<Long, List<Integer>>(2 * a.length);
		for(int i = 1; i < a.length; i++) {
			int r = 0, gcd = i;
			for(int j = i; j > 0; j /= 10)
				r = r * 10 + j % 10;
			for(int j = r; j != 0;)
				j = gcd % (gcd = j);
			List<Integer> list = map.get(a[i] = (long)i / gcd << 32 | r / gcd);
			if(list == null)
				map.put(a[i], list = new LinkedList<Integer>());
			list.add(i);
		}

		long rx = maxx + 1, ry = maxy;
		Queue<Integer> queue = new PriorityQueue<Integer>(w + 1);
		for(int x = 1; x <= maxx; x++) {
			List<Integer> list = map.get(a[x] << 32 | a[x] >>> 32);
			if(list == null)
				continue;
			for(int y : list) {
				if(y > maxy)
					break;
				queue.offer(-y);
				if(queue.size() > w)
					queue.poll();
			}
			if(queue.size() == w) {
				long h = -queue.peek();
				if(x * h < rx * ry) {
					rx = x;
					ry = h;
				}
			}
		}
		System.out.println(rx <= maxx ? rx + " " + ry : "-1");
	}
}
