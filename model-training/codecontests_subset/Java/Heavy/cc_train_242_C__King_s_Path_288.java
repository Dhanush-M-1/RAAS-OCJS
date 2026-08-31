import java.util.*;
import java.io.*;


public class B {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int sx = in.nextInt();
		int sy = in.nextInt();
		int ex = in.nextInt();
		int ey = in.nextInt();

		int minX, minY, maxX, maxY;
		minX = minY = Integer.MAX_VALUE;
		maxX = maxY = 0;


		HashMap<Integer, Vector<Pair>> map = new HashMap();
		int tmp = in.nextInt();
		for(int i = 0 ; i < tmp; i++) {
			int r = in.nextInt();
			int sc = in.nextInt();
			int ec = in.nextInt();

			minX = Math.min(r, minX);
			maxX = Math.max(r, maxX);
			minY = Math.min(minY, Math.min(sc, ec));
			maxY = Math.max(maxY, Math.max(sc, ec));

			Pair p = new Pair(sc, ec);
			if(map.get(r) == null) {map.put(r, new Vector<Pair>());}
			map.get(r).add(p);
		}


		// BFS  
		TreeSet<Pair> vis = new TreeSet();
		ArrayDeque<Triple> q = new ArrayDeque();
		q.offer(new Triple(sx, sy, 0));
		int ans = Integer.MAX_VALUE;
		while(!q.isEmpty()) {
			Triple t = q.poll();
			if(vis.contains(new Pair(t.f, t.s))) continue;
			vis.add(new Pair(t.f, t.s));

			int x = t.f;
			int y = t.s;



			if(x == ex && y == ey) {
				ans = Math.min(ans, t.t);
				continue;
			}


			for(int i = -1; i <= 1; i++) {
				for(int j = -1; j <= 1; j++) {
					if(i == 0 && j == 0) continue;
					int xx = x+i;
					int yy = y+j;

					//System.err.println(xx+" "+yy);

					if(xx < minX || xx > maxX || y < minY || y > maxY) continue;		// invalid Cell

					if(xx == ex && yy == ey) {
						ans = Math.min(ans, t.t+1);
						continue;
					}

					// check if cell is allowed 
					if(map.get(xx) == null) continue;
					for(Pair p : map.get(xx)) {
						if(p.include(yy)) {
							q.offer(new Triple(xx, yy, t.t+1));
							break;
						}
					}
				}
			}

		}

		System.out.println(ans == Integer.MAX_VALUE ? "-1": ans);

	}
}


class Pair implements Comparable<Pair>{
	int f, s;
	public Pair(int f, int s) {
		this.f = f;
		this.s = s;
	}


	public boolean include(int y) {
			if(y >= f && y <= s) return true;
			return false;
	}

	@Override
	public boolean equals(Object o) {
		Pair p = (Pair) o;
		if(this.f == p.f && this.s == p.s) return true;
		return false;
	}

	@Override
	public int compareTo(Pair p) {
		if(this.f != p.f) return this.f  - p.f;
		return this.s - p.s;
	}

}

class Triple {
	int f, s, t;

	public Triple(int f, int s, int t) {
		this.f = f;
		this.s = s;
		this.t = t;
	}
}