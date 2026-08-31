import java.util.*;
import java.io.*;

public class Main{

	public void run(){
		Scanner in = new Scanner(System.in);
		int xs = in.nextInt();
		int ys = in.nextInt();
		int xf = in.nextInt();
		int yf = in.nextInt();

		HashSet<Long> set = new HashSet<Long>();
		int n = in.nextInt();
		for(int i=0;i<n;i++){
			int r = in.nextInt();
			int x = in.nextInt();
			int y = in.nextInt();
			for(int j=x;j<=y;j++)
				set.add(toLong(r, j));
		}

		Queue<Long> q = new LinkedList<Long>();
		q.add(toLong(xs, ys));
		HashMap<Long, Integer> map = new HashMap<Long, Integer>();
		map.put(toLong(xs, ys), 0);

		while(q.size() > 0){
			long coor = q.poll();
			int dis = map.get(coor);

			if (coor/p == xf && coor%p == yf){
				System.out.println(dis);
				return;
			}
			long x = coor/p;
			long y = coor%p;
			for(int i=0;i<di.length;i++){
				long c = toLong(x + di[i], y + dj[i]);
				if (!map.containsKey(c) && set.contains(c)){
					q.add(c);
					map.put(c, dis + 1);
				}
			}
		}
		System.out.println(-1);
	}

	long p = 1 << 30;
	private long toLong(long x, long y){
		return p * x + y;
	}

	private int di[] = new int[]{-1, -1, 0, 1, 1, 1, 0, -1};
	private int dj[] = new int[]{0, 1 ,1, 1, 0, -1, -1, -1};

	public static void main(String args[]){
		new Main().run();
	}
}