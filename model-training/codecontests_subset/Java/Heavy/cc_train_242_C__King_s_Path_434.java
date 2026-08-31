
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class KingsPath {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int x0 = sc.nextInt();
		int y0 = sc.nextInt();
		int x1 = sc.nextInt();
		int y1 = sc.nextInt();

		TreeMap<Integer,TreeSet<Integer>> map = new TreeMap<>();
		int n = sc.nextInt();
		while(n-->0)
		{
			int row = sc.nextInt();
			int l = sc.nextInt();
			int r = sc.nextInt();
			if(!map.containsKey(row))
				map.put(row, new TreeSet<>());
			for(int i=l;i<=r;i++)
				map.get(row).add(i);
		}
//		System.out.println(map);
		int[] dx = {0, 0, 1, -1 ,1,1,-1,-1};
		int[] dy = {1, -1, 0, 0,-1,1,-1,1};
		TreeMap<Integer,TreeSet<Integer>> vis = new TreeMap<>();
		Queue<Pair> q = new LinkedList<>();
		q.add(new Pair(x0,y0,0));
		long ans = -1;
		while(!q.isEmpty())
		{
			Pair now = q.poll();
			if(now.x == x1 && now.y == y1)
			{
				ans = now.cost;
				break;
			}
			
			for(int i=0;i<8;i++)
			{
				int xx = now.x+dx[i];
				int yy = now.y+dy[i];
				if(map.get(xx) != null && map.get(xx).contains(yy) && (vis.get(xx) == null ||  !(vis.get(xx).contains(yy))))
				{
					if(vis.get(xx) == null)
						vis.put(xx , new TreeSet<>());
					vis.get(xx).add(yy);
					q.add(new Pair(xx,yy,now.cost+1));
				}
			}
		}
		System.out.println(ans);
		

	}
	
	
	static class Pair{
		int x,y;
		long cost;
		public Pair(int a , int b , long c){
			x = a;
			y = b;
			cost = c;
		}
		public String toString(){
			return x + " " + y + " " + cost;
		}
	}
	
	
	static class Scanner{
		StringTokenizer st;BufferedReader br;
		public Scanner(InputStream s){	br = new BufferedReader(new InputStreamReader(s));}
		public String next() throws IOException 
		{while (st == null || !st.hasMoreTokens()) st = new StringTokenizer(br.readLine());return st.nextToken();}
		public int nextInt() throws IOException {return Integer.parseInt(next());}
		public long nextLong() throws IOException {return Long.parseLong(next());}
		public String nextLine() throws IOException {return br.readLine();}
		public double nextDouble() throws IOException {return Double.parseDouble(next());}
		public boolean ready() throws IOException {return br.ready();}
	}

}
