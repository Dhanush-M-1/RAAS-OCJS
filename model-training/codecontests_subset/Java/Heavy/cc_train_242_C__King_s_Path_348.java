import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
	public static final int MAX = (int) (1e9);
	public static int sr, sc, er, ec, N;
	public static HashMap<Integer, ArrayList<segment>> map = new HashMap<Integer, ArrayList<segment>>();
	public static final int[] dr = new int[] { -1, 0, 1, -1, 1, -1, 0, 1 };
	public static final int[] dc = new int[] { -1, -1, -1, 0, 0, 1, 1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(f.readLine());
		sr = Integer.parseInt(st.nextToken());
		sc = Integer.parseInt(st.nextToken());
		er = Integer.parseInt(st.nextToken());
		ec = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(f.readLine());
		for (; N > 0; N--) {
			st = new StringTokenizer(f.readLine());
			int row = Integer.parseInt(st.nextToken());
			int l = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			if (!map.containsKey(row)) {
				map.put(row, new ArrayList<segment>());
			}
			map.get(row).add(new segment(l, r));
		}
		System.out.println(bfs());
	}

	public static int bfs() {
		int curr = 0;
		ArrayDeque<node> queue = new ArrayDeque<node>();
		HashSet<node> set = new HashSet<node>();
		queue.offer(new node(sr, sc));
		set.add(new node(sr, sc));
		while (!queue.isEmpty()) {
			ArrayDeque<node> temp = new ArrayDeque<node>();
			while (!queue.isEmpty()) {
				node n = queue.poll();
				if (n.r == er && n.c == ec) {
					return curr;
				}
				for (int d = 0; d < 8; d++) {
					int nextR = n.r + dr[d];
					int nextC = n.c + dc[d];
					if (!valid(nextR, nextC) || !allowed(nextR, nextC) || set.contains(new node(nextR, nextC)))
						continue;
					set.add(new node(nextR, nextC));
					temp.offer(new node(nextR, nextC));
				}
			}
			curr++;
			queue.addAll(temp);
		}
		return -1;
	}

	public static boolean allowed(int r, int c) {
		if (!map.containsKey(r)) {
			return false;
		}
		for (segment s : map.get(r)) {
			if (s.l <= c && s.r >= c) {
				return true;
			}
		}
		return false;
	}

	public static boolean valid(int r, int c) {
		return r >= 1 && r <= MAX && c >= 1 && c <= MAX;
	}
}

class segment {
	public int l, r;

	public segment(int a, int b) {
		l = Math.min(a, b);
		r = Math.max(a, b);
	}
}

class node {
	public int r, c;

	public node(int a, int b) {
		r = a;
		c = b;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + c;
		result = prime * result + r;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		node other = (node) obj;
		if (c != other.c)
			return false;
		if (r != other.r)
			return false;
		return true;
	}

}