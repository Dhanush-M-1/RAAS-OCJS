import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.*;
 
public class main {
	static HashMap<Point,Boolean> hs= new HashMap<>();
	static int xi,xf,yi,yf;
	static int[] dx = { 1,1,1, 0,0,-1,-1,-1};
	static int[] dy = {-1,0,1,-1,1,-1, 0, 1};
	static int bfs() {
		Queue<Point> q = new LinkedList<Point>();
		q.add(new Point(xi,yi));
		int level = -1;
		while (!q.isEmpty()) {
			int qs = q.size();
			level++; 
			while (qs-->0) {
				Point p = q.poll();
				int x = p.x; int y=p.y;
				if (x==xf&&y==yf) {
					return level;
				}
				for (int i=0;i<8;i++) {
					int nx = x+dx[i];
					int ny = y+dy[i];
					Point np = new Point(nx,ny);
					if (hs.containsKey(np) && !hs.get(np)){
//						System.out.println((np.x)+" "+(np.y));
						hs.put(np, true);
						q.add(np);
					}
				}//edn for i
			}
			
		}
		return -1;
	}
	public static void main(String[] args) throws Exception{
	Scanner sc  = new Scanner(System.in);
		xi = sc.nextInt();
		yi = sc.nextInt();
		xf = sc.nextInt();
		yf = sc.nextInt();
		int n = sc.nextInt();;
		while (n-->0) {
			int r = sc.nextInt();
			int a = sc.nextInt();
			int b = sc.nextInt();
			for (int i=a;i<=b;i++) {
				hs.put(new Point(r,i),false);
			}
		}
		System.out.print(bfs());
		
	}
}